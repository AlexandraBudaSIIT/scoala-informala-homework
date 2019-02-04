package ro.sci.ale.ian09.temperature;

import java.util.Scanner;

/**
 * implements an application that for a given temperature measured in Fahrenheit degrees,
 * outputs it in Celsius degrees
 *
 * @author Buda Alexandra
 */
public class Temperature {
    /**
     * Use the fahrenheitToCelsius() method
     * and outputs in Celsius degrees
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter your body temperature, measured in Fahrenheit degrees: ");
        double tempf = read.nextDouble();

        double tempC = fahrenheitToCelsius(tempf);

        System.out.println("Your body temperature in Celsius degrees is " + tempC);

        if (tempC > 37) {
            System.out.println("You are ill!");
        }
    }

    /**
     * converts temperature from Fahrenheit to Celsius
     *
     * @param temp the temperature in Fahrenheit
     * @return the temperature in Celsius
     */
    public static double fahrenheitToCelsius(double temp) {
        return ((temp - 32) * 5 / 9);

    }
}
