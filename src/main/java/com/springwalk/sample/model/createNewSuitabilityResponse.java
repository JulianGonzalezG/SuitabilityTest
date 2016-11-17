package com.springwalk.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 28/10/2016.
 */
public class createNewSuitabilityResponse {

    private String idOrden;
    private String idBp;
    private RequestError error;

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getIdBp() {
        return idBp;
    }

    public void setIdBp(String idBp) {
        this.idBp = idBp;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }
}
