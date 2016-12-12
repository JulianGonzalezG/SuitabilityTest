package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 14/11/2016.
 */
public class AvaloqGenericRequest {
    private String service;
    private String content;
    private String bussinesUnit;
    private String codAppOrigen;
    private String codModAppOrigen;
    /**
     *
     * @return
     * The service
     */
    public String getService() {
        return service;
    }

    /**
     *
     * @param service
     * The service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     *
     * @return
     * The content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getBussinesUnit() {
        return bussinesUnit;
    }

    public void setBussinesUnit(String bussinesUnit) {
        this.bussinesUnit = bussinesUnit;
    }

    public String getCodAppOrigen() {
        return codAppOrigen;
    }

    public void setCodAppOrigen(String codAppOrigen) {
        this.codAppOrigen = codAppOrigen;
    }

    public String getCodModAppOrigen() {
        return codModAppOrigen;
    }

    public void setCodModAppOrigen(String codModAppOrigen) {
        this.codModAppOrigen = codModAppOrigen;
    }
}
