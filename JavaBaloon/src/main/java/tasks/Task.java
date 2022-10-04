package tasks;

import lombok.AllArgsConstructor;
import org.example.Solution;

import java.io.IOException;

@AllArgsConstructor
public class Task implements Runnable{

    public String fileName;

    @Override
    public void run() {

        Solution balloonCounter = new Solution("BALLOON");
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
