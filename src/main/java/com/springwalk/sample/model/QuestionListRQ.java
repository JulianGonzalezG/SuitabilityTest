package com.springwalk.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


/**
 * Created by jgonzalezg on 05/12/2016.
 */
@XStreamAlias("content")
public class QuestionListRQ {

    @JsonProperty("lang")
    @XStreamImplicit(itemFieldName = "lang")
    private String lang;
    @JsonProperty("objList")
    @XStreamImplicit(itemFieldName = "objList")
    private ObjList objList;
    @JsonProperty("questType")
    @XStreamImplicit(itemFieldName = "questType")
    private String questType;
    @JsonProperty("questVersion")
    @XStreamImplicit(itemFieldName = "questVersion")
    private String questVersion;
    @JsonProperty("questStatus")
    @XStreamImplicit(itemFieldName = "questStatus")
    private String questStatus;

    /**
     *
     * @return
     * The lang
     */
    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    /**
     *
     * @param lang
     * The lang
     */
    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     *
     * @return
     * The objList
     */
    @JsonProperty("objList")
    public ObjList getObjList() {
        return objList;
    }

    /**
     *
     * @param objList
     * The objList
     */
    @JsonProperty("objList")
    public void setObjList(ObjList objList) {
        this.objList = objList;
    }

    /**
     *
     * @return
     * The questType
     */
    @JsonProperty("questType")
    public String getQuestType() {
        return questType;
    }

    /**
     *
     * @param questType
     * The questType
     */
    @JsonProperty("questType")
    public void setQuestType(String questType) {
        this.questType = questType;
    }

    /**
     *
     * @return
     * The questVersion
     */
    @JsonProperty("questVersion")
    public String getQuestVersion() {
        return questVersion;
    }

    /**
     *
     * @param questVersion
     * The questVersion
     */
    @JsonProperty("questVersion")
    public void setQuestVersion(String questVersion) {
        this.questVersion = questVersion;
    }

    /**
     *
     * @return
     * The questStatus
     */
    @JsonProperty("questStatus")
    public String getQuestStatus() {
        return questStatus;
    }

    /**
     *
     * @param questStatus
     * The questStatus
     */
    @JsonProperty("questStatus")
    public void setQuestStatus(String questStatus) {
        this.questStatus = questStatus;
    }
}
