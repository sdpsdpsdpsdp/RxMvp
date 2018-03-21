package com.laisontech.basemvp.mvp;

import android.view.View;

/**
 * Created by SDP on 2018/3/21.
 */

public interface VDelegate {
    void resume();

    void pause();

    void destroy();

    void visible(boolean flag, View view);

    void gone(boolean flag, View view);

    void inVisible(View view);

    void toastShort(Object msg);

    void toastLong(Object msg);
}
