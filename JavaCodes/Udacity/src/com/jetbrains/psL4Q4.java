package com.jetbrains;

public class psL4Q4 {
    public int yearsTilOneMillion(double initialBalance) {
        int years = 0;
        double balance = initialBalance;
        while (balance < 1000000) {
            balance = balance * 1.05;
            years++;
        }
        return years;
    }
}
