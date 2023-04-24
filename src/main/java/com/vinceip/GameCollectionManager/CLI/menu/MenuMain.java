package com.vinceip.GameCollectionManager.CLI.menu;

import com.vinceip.GameCollectionManager.CLI.GameCollectionManagerCLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMain extends MenuBase implements Menu {

    public MenuMain(Scanner inputScanner, GameCollectionManagerCLI cli) {
        super(inputScanner, cli);
        run();
    }

    @Override
    public void run(){
        while (true){
            super.run();
        }
    }

    @Override
    public void displayOptions() {
        System.out.println("Select an option to continue:");
        System.out.println("1. View/edit my collection");
        System.out.println("2. Search public game database");
        System.out.println("3. Exit");
    }

    @Override
    public MenuBase handleSelection() {
        try {
            selection = inputScanner.nextInt();
            switch (selection) {
                case 1:
                    return new MenuCollection(inputScanner, cli);
                case 2:
                    System.out.println("Needs implemented.");
                    break;
                case 3:
                    System.exit(1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid selection.");
            inputScanner.nextLine();
        }
        return null;
    }

}