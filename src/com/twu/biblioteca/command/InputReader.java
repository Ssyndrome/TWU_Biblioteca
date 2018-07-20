package com.twu.biblioteca.command;

import java.util.Scanner;
import java.util.regex.Pattern;
import javafx.animation.PathTransition;

public class InputReader {
    private Scanner scanner;

    public InputReader () {
        scanner = new Scanner(System.in);
    }

    public String readOption() {
        String string = scanner.next().trim();
        Pattern pattern = Pattern.compile("-?[0-9]*");
        return pattern.matcher(string).matches() ? string : "Invalid input.";
    }

}
