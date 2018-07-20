package com.twu.biblioteca;

import com.twu.biblioteca.command.InputReader;
import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.core.Library;
import com.twu.biblioteca.status.MainMenuOptions;

public class BibliotecaApp {
    private InputReader reader;
    private BibliotecaController bibliotecaController;

    private static final String WELCOME_STRING = "Welcome to Biblipteca App!";
    private static final String MAIN_MENU = "1. List books.\n"+
                                            "0. Quit system.\n"+
                                            "Let's choose one you want :\n";

    public BibliotecaApp (InputReader reader) {
        this.reader = reader;
        bibliotecaController = new BibliotecaController(reader);
    }

    public void init() {
        printStartWelcome();
        while (loadMainMenu()){}
        printQuitBye();
    }

    public void printStartWelcome() {
        System.out.println(WELCOME_STRING);
    }

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public boolean loadMainMenu() {
        printMainMenu();
        switch (reader.readOption()) {
            case MainMenuOptions.LIST_BOOKS:
                bibliotecaController.printBookLists();
                return true;
            case MainMenuOptions.QUIT_COMMAND:
                return false;
            default:
                bibliotecaController.errorInput();
                return true;
        }
    }

    public void printQuitBye() {
        System.out.println("Bye~Waiting for your next visit!");
    }

}
