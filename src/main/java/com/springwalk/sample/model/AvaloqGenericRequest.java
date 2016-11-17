package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 14/11/2016.
 */
public class AvaloqGenericRequest {
    private String service;
    private String content;
    private String bussinesUnit;
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
}
