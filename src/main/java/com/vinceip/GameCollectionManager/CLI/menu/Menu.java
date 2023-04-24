package com.vinceip.GameCollectionManager.CLI.menu;

public interface Menu {
    public void run();
    public void displayOptions();
    public MenuBase handleSelection();
    int getSelection();
}
