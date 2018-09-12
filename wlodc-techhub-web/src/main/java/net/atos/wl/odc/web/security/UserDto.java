/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.odc.web.security;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author a120065
 *
 */
public class UserDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -604018936275238886L;

    @Getter
    @Setter
    private String userId;

    public UserDto(String userId) {
        super();
        this.userId = userId;
    }
}
