package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class bpCustomFormRequest {

    private String idBP;
    private String tipoCuestionario;
    private String version;
    private String estado;
    private String idioma;

    public String getIdBP() {
        return idBP;
    }

    public void setIdBP(String idBP) {
        this.idBP = idBP;
    }

    public String getTipoCuestionario() {
        return tipoCuestionario;
    }

    public void setTipoCuestionario(String tipoCuestionario) {
        this.tipoCuestionario = tipoCuestionario;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {this.idioma = idioma;}
}
