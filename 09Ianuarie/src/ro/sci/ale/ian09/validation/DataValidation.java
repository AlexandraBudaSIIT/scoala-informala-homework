package ro.sci.ale.ian09.validation;

import java.util.Scanner;
import java.lang.String;

import static java.lang.System.*;

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
        Scanner read = new Scanner(in);

        out.println("What time is it? ");

        out.println("Hours: ");
        int hours = read.nextInt();

        out.println("Minutes: ");
        int minutes = read.nextInt();

        if (validateDate(hours, minutes)) {
            out.printf("Time is %02d:%02d now", hours, minutes);
        } else {
            out.println("Incorrect time!");
        }
    }

    /**
     * Check if the data is valid
     *
     * @param h   the hours
     * @param min the minutes
     */
    public static boolean validateDate(int h, int min) {
        if ((h < 0 || h > 23) || (min < 0 || min > 59)) {
            return false;
        }
        return true;
    }
}
