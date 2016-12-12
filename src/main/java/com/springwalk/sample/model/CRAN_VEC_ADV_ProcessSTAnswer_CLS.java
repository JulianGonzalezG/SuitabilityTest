package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 12/12/2016.
 */
public class CRAN_VEC_ADV_ProcessSTAnswer_CLS {
    private String value;
    private String type;

    public CRAN_VEC_ADV_ProcessSTAnswer_CLS (String value, String type){
        this.value = value;
        this.type = type;
    }

    /**
     *
     * @return
     * The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }
}
