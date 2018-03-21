package com.laisontech.basemvp.cache;

/**
 * Created by SDP on 2018/3/21.
 * 缓存接口类
 */

public interface ICache {
    void put(String key, Object value);

    Object get(String key);

    void remove(String key);

    boolean contains(String key);

    void clear();
}
