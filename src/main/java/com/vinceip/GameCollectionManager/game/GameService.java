package com.vinceip.GameCollectionManager.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameService implements GameDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private ResultSet query(String sql) throws SQLException {
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    @Override
    public List<Game> selectGames() {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM game;";
        try (ResultSet resultSet = query(sql)) {
            while (resultSet.next()) {
                games.add(mapRowtoGame(resultSet));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return games;
    }

    @Override
    public Game selectGame(int gameId) {
        return null;
    }

    @Override
    public Game selectGame(String gameTitle) {
        return null;
    }

    @Override
    public Game addGame(Game game) {
        Game newGame = new Game();
        String sql = "INSERT INTO game(game_name, game_rating, game_description, game_released, game_website, " +
                "game_metacritic_url, game_alternate_names " +
                "VALUES(?, ?, ?, ?, ?, ? ,?);";
        return null;
    }

    @Override
    public Game updateGame(Game game) {
        return null;
    }

    @Override
    public Game deleteGame(Game game) {
        return null;
    }

    private Game mapRowtoGame(ResultSet resultSet) throws SQLException {
        Game game = new Game();
        game.setId(resultSet.getInt("game_id"));
        game.setName(resultSet.getString("game_name"));
        game.setRating(resultSet.getInt("game_rating"));
        game.setDescription(resultSet.getString("game_description"));
        if (resultSet.getDate("game_released") != null) {
            game.setReleased(resultSet.getDate("game_released").toLocalDate());
        }
        game.setWebsite(resultSet.getString("game_website"));
        game.setMetacriticUrl(resultSet.getString("game_metacritic_url"));

        if (resultSet.getArray("game_alternate_names") != null) {
            Array array = resultSet.getArray("game_alternate_names");
            game.setAlternative_names((String[]) array.getArray());
        }


        game.setUserCompleted(resultSet.getBoolean("game_user_completed"));
        game.setUserFavorite(resultSet.getBoolean("game_user_favorite"));
        return game;
    }
}
