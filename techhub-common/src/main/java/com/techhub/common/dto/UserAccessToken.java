package com.techhub.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for user access token.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccessToken implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 5247054248694072343L;

    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Getter for accessToken.
     *
     * @return the accessToken
     */
    public final String getAccessToken() {
        return accessToken;
    }

    /**
     * Setter for accessToken.
     *
     * @param accessToken
     *            the accessToken to set
     */
    public final void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
