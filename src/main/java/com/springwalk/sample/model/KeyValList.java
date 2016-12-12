package com.springwalk.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by jgonzalezg on 05/12/2016.
 */
@XStreamAlias("KeyValList")
public class KeyValList {
    @JsonProperty("key")
    @XStreamAlias("keylist")
    private List<Key> key = null;

    /**
     *
     * @return
     * The key
     */
    @JsonProperty("key")
    public List<Key> getKey() {
        return key;
    }

    /**
     *
     * @param key
     * The key
     */
    @JsonProperty("key")
    public void setKey(List<Key> key) {
        this.key = key;
    }
}
