package com.jetbrains;
import java.util.Scanner;
import java.io.File;

public class WordCount2 {

    public static void main (String [] args) throws Exception {
        // throws Exception accounts for if file can't be found
        // gives FileNotFound exception
        File file = new File("98-0.txt");
        Scanner scanner = new Scanner(file);

        int words = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            words += line.split(" ").length;
            // splits line into words at delimiter (a space) with .split, then
            // adds number of words per line determined by .length to int words
            // each time while loops through it adds another line's word count
        }
        System.out.println("The file contains: " + words + " words.");
    }
}