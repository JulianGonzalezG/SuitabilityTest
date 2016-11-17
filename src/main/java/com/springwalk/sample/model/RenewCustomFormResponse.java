package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class RenewCustomFormResponse {

    private String idOrden;
    private String idOrdenHold;
    private RequestError error;

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idBP) {
        this.idOrden = idBP;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

    public String getIdOrdenHold() {
        return idOrdenHold;
    }

    public void setIdOrdenHold(String idOrdenHold) {
        this.idOrdenHold = idOrdenHold;
    }
}
