package com.spell.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spell.entities.AutoCompletion;
import com.spell.entities.LongestPrefixWord;
import com.spell.entities.SpellingCheck;
import com.spell.exception.BadArgumentException;
import com.spell.service.Service;
import com.sun.jersey.spi.resource.Singleton;

@Path("/restapi")
@Singleton
public class RestAPI {

    private Service service;

    public RestAPI() {
        service = Service.getInstance();
    }

    @GET
    @Path("/spellingCheck/{word}")
    @Produces(MediaType.APPLICATION_JSON)
    public SpellingCheck spellingCheck(@PathParam("word") String query) {
        query = service.formalisationString(query);
        if (query == null) {
            throw new BadArgumentException(
                    "The current API just support alphabetical word. Please provide an alphabetical word without space.");
        }
        return service.spellingCheck(query);
    }
    
    @GET
    @Path("/autoCompletion/{prefix}")
    @Produces(MediaType.APPLICATION_JSON)
    public AutoCompletion autoCompletion(@PathParam("prefix") String query) {
        query = service.formalisationString(query);
        if (query == null) {
            throw new BadArgumentException(
                    "The current API just support alphabetical word. Please provide an alphabetical word without space.");
        }
        return service.autoCompletion(query);
    }
    
    @GET
    @Path("/longestPrefixWord/{queryString}")
    @Produces(MediaType.APPLICATION_JSON)
    public LongestPrefixWord longestPrefixWord(@PathParam("queryString") String query) {
        query = service.formalisationString(query);
        if (query == null) {
            throw new BadArgumentException(
                    "The current API just support alphabetical word. Please provide an alphabetical word without space.");
        }
        return service.longestPrefixWord(query);
    }
    
}
