package com.jetbrains;

public class psL3Q8 {

        public int diceRoll(int sides) {
            double randomNumber = Math.random() * 6;
            randomNumber = randomNumber + 1;
            int randomInt = (int) randomNumber;
            return (int) randomNumber;
        }

        public int monopolyRoll() {
            int roll1 = diceRoll(6);
            int roll2 = diceRoll(6);
            int total = roll1 + roll2;
            if (roll1 == roll2) {
                int roll3 = diceRoll(6);
                int roll4 = diceRoll(6);
                total = total + roll3 + roll4;
            }
             return total;
        }
    }
