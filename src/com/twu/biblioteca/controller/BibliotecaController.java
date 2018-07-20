package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.InputReader;
import com.twu.biblioteca.core.Library;

public class BibliotecaController {
    private InputReader reader;
    private Library library;

    public BibliotecaController (InputReader reader) {
        this.reader = reader;
        library = new Library();
    }

    public void printBookLists() {
        library.printMaterialList();
    }

    public void errorInput() {
        System.out.println("Error!Please enter another valid message.");
    }
}
