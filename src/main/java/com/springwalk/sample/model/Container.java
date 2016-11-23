package com.springwalk.sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 22/11/2016.
 */
public class Container {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mac")
    @Expose
    private List<Mac> mac = new ArrayList<Mac>();

    /**
     *
     * @return
     * The name
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
     * The mac
     */
    public List<Mac> getMac() {
        return mac;
    }

    /**
     *
     * @param mac
     * The mac
     */
    public void setMac(List<Mac> mac) {
        this.mac = mac;
    }

}
