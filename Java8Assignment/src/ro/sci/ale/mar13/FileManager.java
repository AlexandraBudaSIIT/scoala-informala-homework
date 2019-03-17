package ro.sci.ale.mar13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class provides methods to load from a file a structure like first name,
 * last name, date of birth and write back another file containing
 * only first name and last name ordered alphabetically
 *
 * @author Alexandra Buda
 */
public class FileManager {
    private String inFile;
    private String outFile;
    private int month;

    public FileManager(String inFile, String outFile, int month) {
        this.inFile = inFile;
        this.outFile = outFile;
        this.month = month;
    }

    /**
     * Returns the list that is loaded from a file containing
     * only the first name and the last name from the file
     *
     * @return myList the new list loaded from the file
     */
    public List<String> readCsvFile() {
        List<String> myList = new ArrayList<>();

        try (Stream<String> myStream = Files.lines(Paths.get(inFile))) {
            myStream.map(s -> (s.split(",")))
                    .filter(x -> LocalDate.parse(x[2]).getMonthValue() == this.month)
                    .forEach(s -> myList.add(s[0] + " " + s[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myList.sort((x, y) -> x.compareTo(y));

        return myList;
    }

    /**
     * Makes use of the methods from BufferedWriter using
     * the variable outFile and method readCsvFile() to write back another file
     * consisting myList
     */
    public void writeCsvFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.outFile))) {
            for (String x : readCsvFile()) {
                bufferedWriter.write(x.replace(" ", ","));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}