package org.example;

import exceptions.FileAlreadyExistsException;
import tasks.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        /*final Logger logger = Logger.getLogger(Solution.class.getName());

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


        Servlet servlet = new Servlet();*/

        SimpleThreadFactory factory = new SimpleThreadFactory();
        List<Thread> tasks = new ArrayList<Thread>();

        //read how many txt files are there and make a new task for each
        File folder =  new File("JavaBaloon/filesToCheck");
        int numberOfFiles = folder.listFiles().length;
        for(File f : folder.listFiles()){
            //tasks.add(new Task(f.getName()));
            tasks.add(factory.newThread(new Task(f.getName())));
        }

        ExecutorService pool = Executors.newCachedThreadPool();
        //ExecutorService pool = Executors.newFixedThreadPool(1);


        for(Thread t : tasks)
            pool.execute(t);

        pool.shutdown();
    }
}