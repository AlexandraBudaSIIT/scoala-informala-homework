package ro.sci.ale.ian09.temperature;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * implements an application that for a given temperature measured in Fahrenheit degrees,
 * outputs it in Celsius degrees
 *
 * @author Buda Alexandra
 */
public class Temperature {
    /**
     * Use the fahrenheitToCelsius() method and outputs in Celsius degrees
     * Thrown an error message to indicate that the input
     * does not match the pattern for the expected type
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        try{
            System.out.println("Enter your body temperature, measured in Fahrenheit degrees: ");
            double tempf = read.nextDouble();
            double tempC = fahrenheitToCelsius(tempf);

            System.out.println("Your body temperature in Celsius degrees is " + tempC);

            if (tempC > 37) {
                System.out.println("You are ill!");
            }

        } catch (InputMismatchException e){
            System.out.println(" The input must be an int!");
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
