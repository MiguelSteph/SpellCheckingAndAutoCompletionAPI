package com.spell.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

public class BadArgumentException extends WebApplicationException {

    private static final long serialVersionUID = 1L;

    public BadArgumentException(String message) {
        super(Response.status(Status.BAD_REQUEST).entity(message).type(MediaType.APPLICATION_JSON).build());
    }

}
