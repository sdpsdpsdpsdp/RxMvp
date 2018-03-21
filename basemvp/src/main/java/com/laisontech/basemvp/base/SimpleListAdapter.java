package com.laisontech.basemvp.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by SDP on 2018/3/20.
 */

public abstract class SimpleListAdapter<T, H> extends XListAdapter<T> {
    public SimpleListAdapter(Context context) {
        super(context);
    }

    public SimpleListAdapter(Context context, ListItemCallback<T> callback) {
        super(context, callback);
    }

    public SimpleListAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        H holder;
        T item = data.get(position);
        if (convertView == null) {
            convertView = View.inflate(context, getAdapterLayoutId(), null);
            holder = newViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (H) convertView.getTag();
        }
        convert(holder, item, position);
        return convertView;
    }

    protected abstract int getAdapterLayoutId();

    protected abstract H newViewHolder(View convertView);

    protected abstract void convert(H holder, T item, int position);


}
