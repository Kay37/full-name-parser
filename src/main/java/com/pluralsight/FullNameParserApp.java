package com.pluralsight;

import java.util.Scanner;

public class FullNameParserApp {

    public static void main(String[] args) {

        // * create a scanner or Jennifer is gonna give you an infraction
        Scanner theScanner = new Scanner(System.in);

        // * get the user's full name
        System.out.println("Please enter your full name: ");
        String fullName = theScanner.nextLine().trim();

        // * Split their full name into parts
        String[] nameParts = fullName.split(" ");

        System.out.println(nameParts[0]);

    } // ! main method closing bracket

} // ! class closing bracket
