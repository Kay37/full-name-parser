package com.pluralsight;

import java.util.Scanner;

public class FullNameParserApp {

    public static void main(String[] args) {

        // * create a scanner or Jennifer is gonna give you an infraction
        Scanner theScanner = new Scanner(System.in);

        // * get the user's full name
        System.out.println("Please enter your full name: ");
        String fullName = theScanner.nextLine().trim();

        // * Split their full name into separate parts
        String[] nameParts = fullName.split(" ");

        // * Desired format if they gave us all pieces:
        // First name: Dana
        // Middle name: L.
        // Last name: Wyatt
        System.out.println("First Name: "  + nameParts[0]);
        System.out.println("Last Name: "  + nameParts[1]);
        System.out.println("Middle Name: "  + nameParts[2]);

        // * Format if they didn't give us all the pieces:
        // First name: Dana
        // Middle name: (none)
        // Last name: Wyatt

    } // ! main method closing bracket

} // ! class closing bracket
