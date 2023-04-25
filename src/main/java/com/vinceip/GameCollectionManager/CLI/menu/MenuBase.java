package com.vinceip.GameCollectionManager.CLI.menu;


import com.vinceip.GameCollectionManager.CLI.GameCollectionManagerCLI;

import java.io.IOException;
import java.util.Scanner;

public class MenuBase implements Menu {
    protected int selection;
    protected MenuBase previousMenu = null;
    protected Scanner inputScanner;
    protected GameCollectionManagerCLI cli;

    public MenuBase(Scanner inputScanner, GameCollectionManagerCLI cli) {
        this.cli = cli;
        this.inputScanner = inputScanner;
    }

    public MenuBase(Scanner inputScanner, GameCollectionManagerCLI cli, MenuBase previousMenu) {
        this.cli = cli;
        this.inputScanner = inputScanner;
        this.previousMenu = previousMenu;
    }

    @Override
    public void run() {
        clear();
        displayOptions();
        MenuBase switchToMenu = handleSelection();
        if (switchToMenu != null) {
            setCurrentMenu(switchToMenu.getClass());
        }
    }

    @Override
    public void displayOptions() {

    }

    @Override
    public MenuBase handleSelection() {
        return null;
    }

    @Override
    public int getSelection() {
        return selection;
    }

    public void setCurrentMenu(Class<? extends MenuBase> type) {
        if (type.equals(MenuMain.class)) {
            cli.setCurrentMenu(new MenuMain(inputScanner, cli));
        } else if (type.equals(MenuCollection.class)) {
            cli.setCurrentMenu(new MenuCollection(inputScanner, cli));
        } else {
            throw new IllegalArgumentException("Unsupported menu type: " + type.getName());
        }
    }

    //May or may not actually clear the screen. >.>
    public void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
