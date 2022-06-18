package com.jetbrains;

public class psL4Q3 {
    public int indexOfFirstOccurrence(String[] stringArray, String target) {
        for (int i = 0; i < stringArray.length; i++) {  //i is the index
            if (stringArray[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

