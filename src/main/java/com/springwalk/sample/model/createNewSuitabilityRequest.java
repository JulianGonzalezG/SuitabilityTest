package com.springwalk.sample.model;

/**
 * Created by jgonzalezg on 28/10/2016.
 */
public class createNewSuitabilityRequest {
    private String bpId;
    private String contactId;
    private String idSuitabilityAvaloq;
    private Boolean isRenew;

    public String getIdSuitabilityAvaloq() {
        return idSuitabilityAvaloq;
    }

    public void setIdSuitabilityAvaloq(String idSuitabilityAvaloq) {
        this.idSuitabilityAvaloq = idSuitabilityAvaloq;
    }

    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }


    public Boolean getIsRenew() {
        return isRenew;
    }

    public void setIsRenew(Boolean renew) {
        this.isRenew = renew;
    }
}
