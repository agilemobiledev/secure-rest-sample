package com.jayway.template.sample;

import org.codehaus.jackson.annotate.JsonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        return new GameDTO("USer1");
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})

    public Response createGame(PersonDTO person) {
        GameDTO game = new GameDTO(person.userName);
        return Response.status(201).entity(game).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})
    public GameDTO joinGame() {
        String userName = "User2";
        GameDTO game = new GameDTO("User1");
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
