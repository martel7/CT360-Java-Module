package org.example;

import exceptions.FileAlreadyExistsException;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

         final Logger logger = Logger.getLogger(Solution.class.getName());

        Solution balloonCounter = new Solution("BALLOON");
        String[] lines = null;

        try {
            lines = balloonCounter.readLines("stringsToCheck.txt");
            String[] lines1 = balloonCounter.readLines("nonExistent.txt");
            String[] lines2 = balloonCounter.readLines(null); //unchecked exception
            String[] lines23 = balloonCounter.readLines("emptyFile.txt");
        }
        catch (Exception e){
            logger.info("Exception caught in main: " + e.toString());
        }

        try {
            balloonCounter.writeResults(lines, "results.txt");
        }
        catch (FileAlreadyExistsException | IOException e){
            logger.info("File already exists:" + e.toString());
        }


        Servlet servlet = new Servlet();
    }
}