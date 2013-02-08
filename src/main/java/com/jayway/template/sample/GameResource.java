package com.jayway.template.sample;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
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

    @Resource(name = "games")
    GameRepository gameRepository;

    @GET
    @PreAuthorize("isAuthenticated()")
    public Response get() {
        Collection<GameDTO> games = gameRepository.getJoinableGames();
        List<LinkDTO> links = new ArrayList<LinkDTO>();
        links.add(new LinkDTO("/api/game", "Create new game", "createGame"));
        for(GameDTO game : games ) {
            links.add(new LinkDTO("/api/game/"+game.gameID, "Join game", "joinGame"));
        }
        return Response.status(200).entity(links).build();
    }

    @GET
    @Path("/{gameId}")
    @Produces({MediaType.APPLICATION_JSON})
    @PreAuthorize("isAuthenticated()")
    public Response getGame(@PathParam("gameId") String gameId) {
        return Response.status(200).entity(gameRepository.getGame(gameId)).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PreAuthorize("isAuthenticated()")
    public Response createGame(PersonDTO person) {
        GameDTO game = new GameDTO(person.userName);
        gameRepository.addGame(game);
        return Response.status(201).entity(game).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @PreAuthorize("isAuthenticated()")
    @Path("/{gameId}") git ci -PreAuthorize -m
    public Response joinGame(@PathParam("gameId") String gameId, PersonDTO player2) {
        GameDTO game = gameRepository.getGame(gameId);
        game.addPlayer(player2.userName);
        return Response.status(200).entity(gameRepository.getGame(gameId)).build();
    }

}
