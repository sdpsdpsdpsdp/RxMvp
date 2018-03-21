package com.laisontech.basemvp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.droidlover.xrecyclerview.RecyclerAdapter;

/**
 * Created by SDP on 2018/3/21.
 */

public abstract class SimpleRecyclerAdapter<T, F extends RecyclerView.ViewHolder> extends RecyclerAdapter<T, F> {
    public SimpleRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public F onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getAdapterLayoutId(), parent, false);
        return newViewHolder(inflate);
    }

    protected abstract int getAdapterLayoutId();

    protected abstract F newViewHolder(View itemView);

}
