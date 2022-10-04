package tasks;

import lombok.AllArgsConstructor;
import org.example.Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Task implements Runnable{

    public String fileName;

    @Override
    public void run() {

        String wordToFind = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("JavaBaloon/filesToCheck/" + fileName));
            wordToFind = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Solution balloonCounter = new Solution(wordToFind);
        String[] lines = null;
        try {
            lines = balloonCounter.readLines("JavaBaloon/filesToCheck/" + fileName);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
//          balloonCounter.writeResults(lines, "JavaBaloon/results/" + Thread.currentThread().getName() + ".txt");
            balloonCounter.writeResults(lines, "JavaBaloon/results/result.txt");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
