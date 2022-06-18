package com.jetbrains;

public class psL3Q7 {
    /**
     * Converts from degrees Fahrenheit to degrees Celsius.
     * @param fahrenheit Temperature in degrees Fahrenheit.
     * @return Equivalent temperature in degrees Celsius.
     */

    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        return celsius;
    }


    /**
     * Prints temperature in degrees Fahrenheit and Celsius.
     * @param fahrenheit Temperature in degrees Fahrenheit.
     */
    // @return is not anything since return type is void

    public void printTemperature(double fahrenheit) {
        System.out.println("F: " + fahrenheit);
        System.out.println("C :" + fahrenheitToCelsius(fahrenheit));
        /* need to input some argument in the function, and
        it will be the same as fahrenheit value as the variable used
        earlier in this function */
    }
}