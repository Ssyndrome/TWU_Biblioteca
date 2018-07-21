package com.twu.biblioteca;


import static org.junit.Assert.assertFalse;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import com.twu.biblioteca.command.InputReader;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.status.MainMenuOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private InputReader reader;
    private ByteArrayOutputStream outputContent;
    private Book validBook = new Book("Transfiguration","",0);
    private Book invalidBook = new Book("Why","",0);

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
    public void should_display_error_when_input_invalid_option() {
        when(reader.readOption()).thenReturn("a");
        assertTrue(bibliotecaApp.loadMainMenu());
        assertTrue(systemOut().endsWith("Select a valid option!\n"));
    }

    @Test
    public void should_succeed_checking_out_a_book_when_input_valid_this_book_name() {
        when(reader.readOption()).thenReturn(MainMenuOptions.CHECK_OUT).thenReturn(MainMenuOptions.QUIT_COMMAND);
        when(reader.readMessage()).thenReturn(validBook.getName());
        bibliotecaApp.init();
        assertTrue(systemOut().contains("Thank you! Enjoy the book!\n"));
    }

    @Test
    public void should_fail_checking_a_book_until_succeed_when_input_invalid_name() {
        when(reader.readOption()).thenReturn(MainMenuOptions.CHECK_OUT).thenReturn(MainMenuOptions.QUIT_COMMAND);
        when(reader.readMessage()).thenReturn(invalidBook.getName()).thenReturn(validBook.getName());
        bibliotecaApp.init();
        assertTrue(systemOut().contains("That book is not available."));
        verify(reader,times(2)).readMessage();
    }

    @Test
    public void should_list_unchecked_books_after_succeed_checking_a_book() {
        when(reader.readOption()).thenReturn(MainMenuOptions.CHECK_OUT).thenReturn(MainMenuOptions.LIST_BOOKS).thenReturn(MainMenuOptions.QUIT_COMMAND);
        when(reader.readMessage()).thenReturn(validBook.getName());
        bibliotecaApp.init();
        assertTrue(systemOut().contains("******************************************************************************\n"
                + "Name                          Author                        Published Year                \n"
                + "******************************************************************************\n"
                + "The Three-Body Problem        Cixin Liu                     2008                          \n"
                + "Red and Black                 Stendhal                      1830                          \n"
                + "Folding Beijing               Jingfang Hao                  2012                          \n"
                + "Malice                        Higashino Keigo               1997                          \n"
                + "******************************************************************************"));
    }

    @Test
    public void should_return_book_after_input_right_checked_name() {
        when(reader.readOption()).thenReturn(MainMenuOptions.CHECK_OUT).thenReturn(MainMenuOptions.RETURN_BOOK).thenReturn(MainMenuOptions.QUIT_COMMAND);
        when(reader.readMessage()).thenReturn(validBook.getName()).thenReturn(validBook.getName());
        bibliotecaApp.init();
        assertTrue(systemOut().contains("Thank you for returning the book."));
    }

    @Test
    public void should_fail_returning_book_after_wrong_input() {
        when(reader.readOption()).thenReturn(MainMenuOptions.CHECK_OUT).thenReturn(MainMenuOptions.RETURN_BOOK).thenReturn(MainMenuOptions.QUIT_COMMAND);
        when(reader.readMessage()).thenReturn(validBook.getName()).thenReturn(invalidBook.getName());
        bibliotecaApp.init();
        assertTrue(systemOut().contains("That is not a valid book to return."));
    }

    private String systemOut() {
        return outputContent.toString();
    }
}
