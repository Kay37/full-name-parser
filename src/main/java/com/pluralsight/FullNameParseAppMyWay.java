package com.pluralsight;

// * importing scanner for user input

import java.util.Scanner;

public class FullNameParseAppMyWay {

    // * static scanner that can be accessed by any method within this class.
    public static Scanner sc = new Scanner(System.in);

    // ! static variables/constants go here
    // * variables made inside a method only exist within that method's brackets. I place these here so that any method
    // * can reach them and use them.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {

        // TODO - Prompt the user to enter their full name in one of the following two formats:
        // * first last
        // or
        // * first middle last
        // trim the name before proceeding in case the user entered leading or trailing spaces.
        System.out.printf("""
                Please provide your name in one of the following formats:
                %sFirst Last%s
                or
                %sFirst Middle Last%s%n
                """, RED, RESET, GREEN, RESET);
        String nameInput = askQuestion(RESET, "Enter your name here: ");

        // TODO - Parse the name and process it so that you can display the individual pieces of the name.

        // * Ideal Format if given all information:
        // First name: Dana
        //Middle name: L.
        //Last name: Wyatt
        // * When I called to askQuestion and stored the answer in String nameInput, it called the askQuestion method
        // * which trims the user input and color codes it and returns it as a String. So, I can go right into
        // * splitting that answer into sections because leading and trailing spaces have already been removed.
        String[] nameParts = nameInput.split(" ");
        // * When split, if there's 3 parts that means they put a First, Middle, and Last Name.
        if (nameParts.length == 3) {
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];
            String niceName = String.format("""
                    Your name is:
                    First name: %s
                    Middle name: %s
                    Last name: %s
                    """, firstName, middleName, lastName);
            System.out.println(makeColorScheme(GREEN, niceName));
        }

        // * Alternative Format with lack of information:
        //First name: Dana
        //Middle name: (none)
        //Last name: Wyatt

        if (nameParts.length == 2) {
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            String badName = String.format("""
                    Your name is:
                    First name: %s
                    Middle name: (none)
                    Last name: %s
                    """, firstName, lastName);
            System.out.println(makeColorScheme(RED, badName));

        }

        // * close scanner to save resources
        sc.close();

    } // ! main method closing bracket

    // ! other methods go below this comment

    // * makeColorScheme is a String method that takes two parameters, a color and a message, and returns a String:
    // * the message wrapped in the color chosen.
    public static String makeColorScheme(String color, String originalMessage) {
        return color + originalMessage + RESET;
    }
    // * askQuestion returns a String that uses our previous makeColorScheme method. Methods can use methods.
    // * askQuestion takes two parameters, a color and a prompt, and returns a String.
    // * This method creates a String called coloredPrompt, which uses makeColorScheme to add color coding to its
    // * question. It prints the question, stores their response with our public static scanner, trims the response,
    // * and returns it to whoever called the askQuestion method.
    public static String askQuestion(String color, String prompt) {
        String coloredPrompt;
        coloredPrompt = makeColorScheme(color, prompt);
        System.out.print(coloredPrompt);
        String answer = sc.nextLine();
        return answer.trim();
    }
} // ! class closing bracket
