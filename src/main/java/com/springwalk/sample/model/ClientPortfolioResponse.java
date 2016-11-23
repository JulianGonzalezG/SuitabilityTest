package com.springwalk.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 22/11/2016.
 */
public class ClientPortfolioResponse {


    private String clientName;
    private List<Bp> bp = new ArrayList<Bp>();

    /**
     *
     * @return
     * The clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     *
     * @param clientName
     * The clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     *
     * @return
     * The bp
     */
    public List<Bp> getBp() {
        return bp;
    }

    /**
     *
     * @param bp
     * The bp
     */
    public void setBp(List<Bp> bp) {
        this.bp = bp;
    }
}
