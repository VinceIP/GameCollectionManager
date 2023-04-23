package com.vinceip.GameCollectionManager.game;

import java.sql.SQLException;
import java.util.List;

public interface GameDao {
    public List<Game> selectGames() throws SQLException;
    public Game selectGame(int gameId);
    public Game selectGame(String gameTitle);
    public Game addGame(Game game);
    public Game updateGame(Game game);
    public Game deleteGame(Game game);

}
