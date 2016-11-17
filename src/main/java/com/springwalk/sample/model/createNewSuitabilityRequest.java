package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 28/10/2016.
 */
public class createNewSuitabilityRequest {
    private String idBp;
    private String personId;
    private String tipoCuestionario;
    private String idioma;
    private String version;

    public String getIdBp() {
        return idBp;
    }

    public void setIdBp(String idBp) {
        this.idBp = idBp;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTipoCuestionario() {
        return tipoCuestionario;
    }

    public void setTipoCuestionario(String tipoCuestionario) {
        this.tipoCuestionario = tipoCuestionario;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
