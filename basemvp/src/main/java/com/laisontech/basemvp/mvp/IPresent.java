package com.laisontech.basemvp.mvp;

/**
 * Created by SDP on 2018/3/21.
 * 用于处理view和model的传递
 */

public interface IPresent<V> {
    void attachV(V view);

    void detachV();
}
