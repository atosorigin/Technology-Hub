/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for choice details.
 * 
 * @author a120065
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChoiceDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -4124128344279045326L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("number")
    private short number;

    @JsonProperty("description")
    private String description;

    /**
     * Getter for id.
     *
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id
     *            the id to set
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for number.
     *
     * @return the number
     */
    public final short getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param number
     *            the number to set
     */
    public final void setNumber(short number) {
        this.number = number;
    }

    /**
     * Getter for description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description
     *            the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }
}
