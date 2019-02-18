package ro.sci.ale.ian09.max;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * implements an application that reads three numbers from the console
 * and prints the biggest of them
 *
 * @author Buda Alexandra
 */
public class MaxNumber {
    /**
     * Use the getMax() method and prints the biggest number
     * Thrown an error message to indicate that the input
     * does not match the pattern for the expected type
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        try {
            System.out.println("Enter the first number: ");
            int number1 = read.nextInt();

            System.out.println("Enter the second number: ");
            int number2 = read.nextInt();

            System.out.println("Enter the third number: ");
            int number3 = read.nextInt();

            int biggest = getMax(getMax(number1, number2), number3);

            System.out.println("The biggest number is " + biggest);
        } catch (InputMismatchException e) {
            System.out.println("The input must be an int!");
        }
    }

    /**
     * returns maximal of the two numbers
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the max number
     */
    public static int getMax(int num1, int num2) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        return max;
    }
}
