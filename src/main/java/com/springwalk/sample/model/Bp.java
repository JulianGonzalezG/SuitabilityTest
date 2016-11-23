package com.springwalk.sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 22/11/2016.
 */
public class Bp {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("container")
    @Expose
    private List<Container> container = new ArrayList<Container>();

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
     * The container
     */
    public List<Container> getContainer() {
        return container;
    }

    /**
     *
     * @param container
     * The container
     */
    public void setContainer(List<Container> container) {
        this.container = container;
    }
}
