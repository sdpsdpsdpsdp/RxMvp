package com.laisontech.basemvp.mvp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by SDP on 2018/3/21.
 */

public class VDelegateBase implements VDelegate {
    private Context context;

    private VDelegateBase(Context context) {
        this.context = context;
    }

    public static VDelegate create(Context context) {
        return new VDelegateBase(context);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void visible(boolean flag, View view) {
        if (flag) view.setVisibility(View.VISIBLE);
    }

    @Override
    public void gone(boolean flag, View view) {
        if (flag) view.setVisibility(View.GONE);
    }

    @Override
    public void inVisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toastShort(Object msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void toastLong(Object msg) {
        toast(msg, Toast.LENGTH_LONG);
    }

    private void toast(Object msg, int duration) {
        String str = "";
        if (msg instanceof Integer) {
            str = context.getResources().getString((Integer) msg);
        } else if (msg instanceof String) {
            str = (String) msg;
        }
        Toast.makeText(context, str, duration).show();
    }
}
