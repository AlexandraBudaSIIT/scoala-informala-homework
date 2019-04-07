package ro.sci.ale.mar20;

import java.sql.*;

/**
 *
 * This class connects to the database and provides methods to:
 * - Display data for all classes.
 * - Display data for a course with specified id.
 * - Display data for all classes whose title begins with "intro".
 * - Display data for all classes whose dept is "cos" and whose coursenum begins with "3"
 *
 * @author Alexandra Buda
 */
public class SchoolDBO {

    private Connection connection;

    /**
     * static block to load the driver
     *
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can't load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * constructor to create a connection
     *
     * @param type the database type
     * @param host the server name on which mysql is running
     * @param port the port number
     * @param dbName the database name
     * @param user the username for the database
     * @param pwd the password given by the user
     * @throws SQLException
     */
    public SchoolDBO(String type, String host, String port, String dbName, String user, String pwd) throws SQLException {
        DriverManager.setLoginTimeout(60);
        String url = new StringBuilder()
                .append("jdbc:")
                .append(type)
                .append("://")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append(dbName)
                .append("?user=")
                .append(user)
                .append("&password=")
                .append(pwd).toString();
        this.connection = DriverManager.getConnection(url);
    }

    /**
     * method to check if the connection is closed
     */
    private void checkConnection() {
        if (this.connection == null)
            throw new IllegalStateException("Connection already closed!");
    }

    /**
     * method to close the connection to the database
     */
    public void closeConnection() {
        checkConnection();
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method that display data for all classes
     * uses method checkConnection()
     */
    public void displayClasses() {
        checkConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        final String format = "%12s%12s%30s%30s%30s%30s%30s\n";

        try {
            ps = this.connection.prepareStatement("select * from classes");
            rs = ps.executeQuery();
            boolean hasResult = rs.next();
            if (hasResult) {
                System.out.format(format, "classid", "courseid", "days", "starttime",
                        "endtime", "bldg", "roomnum");
                do {
                    System.out.format(format, rs.getString("classid"), rs.getString("courseid"), rs.getString("days"),
                            rs.getString("starttime"), rs.getString("endtime"),
                            rs.getString("bldg"), rs.getString("roomnum"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * method to display data for a course with specified id
     *
     * @param id the course id specified by user
     */
    public void displayCourse(int id) {
        checkConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        final String format = "%12s%30s%30s%30s%30s\n";

        try {
            ps = this.connection.prepareStatement("select * from courses where courseid=?");
            ps.setString(1,Integer.toString(id));

            rs = ps.executeQuery();
            boolean hasResult = rs.next();
            if (hasResult) {
                System.out.format(format, "courseid", "area", "title",
                        "descrip", "prereqs");
                do {
                    System.out.format(format, rs.getString("courseid"), rs.getString("area"),
                            rs.getString("title"), rs.getString("descrip"),
                            rs.getString("prereqs"));
                } while (rs.next());
            } else {
                System.out.println("No results for: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Display data for all classes whose title (when converted to all lowercase letters) begins with "intro".
     * @param name the title name specified by user
     */
    public void displayTitleFromClasses(String name) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        final String format = "%12s%12s%30s%30s%30s%30S\n";

        try {
            String query = "select classes.classid, classes.days, classes.starttime, classes.endtime, courses.title," +
                    "courses.descrip from classes inner join courses on courses.courseid = classes.courseid " +
                    "where substr(lower((courses.title)),1, 5 ) = ? ;";
            ps = this.connection.prepareStatement(query);
            ps.setString(1, name);

            rs = ps.executeQuery();
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "classid", "days", "starttime", "endtime", "title", "descrip");
                do {
                    System.out.format(format,
                            rs.getString("classid"),
                            rs.getDate("days"),
                            rs.getTime("starttime"),
                            rs.getTime("endtime"),
                            rs.getString("title"),
                            rs.getString("descrip"));
                } while (rs.next());
            } else {
                System.out.println("No results for classes with course name starting with: " + name);
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Display data for all classes whose dept (when converted to all lowercase letters)
     * is "cos" and whose coursenum begins with "3".
     *
     * @param dept the department name specified by user
     */
    public void displayDeptFromClasses(String dept) {

        PreparedStatement prepared = null;
        ResultSet rs = null;
        final String format = "%12s%12s%30s%30s%30s%30S%12s%12s\n";

        try {
            String query = "select classes.classid, classes.days, classes.starttime, classes.endtime, courses.title, " +
                    "courses.descrip, crosslistings.dept, crosslistings.coursenum " +
                    "from classes join courses " +
                    "on classes.courseid = courses.courseid " +
                    "join crosslistings " +
                    "on classes.courseid = crosslistings.courseid " +
                    "where lower(crosslistings.dept)= ? and " +
                    "crosslistings.coursenum-300>=0 and crosslistings.coursenum-300< 100;";
            prepared = this.connection.prepareStatement(query);
            prepared.setString(1, dept);

            rs = prepared.executeQuery();
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "Class Id", "Days", "Start Time", "End Time", "Title", "Description",
                        " Deparment", "Course Number");
                do {
                    System.out.format(format,
                            rs.getString("classid"),
                            rs.getDate("days"),
                            rs.getTime("starttime"),
                            rs.getTime("endtime"),
                            rs.getString("title"),
                            rs.getString("descrip"),
                            rs.getString("dept"),
                            rs.getString("coursenum"));
                } while (rs.next());
            } else {
                System.out.println("No results for classes with course in department: " + dept);
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (prepared != null) try {
                prepared.close();
            } catch (SQLException e) {
            }
        }

    }
}







