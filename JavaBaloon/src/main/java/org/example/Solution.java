package org.example;

import exceptions.EmptyFileException;
import exceptions.FileAlreadyExistsException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Solution {
    public String wordToFind;

    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    public Solution(String wordToFind) {
        this.wordToFind = wordToFind;
    }
    public int solution (String S){

        int noOfBalloons = 0;
        String findBalloon = "";
        String replace, addChar;

        //Base case, there is no Balloons in a string with less than 7 characters
        if(S.length() < wordToFind.length()) return 0;

        for(int i = 0; i < wordToFind.length(); i++){

            if(S.indexOf(wordToFind.charAt(i)) >= 0){
                //System.out.println(S.indexOf(balloon.charAt(i)));
                replace = "";
                replace += wordToFind.charAt(i);
                S = S.replaceFirst(replace, "");

                addChar = "";
                addChar += wordToFind.charAt(i);
                findBalloon += addChar;
            }
            else break;

            if(findBalloon.equals("BALLOON")) {
                i = -1;
                noOfBalloons ++;
                findBalloon = "";
            }
        }

        return noOfBalloons;
    }

    public String[] readLines(String filePath) throws Exception{
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

            if(lines.isEmpty())
                throw new EmptyFileException("The file is empty.");

            return lines.toArray(new String[0]);
        }
//        catch (FileNotFoundException e){
//            //e.printStackTrace();
//            logger.info("File not found on that path when it was searched for it.");
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (NullPointerException npe){
//            logger.info("Passed a null argument for filePath in readLines method.");
//        }
        catch (IOException | NullPointerException exception){
            logger.info(exception.toString());
            throw exception;
            //System.out.println(exception);
        }
        catch (EmptyFileException efe){
            logger.info(efe.getMessage());
        }

        return null;
    }

    public void writeResults(String[] lines, String outputFilePath) throws IOException{

        File file = null;

        try {
            file = new File(outputFilePath);
            if (file.createNewFile())
                System.out.println("File successfully created: " + file.getName());
            else
//                System.out.println("File already exists.");
                throw new FileAlreadyExistsException("File already exists");
        }
        catch (IOException | FileAlreadyExistsException e) {
            logger.info(e.getMessage());
            throw e;
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
            catch (IOException | NullPointerException e) {
                logger.info(e.getMessage());
                throw e;
            }
        }
    }
}
