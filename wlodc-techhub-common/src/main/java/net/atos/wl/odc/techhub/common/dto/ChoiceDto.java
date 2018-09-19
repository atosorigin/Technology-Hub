/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

/**
 * Data transfer object for choice details.
 * 
 * @author a120065
 */
public class ChoiceDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -4124128344279045326L;

    private short number;

    private String description;

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
