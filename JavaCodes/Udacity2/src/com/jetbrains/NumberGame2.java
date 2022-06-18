package com.jetbrains;
import java.util.Scanner;

public class NumberGame2 {

    public static void main (String [] args){
        int randomNumber = (int) (Math.random() * 100) + 1;
        // Math.random gives you 0-1 (not including 1) as doubles
        // * 100 gives you the random numbers between 0 and 100 (not including 100)
        // need brackets around (Math.random() * 100) so (int) converts after 100 multiplication
        // otherwise you’d just always get 0 because int of between 0-1 will always be 0
        // +1 means you get 1-100 instead of 0-99 after the int conversion
        boolean hasWon = false;

        System.out.println("I have randomly chosen a number between 1 and 100.");
        System.out.println("Try to guess it.");

        Scanner scanner = new Scanner(System.in); //lets program read user input
        for (int i = 10; i > 0; i--) {
            // because they have ten guesses, iterations must be positive int
            // and lose one guess each time they guess and the loop runs
            System.out.println("You have " + i + " guess(es) left. Choose again.");
            int guess = scanner.nextInt();
            // tries to convert what user typed in into an int, gives error if can't

            if (randomNumber < guess) {
                System.out.println("It's smaller than " + guess + ".");
            }
            else if (randomNumber > guess) {
                System.out.println("It's larger than " + guess + ".");
            }
            else {                    // if not > or <, guess == randomNumber
                hasWon = true;
                break;
                //they won, so break; don't want loop prompting them to guess again
            }
        }
        if (hasWon) {        // same as if(hasWon = true)
            System.out.println("CORRECT. YOU WIN!");
        } else {
            System.out.println("GAME OVER. YOU LOSE!");
            System.out.println("The number was: " + randomNumber);
        }
    }
}