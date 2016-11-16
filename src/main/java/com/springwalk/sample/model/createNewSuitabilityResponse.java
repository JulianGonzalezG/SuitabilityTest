package com.springwalk.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 28/10/2016.
 */
public class createNewSuitabilityResponse {

    private String idSuitabilityAvaloq;
    private RequestError error;
    private String status;

    public String getIdSuitabilityAvaloq() {
        return idSuitabilityAvaloq;
    }

    public void setIdSuitabilityAvaloq(String idSuitabilityAvaloq) {
        this.idSuitabilityAvaloq = idSuitabilityAvaloq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

}
