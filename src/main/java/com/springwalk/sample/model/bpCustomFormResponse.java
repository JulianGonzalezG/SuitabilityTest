package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 16/11/2016.
 */
public class bpCustomFormResponse {

    private String idBP;
    private String fecha;
    private String tipo;
    private String version;
    private String estado;
    private RequestError error;
    private String cuestionId;

    public String getIdBP() {
        return idBP;
    }

    public void setIdBP(String idBP) {
        this.idBP = idBP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

    public String getCuestionId() {
        return cuestionId;
    }

    public void setCuestionId(String cuestionId) {
        this.cuestionId = cuestionId;
    }
}
