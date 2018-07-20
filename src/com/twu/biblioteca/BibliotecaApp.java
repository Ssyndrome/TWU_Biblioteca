package com.twu.biblioteca;

import com.twu.biblioteca.command.InputReader;
import com.twu.biblioteca.core.Library;

public class BibliotecaApp {
    private InputReader reader;

    public BibliotecaApp (InputReader reader) {
        this.reader = reader;
    }

    public void printStartWelcome() {
        System.out.println("Welcome to Biblipteca App!");
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.printMaterialList();
    }
}
