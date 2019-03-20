package ro.sci.ale.mar13;

import java.util.Scanner;

/**
 * implements an application that for a given birthday month, write back another file
 * containing only the first name and last name ordered alphabetically
 * for all the the matches which have the birthday on the month indicated.
 *
 * @author Alexandra Buda
 */
public class Main {
    /**
     * Use the writeCsvFile() method
     * and write back the FileName2
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("PLease enter a birthday month");
        int month = scan.nextInt();
        if (month >= 1 && month <= 12) {
            FileManager per1 = new FileManager("Java8Assignment\\File\\FileName.csv",
                    "Java8Assignment\\File\\FileName2.csv", month);
            per1.writeCsvFile();
        } else {
            System.out.println("Enter a valid month");
        }
    }
}
