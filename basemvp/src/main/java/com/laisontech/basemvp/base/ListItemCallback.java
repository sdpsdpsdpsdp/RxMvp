package com.laisontech.basemvp.base;

/**
 * Created by SDP on 2018/3/20.
 * 布局回调
 */

public abstract class ListItemCallback<T> {
    public void onItemClick(int position,T model,int tag){}
    public void onItemLongClick(int position,T model,int tag){}
}
