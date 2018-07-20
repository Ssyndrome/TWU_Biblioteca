package com.twu.biblioteca;


import static org.junit.Assert.assertTrue;
import com.twu.biblioteca.command.InputReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private InputReader reader;
    private ByteArrayOutputStream outputContent;


    @Before
    public void setUp(){
        reader = mock(InputReader.class);
        bibliotecaApp = new BibliotecaApp(reader);
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldWelcomeWhenStart() {
        bibliotecaApp.printStartWelcome();
        assertTrue(systemOut().startsWith("Welcome to Biblipteca App!"));
    }

    private String systemOut() {
        return outputContent.toString();
    }
}
