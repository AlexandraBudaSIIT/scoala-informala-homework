package ro.sci.ale.ian09.validation;

import java.util.Scanner;

/**
 * Implements an application that asks the user what time it is
 * then output the date
 *
 * @author Buda Alexandra
 */

public class DataValidation {

    /**
     * Use the validateDate() method
     * and output the date with a message
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("What time is it? ");

        System.out.println("Houres: ");
        int hours = read.nextInt();

        System.out.println("Minutes: ");
        int minutes = read.nextInt();

        validateDate(hours, minutes);
    }

    /**
     * Check if the data is valid
     *
     * @param h   the hours
     * @param min the minutes
     */
    private static void validateDate(int h, int min) {
        if ((h < 0 || h > 23) || (min < 0 || min > 59)) {
            System.out.println("Incorrect time!");
        } else {
            System.out.println("Time is " + h + ":" + min + " now");
        }
    }
}
