package com.laisontech.basemvp.mvp;

import android.os.Bundle;
import android.view.View;

/**
 * Created by SDP on 2018/3/21.
 */

public interface IView<P> {
    int getLayoutId();

    void bindUI(View rootView);

    void bindEvent();

    void initData(Bundle saveInstanceState);

    int getOptionsMenuId();


    boolean useEventBus();

    P newP();
}
