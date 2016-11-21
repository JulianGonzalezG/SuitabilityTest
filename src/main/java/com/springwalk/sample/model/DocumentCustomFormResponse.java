package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class DocumentCustomFormResponse {

    private String blobPDF;
    private RequestError error;

    public String getBlobPDF() {
        return blobPDF;
    }

    public void setBlobPDF(String blobPDF) {
        this.blobPDF = blobPDF;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }
}
