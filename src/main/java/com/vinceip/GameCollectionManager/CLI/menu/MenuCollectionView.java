package com.vinceip.GameCollectionManager.CLI.menu;

import com.vinceip.GameCollectionManager.CLI.GameCollectionManagerCLI;
import com.vinceip.GameCollectionManager.SpringContext;
import com.vinceip.GameCollectionManager.game.Game;
import com.vinceip.GameCollectionManager.game.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuCollectionView extends MenuBase implements Menu {

    GameController gameController;

    public MenuCollectionView(Scanner inputScanner, GameCollectionManagerCLI cli) {
        super(inputScanner, cli);
        //Get a reference to a Spring managed GameController
        //MAGIC!!!!
        gameController = SpringContext.getBean(GameController.class);
        getGames();
        run();
    }

    @Override
    public void run(){
        while (true){
            super.run();
        }
    }

    public void getGames() {
        List<Game> gameList = gameController.list();
        for (Game g : gameList) {
            System.out.println(g.getName());
        }
    }

    public void displayOptions() {
        System.out.println("Select an option to continue:");
        System.out.println("1. Back");
    }

    public MenuBase handleSelection() {
        try {
            selection = inputScanner.nextInt();
            switch (selection) {
                case 1:
                    return new MenuCollection(inputScanner, cli);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid selection.");
            inputScanner.nextLine();
        }
        return null;
    }
}
