package com.springwalk.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgonzalezg on 19/10/2016.
 */
public class SuitabilityRequest {
    private String template;
    private String contactId;
    private String bpId;
    private String startDate;
    private String language;
    private List<Question> question = new ArrayList<Question>();

    /**
     *
     * @return
     * The template
     */
    public String getTemplate() {
        return template;
    }

    /**
     *
     * @param template
     * The template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     *
     * @return
     * The contactId
     */
    public String getContactId() {
        return contactId;
    }

    /**
     *
     * @param contactId
     * The contactId
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     *
     * @return
     * The bpId
     */
    public String getBpId() {
        return bpId;
    }

    /**
     *
     * @param bpId
     * The bpId
     */
    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    /**
     *
     * @return
     * The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     * The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(String language) {
        this.language = language;
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
