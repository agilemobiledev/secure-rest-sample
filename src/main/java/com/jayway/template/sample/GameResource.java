package com.jayway.template.sample;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/game")
public class GameResource {

    @GET
    public String get() {
        return "This is public";
    }

    @GET
    @Path("/gameid")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GameDTO getGame() {
        return game;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})
    public GameDTO createGame() {
        String userName = "user1";
        return new GameDTO(userName);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})
    public GameDTO joinGame() {
        String userName = "User2";
        game.addPlayer(userName);
        return game;
    }




    @GET
    @Path("greet")
    @PreAuthorize("isAuthenticated()")
    public String yourEyesOnly() {
        return "Hello world";
    }

    @GET
    @Path("secret")
    @PreAuthorize("hasRole('secret')")
    public String secret() {
        return "this is secret";
    }


}
