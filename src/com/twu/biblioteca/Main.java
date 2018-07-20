package com.twu.biblioteca;

import com.twu.biblioteca.command.InputReader;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(reader);
        bibliotecaApp.init();
    }
}
