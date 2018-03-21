package com.laisontech.basemvp.event;

/**
 * Created by SDP on 2018/3/21.
 */

public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);


    interface IEvent {
        int getTag();
    }
}
