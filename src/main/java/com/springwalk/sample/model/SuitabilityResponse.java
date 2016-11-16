package com.springwalk.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 19/10/2016.
 */
public class SuitabilityResponse {
    private String idAvaloq;
    private String status;
    private String profile;
    private List<RequestError> error = new ArrayList<RequestError>();
    private List<Question> question = new ArrayList<Question>();

    /**
     *
     * @return
     * The idAvaloq
     */
    public String getIdAvaloq() {
        return idAvaloq;
    }

    /**
     *
     * @param idAvaloq
     * The idAvaloq
     */
    public void setIdAvaloq(String idAvaloq) {
        this.idAvaloq = idAvaloq;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     * The profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     * The error
     */
    public List<RequestError> getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(List<RequestError> error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The question
     */
    public List<Question> getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     * The question
     */
    public void setQuestion(List<Question> question) {
        this.question = question;
    }

}
