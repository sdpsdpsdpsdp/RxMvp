package com.laisontech.basemvp.event;

/**
 * Created by SDP on 2018/3/21.
 */

public class BusProvider {
    private static RxBusImpl bus;

    public static RxBusImpl getBus() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                if (bus == null) {
                    bus = RxBusImpl.get();
                }
            }
        }
        return bus;
    }
}
