package com.vinceip.GameCollectionManager.CLI;

import com.vinceip.GameCollectionManager.CLI.menu.MenuBase;
import com.vinceip.GameCollectionManager.CLI.menu.MenuCollection;
import com.vinceip.GameCollectionManager.CLI.menu.MenuMain;
import com.vinceip.GameCollectionManager.CLI.menu.Menu;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameCollectionManagerCLI {
    private Menu currentMenu;
    private Scanner inputScanner = new Scanner(System.in);

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    /**
     * Set current menu to a given menu type.
     *
     * @param type Anything that extends MenuBase
     */
    public void run() {
        System.out.println("*-----------------------*");
        System.out.println("|Game Collection Manager|");
        System.out.println("|      CLI Ediiton      |");
        System.out.println("*-----------------------*");
        int selection;
        currentMenu = new MenuMain(inputScanner, this);
    }


}
