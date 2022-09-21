package org.example;

public class Main {
    public static void main(String[] args) {

        Solution balloonCounter = new Solution("BALLOON");

        String[] lines = balloonCounter.readLines("stringsToCheck.txt");
        String[] lines1 = balloonCounter.readLines("nonExistent.txt");
        String[] lines2 = balloonCounter.readLines(null); //unchecked exception
        String[] lines23 = balloonCounter.readLines("emptyFile.txt");


        balloonCounter.writeResults(lines);
    }
}