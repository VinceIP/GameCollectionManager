package com.vinceip.GameCollectionManager.CLI.menu;

import com.vinceip.GameCollectionManager.CLI.GameCollectionManagerCLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCollection extends MenuBase implements Menu {
    public MenuCollection(Scanner inputScanner, GameCollectionManagerCLI cli) {
        super(inputScanner, cli);
    }


    @Override
    public void displayOptions() {
        System.out.println("Select an option to continue:");
        System.out.println("1. View collection");
        System.out.println("2. Search collection");
        System.out.println("3. Add to collection");
        System.out.println("4. Edit collection");
        System.out.println("5. Back");
    }

    @Override
    public MenuBase handleSelection() {
        try {
            selection = inputScanner.nextInt();
            switch (selection) {
                case 1, 2, 3, 4:
                    System.out.println("Needs implemented.");
                    break;
                case 5:
                    return new MenuMain(inputScanner, cli);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid selection.");
            inputScanner.nextLine();
        }
        return null;

    }

    @Override
    public int getSelection() {
        return 0;
    }
}
