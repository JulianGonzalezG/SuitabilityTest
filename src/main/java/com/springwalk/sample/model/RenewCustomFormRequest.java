package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class RenewCustomFormRequest {

    private String idPerson;
    private String idCustomForm;
    private String idioma;

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idBP) {
        this.idPerson = idBP;
    }

    public String getIdCustomForm() {
        return idCustomForm;
    }

    public void setIdCustomForm(String version) {
        this.idCustomForm = version;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {this.idioma = idioma;}
}
