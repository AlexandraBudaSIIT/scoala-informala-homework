package ro.sci.ale.mar20;

import java.sql.*;

/**
 * this class implements an application which:
 * - Connects to "school" database
 * - Display data for all classes
 * - Display data for a course with specified id
 * - Display data for all classes whose title begins with "intro"
 * - Display data for all classes whose dept is "cos" and whose coursenum begins with "3".
 *
 * @author Alexandra Buda
 */
public class School {
    public static void main(String[] args) throws SQLException {
        SchoolDBO connection = new SchoolDBO(
                "mysql",
                "localhost",
                "3306",
                "school",
                "root",
                "password"
        );

        System.out.println("\n1) Display data for all classes: ");
        connection.displayClasses();

        System.out.println("\n2) Display data for a course with specified id: ");
        connection.displayCourse(3);

        System.out.println("\n3) Display data for all classes whose title begins with intro: ");
        connection.displayDeptFromClasses("TCM");

        System.out.println("\n4) Display data for all classes whose dept cos and whose coursenum begins with 3: ");
        connection.displayTitleFromClasses("INTRO");
    }
}
