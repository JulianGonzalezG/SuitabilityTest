package com.springwalk.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by jgonzalezg on 05/12/2016.
 */
@XStreamAlias("Obj2")
public class Obj {
    @JsonProperty("avqId")
    private String avqId;
    @JsonProperty("keyValList")
    private KeyValList keyValList;


    /**
     *
     * @return
     * The avqId
     */
    @JsonProperty("avqId")
    public String getAvqId() {
        return avqId;
    }

    /**
     *
     * @param avqId
     * The avqId
     */
    @JsonProperty("avqId")
    public void setAvqId(String avqId) {
        this.avqId = avqId;
    }

    /**
     *
     * @return
     * The keyValList
     */
    @JsonProperty("keyValList")
    public KeyValList getKeyValList() {
        return keyValList;
    }

    /**
     *
     * @param keyValList
     * The keyValList
     */
    @JsonProperty("keyValList")
    public void setKeyValList(KeyValList keyValList) {
        this.keyValList = keyValList;
    }

}
