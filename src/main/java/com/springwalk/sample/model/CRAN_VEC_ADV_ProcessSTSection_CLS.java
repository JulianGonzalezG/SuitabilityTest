package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 12/12/2016.
 */
public class CRAN_VEC_ADV_ProcessSTSection_CLS {
    //Column name
    private String name;
    private String type;
    private String value;

    public CRAN_VEC_ADV_ProcessSTSection_CLS(String name, String type, String value) {
        this.name = name;
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
     * The column name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
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
