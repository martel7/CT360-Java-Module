package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {
    public String wordToFind;

    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    public Solution(String wordToFind) {
        this.wordToFind = wordToFind;
    }
    public int solution (String S){

        //Base case, there is no Balloons in a string with less than 7 characters
        if(S.length() < wordToFind.length()) return 0;

        int noOfBalloons = 0;
        String findBalloon = "";
        String replace, addChar;

        for(int i = 0; i < 7; i++){

            if(S.indexOf(wordToFind.charAt(i)) >= 0){
                //System.out.println(S.indexOf(balloon.charAt(i)));
                replace = "";
                replace += wordToFind.charAt(i);
                S = S.replaceFirst(replace, "");

                addChar = "";
                addChar += wordToFind.charAt(i);
                findBalloon += addChar;
            }
            else return noOfBalloons;

            if(findBalloon.equals("BALLOON")) {
                i = -1;
                noOfBalloons ++;
                findBalloon = "";
            }
        }

        return noOfBalloons;
    }

    public String[] readLines(String filePath){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            List<String> lines = new ArrayList<String>();
            //String line = reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();

            return lines.toArray(new String[0]);
        }
        catch (FileNotFoundException e){
            //e.printStackTrace();
            logger.info("File not found on that path when it was searched for it.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeResults(String[] lines){

        File file = null;

        try {
            file = new File("results.txt");
            if (file.createNewFile())
                System.out.println("File successfully created: " + file.getName());
            else
                System.out.println("File already exists.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while creating a file.");
            e.printStackTrace();
        }
        finally {
            try {
                FileWriter writer = new FileWriter(file);
                for(String s : lines) {
                    writer.write(Integer.toString(this.solution(s)));
                    writer.write('\n');
                }
                writer.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
