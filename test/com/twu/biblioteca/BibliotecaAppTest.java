package com.twu.biblioteca;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import com.twu.biblioteca.command.InputReader;
import com.twu.biblioteca.status.MainMenuOptions;
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

    @Test
    public void should_quit_system_when_choose_QUIT_COMMAND() {
        when(reader.readOption()).thenReturn(MainMenuOptions.QUIT_COMMAND);
        assertFalse(bibliotecaApp.loadMainMenu());
        bibliotecaApp.init();
        assertTrue(systemOut().endsWith("Bye~Waiting for your next visit!"));
    }

    @Test
    public void should_display_main_menu_after_welcome() {
        when(reader.readOption()).thenReturn(MainMenuOptions.LIST_BOOKS);
        assertTrue(bibliotecaApp.loadMainMenu());
    }

    @Test
    public void should_throw_error_when_input_unexisted_option() {
        when(reader.readOption()).thenReturn("123");
        assertThat(systemOut().endsWith("Select a valid option!")).isTrue();
    }

    private String systemOut() {
        return outputContent.toString();
    }
}
