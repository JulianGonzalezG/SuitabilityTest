package com.springwalk.sample.model;

import java.util.List;

/**
 * Created by jgonzalezg on 12/12/2016.
 */
public class CRAN_VEC_ADV_ProcessSTMatrixAnswer_CLS {
    //Row name
    private String groupId;
    private List<CRAN_VEC_ADV_ProcessSTSection_CLS> sections;

    public CRAN_VEC_ADV_ProcessSTMatrixAnswer_CLS(String groupId, List<CRAN_VEC_ADV_ProcessSTSection_CLS> sections) {
        this.groupId = groupId;
        this.sections = sections;
    }

    /**
     *
     * @return
     * The row name
     */
    public String getGroupID() {
        return groupId;
    }

    /**
     *
     * @param groupId
     * The groupId
     */
    public void setGroupID(String groupId) {
        this.groupId = groupId;
    }

    /**
     *
     * @return
     * The sections
     */
    public List<CRAN_VEC_ADV_ProcessSTSection_CLS> getSections() {
        return sections;
    }

    /**
     *
     * @param sections
     * The sections
     */
    public void setSections(List<CRAN_VEC_ADV_ProcessSTSection_CLS> sections) {
        this.sections = sections;
    }

}
