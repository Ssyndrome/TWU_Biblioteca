package com.twu.biblioteca.core;

import com.twu.biblioteca.model.Book;
import java.util.ArrayList;
import java.util.List;

public class Library implements CheckImplement {
    private static final String DIVIDER = "******************************************************************************";
    private List<Book> bookList;

    public Library() {
        bookList = new ArrayList<Book>() {{
            add(new Book("The Three-Body Problem","Cixin Liu",2008));
            add(new Book("Red and Black","Stendhal",1830));
            add(new Book("Folding Beijing","Jingfang Hao",2012));
            add(new Book("Transfiguration","Higashino Keigo",1991));
            add(new Book("Malice","Higashino Keigo",1997));
        }};
    }

    @Override
    public void printMaterialList() {
        System.out.println(String.format(DIVIDER+"\n"+"%-30s%-30s%-30s\n"+DIVIDER,"Name","Author","Published Year"));
        bookList.stream().filter(i->!i.getCheckedStatus()).forEach(i->System.out.println(i.toString()));
        System.out.println(DIVIDER);
    }

    private boolean changeBookStatus(String name) {
        boolean readyToCheck = bookList.stream().anyMatch(i -> i.getName().equals(name) && i.getCheckedStatus()==false);
        if(readyToCheck) {
            bookList.stream().filter(i -> i.getName().equals(name)).forEach(i -> {
                i.setCheckedStatus(true);
            });
        }
        return readyToCheck;
    }

    private boolean getBookReturned(String name) {
        boolean readyToReturn = bookList.stream().anyMatch(i -> i.getName().equals(name) && i.getCheckedStatus()==true);
        if(readyToReturn) {
            bookList.stream().filter(i -> i.getName().equals(name)).forEach(i -> {
                i.setCheckedStatus(false);
            });
        }
        return readyToReturn;
    }

    @Override
    public boolean checkOut(String name){
        return changeBookStatus(name);
    }

    @Override
    public boolean returnBook(String name){
        return getBookReturned(name);
    }
}
