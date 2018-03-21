package com.laisontech.basemvp.cache;

import android.content.Context;
import android.text.TextUtils;

import com.jakewharton.disklrucache.DiskLruCache;
import com.laisontech.basemvp.XDroidConf;
import com.laisontech.basemvp.utils.Codec;
import com.laisontech.basemvp.utils.Kits;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by SDP on 2018/3/21.
 * 磁盘的缓存
 */

public class DiskCache implements ICache {
    private DiskLruCache cache;
    private static String CREATE_TIME = "createTime_v";
    private static String EXPIRE_MILLS = "expireMills_v";
    private static String INDEX_CREATE_TIME = "=====createTime";
    static String TAG_CACHE = INDEX_CREATE_TIME + "{" + CREATE_TIME + "}expireMills{" + EXPIRE_MILLS + "}";
    static String REGEX = INDEX_CREATE_TIME + "\\{(\\d{1,})\\}expireMills\\{(-?\\d{1,})\\}";
    private Pattern compile;
    public static final long NO_CACHE = -1L;
    private static DiskCache instance;

    private DiskCache(Context context) {
        compile = Pattern.compile(REGEX);
        try {
            File cacheDir = Kits.Files.getDiskCacheDir(context, XDroidConf.CACHE_DISK_DIR);
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            cache = DiskLruCache.open(cacheDir, Kits.Package.getVersionCode(context)
                    , 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DiskCache getInstance(Context context) {
        if (instance == null) {
            synchronized (DiskCache.class) {
                if (instance == null) {
                    instance = new DiskCache(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    @Override
    public void put(String key, Object value) {
        put(key, value != null ? value.toString() : null, NO_CACHE);
    }

    public void put(String key, String value) {
        put(key, value, NO_CACHE);
    }

    public void put(String key, String value, long expireMills) {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return;
        }
        String name = getMd5Key(key);
        try {
            //先移除
            if (!TextUtils.isEmpty(name)) {
                cache.remove(name);
            }
            //加密添加
            DiskLruCache.Editor editor = cache.edit(name);
            StringBuilder content = new StringBuilder(value);
            content.append(TAG_CACHE.replace(CREATE_TIME, "" +
                    Calendar.getInstance().getTimeInMillis())
                    .replace(EXPIRE_MILLS, "" + expireMills));
            editor.set(0, content.toString());
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMd5Key(String key) {
        return Codec.MD5.getMessageDigest(key.getBytes());
    }

    @Override
    public Object get(String key) {
        try {
            String md5Key = getMd5Key(key);
            DiskLruCache.Snapshot snapshot = cache.get(md5Key);
            if (snapshot != null) {
                String content = snapshot.getString(0);

                if (!TextUtils.isEmpty(content)) {
                    Matcher matcher = compile.matcher(content);
                    long createTime = 0;
                    long expireMills = 0;
                    while (matcher.find()) {
                        createTime = Long.parseLong(matcher.group(1));
                        expireMills = Long.parseLong(matcher.group(2));
                    }
                    int index = content.indexOf(INDEX_CREATE_TIME);

                    if ((createTime + expireMills > Calendar.getInstance().getTimeInMillis())
                            || expireMills == NO_CACHE) {
                        return content.substring(0, index);
                    } else {
                        //过期
                        cache.remove(md5Key);       //删除
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        try {
            cache.remove(getMd5Key(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(String key) {
        try {
            DiskLruCache.Snapshot snapshot = cache.get(getMd5Key(key));
            return snapshot != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            cache.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
