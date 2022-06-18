package com.jetbrains;

public class psL4Q6 {
    public int findRange (int[] intArray) {
        if (intArray.length == 0) {
            return -1;
        }
        int smallest = intArray[0];
        int largest = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < smallest) {
                smallest = intArray[i];
            }
            if (intArray[i] > largest) {
                largest = intArray[i];
            }
        }
        return largest - smallest;
    }
}
