package com.jetbrains;

public class psL4Q8 {
    public static int diceRoll(int sides) {
        double randomNumber = Math.random() * sides;
        randomNumber = randomNumber + 1;
        return (int) randomNumber;  //casts randomNumber as int
    }

    public static int monopolyRoll() {  
        int roll1 = diceRoll(6);
        int roll2 = diceRoll(6);
        int total = roll1 + roll2;
        int rollsSoFar = 1;   //the rolling of the two dice
        while (roll1 == roll2) {    //if not the case, skips this code block
            if (rollsSoFar >= 3) return -1;  //doubles have been rolled too many times in a row
            roll1 = diceRoll(6);
            roll2 = diceRoll(6);
            total = total + roll1 + roll2;
            rollsSoFar++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(monopolyRoll());
    }
}

    /*Or, could use recursion instead of the second code block above (if not checking jail):
    public int monopolyRoll() {
        int roll1 = diceRoll(6);
        int roll2 = diceRoll(6);
        if (roll1 != roll2) {
            return roll1 + roll2;
        } else {
            return roll1 + roll2 + monopolyRoll();
            //recursion (call the function within itself
            //represents the re-roll you do when you get doubles
        }
    }
} */
