package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Solution balloonCounter = new Solution("BALLOON");
        String[] lines = null;

        try {
            lines = balloonCounter.readLines("stringsToCheck.txt");
            String[] lines1 = balloonCounter.readLines("nonExistent.txt");
            String[] lines2 = balloonCounter.readLines(null); //unchecked exception
            String[] lines23 = balloonCounter.readLines("emptyFile.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            balloonCounter.writeResults(lines, "results.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}