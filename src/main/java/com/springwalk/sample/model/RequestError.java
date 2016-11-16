package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 19/10/2016.
 */
public class RequestError {
    private String codError;
    private String descError;
    /**
     *
     * @return
     * The codError
     */
    public String getCodError() {
        return codError;
    }

    /**
     *
     * @param codError
     * The codError
     */
    public void setCodError(String codError) {
        this.codError = codError;
    }

    /**
     *
     * @return
     * The descError
     */
    public String getDescError() {
        return descError;
    }

    /**
     *
     * @param descError
     * The descError
     */
    public void setDescError(String descError) {
        this.descError = descError;
    }
}
