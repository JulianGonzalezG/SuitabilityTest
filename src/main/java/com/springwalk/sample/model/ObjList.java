package com.springwalk.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by jgonzalezg on 05/12/2016.
 */

@XStreamAlias("ObjList")
public class ObjList {

    @JsonProperty("-objType")
    private String objType;
    @JsonProperty("obj")
    @XStreamAlias("Obj")
    private List<Obj> obj;

    /**
     *
     * @return
     * The objType
     */
    @JsonProperty("-objType")
    public String getObjType() {
        return objType;
    }

    /**
     *
     * @param objType
     * The -objType
     */
    @JsonProperty("-objType")
    public void setObjType(String objType) {
        this.objType = objType;
    }

    /**
     *
     * @return
     * The obj
     */
    @JsonProperty("obj")
    public List<Obj> getObj() {
        return obj;
    }

    /**
     *
     * @param obj
     * The obj
     */
    @JsonProperty("obj")
    public void setObj(List<Obj> obj) {
        this.obj = obj;
    }
}
