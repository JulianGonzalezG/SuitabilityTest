package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class VerifyCustomFormResponse {

    private String idCustomForm;
    private String idDocument;
    private RequestError error;

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

    public String getIdCustomForm() {
        return idCustomForm;
    }

    public void setIdCustomForm(String idCustomForm) {
        this.idCustomForm = idCustomForm;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }
}
