package com.twu.biblioteca;

import com.twu.biblioteca.command.InputReader;

public class BibliotecaApp {
    private InputReader reader;

    public BibliotecaApp (InputReader reader) {
        this.reader = reader;
    }

    public void printStartWelcome() {
        System.out.println("Welcome to Biblipteca App!");
    }

}
