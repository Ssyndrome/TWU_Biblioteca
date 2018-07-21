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
        System.out.print("Select a valid option!\n");
    }

    public void checkOut() {
        while (true){
            System.out.println("Please input book name you want to check out:");
            if(library.checkOut(reader.readMessage())){
                System.out.print("Thank you! Enjoy the book!\n");
                break;
            }else{
                System.out.print("That book is not available.");
            }
        }
    }

    public void returnBook() {
        System.out.println("Please input book name you want to return:");
        System.out.println(library.returnBook(reader.readMessage()) ?
                            "Thank you for returning the book." :
                            "That is not a valid book to return.");
    }
}
