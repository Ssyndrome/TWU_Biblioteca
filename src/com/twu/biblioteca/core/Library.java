package com.twu.biblioteca.core;

import com.twu.biblioteca.model.Book;
import java.util.ArrayList;
import java.util.List;

public class Library implements RentImplement {
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
        bookList.stream().forEach(i->System.out.println(i.toString()));
        System.out.println(DIVIDER);
    }


}
