package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution balloonCounter = new Solution("BALLOON");

        String[] lines = balloonCounter.readLines("stringsToCheck.txt");
        String[] lines1 = balloonCounter.readLines("nonExistent.txt");
        String[] lines2 = balloonCounter.readLines(null); //unchecked exception


        balloonCounter.writeResults(lines);
    }
}