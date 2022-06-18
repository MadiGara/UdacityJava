package com.jetbrains;

public class psL2Q6 {
    public static void main(String[] args) {
        int weekday = 5;
        boolean holiday = false;

        if (weekday >= 1 && weekday <= 5 && !holiday) {
            /* must use && for number conditions above, not ||,
           or 7 would count as a weekday */
            System.out.println("Wake up at 7:00");
        } else {
            System.out.println("Sleep in!");
        }
    }
}
