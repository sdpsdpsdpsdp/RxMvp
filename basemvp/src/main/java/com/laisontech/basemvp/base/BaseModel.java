package com.laisontech.basemvp.base;

import com.laisontech.basemvp.net.IModel;

/**
 * Created by SDP on 2018/3/21.
 */

public class BaseModel implements IModel {
    protected boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return error;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
