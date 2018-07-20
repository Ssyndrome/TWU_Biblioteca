package com.twu.biblioteca.core;

import static org.junit.Assert.*;

import com.twu.biblioteca.command.InputReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import jdk.internal.util.xml.impl.Input;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

    private Library library;
    private InputReader reader;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp(){
        library = new Library();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void should_return_book_list_when_asked() {
        library.printMaterialList();
        assertTrue(systemOut().contains("The Three-Body Problem"));
    }

    private String systemOut() {
        return outputStream.toString();
    }
}