/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * JPA Entity representing the poster information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "poster")
public class Poster extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -3511264432153774767L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "participants", nullable = false)
    private String participants;

    /**
     * Getter for name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name
     *            the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for participants.
     *
     * @return the participants
     */
    public final String getParticipants() {
        return participants;
    }

    /**
     * Setter for participants.
     *
     * @param participants
     *            the participants to set
     */
    public final void setParticipants(String participants) {
        this.participants = participants;
    }

}
