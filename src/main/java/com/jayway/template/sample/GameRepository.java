package com.jayway.template.sample;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
@Repository("games")
public class GameRepository {

    Map<String, GameDTO> games = new HashMap<String, GameDTO>();

    public void addGame(GameDTO game) {
        games.put(game.gameID, game);
    }

    public GameDTO getGame(String id) {
        return games.get(id);
    }

    public Collection<GameDTO> getJoinableGames() {
        Collection<GameDTO> allGames = games.values();
        List<GameDTO> joinableGames = new ArrayList<GameDTO>();
        for(GameDTO game: allGames) {
            if (game.playerTwo == null) {
                joinableGames.add(game);
            }
        }
        return joinableGames;
    }
}
