package com.vinceip.GameCollectionManager.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Component
@RestController
@RequestMapping("/games")
public class GameController{

    @Autowired
    private GameDao gameDao;

    public GameController(){

    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Game> list() throws SQLException {
        return gameDao.selectGames();
    }


}
