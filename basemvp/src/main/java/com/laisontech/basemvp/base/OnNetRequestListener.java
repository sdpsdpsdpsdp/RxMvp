package com.laisontech.basemvp.base;

/**
 * Created by SDP on 2018/3/21.
 */

public interface OnNetRequestListener<T> {
    void onRequestSuccess(T t);

    void onRequestFailed(String failedReason);
}
