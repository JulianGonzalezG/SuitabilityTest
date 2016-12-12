package com.springwalk.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Created by jgonzalezg on 05/12/2016.
 */
@XStreamAlias("Key")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"text"})
public class Key {
    @JsonProperty("-keyType")
    @XStreamAlias("keyType")
    private String keyType;
    @JsonProperty("#text")
    @XStreamAlias("text")
    private String text;

    /**
     *
     * @return
     * The keyType
     */
    @JsonProperty("-keyType")
    public String getKeyType() {
        return keyType;
    }

    /**
     *
     * @param keyType
     * The -keyType
     */
    @JsonProperty("-keyType")
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    /**
     *
     * @return
     * The text
     */
    @JsonProperty("#text")
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The #text
     */
    @JsonProperty("#text")
    public void setText(String text) {
        this.text = text;
    }
}
