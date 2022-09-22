package org.example;

import com.google.common.base.Stopwatch;
import exceptions.EmptyFileException;
import exceptions.FileAlreadyExistsException;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Solution balloonCounter = new Solution("BALLOON");
    private static String[] lines;
    private static final Logger logger = Logger.getLogger(SolutionTest.class.getName());
    private static Stopwatch classStopwatch = Stopwatch.createUnstarted();
    private static Stopwatch testStopwatch = Stopwatch.createUnstarted();



    //    @Test
//    @Order(1)
    @BeforeAll
    static void readLines() throws Exception{
        lines = balloonCounter.readLines("../stringsToCheck.txt");
    }
    @BeforeAll
    static void logStart(){
        logger.info("Test class started.");
        classStopwatch.start();
    }
    @AfterAll
    static void logEnd(){
        classStopwatch.stop();
        logger.info("Test class ended. Test class ran for: " + classStopwatch);
    }

    @BeforeEach
    void logStartTest(){
        testStopwatch.start();
    }

    @AfterEach
    void logEndTest(){
        testStopwatch.stop();
        logger.info("Test finished. Test ran for: " + testStopwatch);
    }

    @Test
    @Order(1)
    void solution() {
        assertEquals(1, balloonCounter.solution(lines[0]), "Number of BALLOONs expected and found do not match.");
        assertEquals(2, balloonCounter.solution(lines[1]), "Number of BALLOONs expected and found do not match.");
        assertEquals(0, balloonCounter.solution(lines[2]), "Number of BALLOONs expected and found do not match.");
        assertEquals(1, balloonCounter.solution(lines[3]), "Number of BALLOONs expected and found do not match.");
        assertEquals(3, balloonCounter.solution(lines[4]), "Number of BALLOONs expected and found do not match.");
        assertEquals(1, balloonCounter.solution(lines[5]), "Number of BALLOONs expected and found do not match.");
        assertEquals(1, balloonCounter.solution(lines[6]), "Number of BALLOONs expected and found do not match.");
        assertEquals(0, balloonCounter.solution(lines[7]), "Number of BALLOONs expected and found do not match.");
        assertEquals(0, balloonCounter.solution(lines[8]), "Number of BALLOONs expected and found do not match.");
        assertEquals(3, balloonCounter.solution(lines[9]), "Number of BALLOONs expected and found do not match.");
        assertEquals(2, balloonCounter.solution(lines[10]), "Number of BALLOONs expected and found do not match.");
        assertEquals(1, balloonCounter.solution(lines[11]), "Number of BALLOONs expected and found do not match.");
    }

    @Test
    @Order(2)
    @Description("Checks if results.txt is filled")
    void checkResultTXT1() {
        Path path = Paths.get("../results.txt");
        try {
            if (Files.size(path) == 0)
                Assertions.fail("results.txt is empty");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    @Order(3)
    @Description("Checks if results.txt has enough entries")
    void checkResultTXT2() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("../results.txt"));
            List<String> linesFromFile = new ArrayList<String>();
            String line = reader.readLine();

            while (line != null) {
                linesFromFile.add(line);
                line = reader.readLine();
            }
            reader.close();

            if (linesFromFile.size() != lines.length)
                Assertions.fail("results.txt does not have the required number of entries.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    void checkWrite() throws IOException{
        try{
            balloonCounter.writeResults(lines, "results.txt");
        }
        catch (IOException | FileAlreadyExistsException e){
            logger.info("checkWrite() caught exception.");
        }
    }

    //@Test(expected = IOException.class)
    @Test()
    void testException() throws Exception{
        try {
            balloonCounter.readLines("blabla.txt");
        }
        catch (IOException e) {
            logger.info("IOException thrown");
        }
//        assertThrows(IOException.class,()->{
//            logger.info("IOException thrown");
//        });
    }

    @Test()
    void testEmptyFileException() throws Exception{
        try {
            balloonCounter.readLines("../emptyFile.txt");
        }
        catch (EmptyFileException e) {
            logger.info("Tried to read from an empty file");
        }
    }

    @Test()
    void testIfReadLinesIsNull() throws Exception{
        assertEquals(null, balloonCounter.readLines("../emptyFile.txt"));
    }

    @Test()
    void testReturnOfSolution(){
        Solution x = new Solution("#####");
        x.solution("QWERITYASDUOIZXKLVB");
    }

    @Test
    void writeResultsIOException(){
        try{
            balloonCounter.writeResults(null, "results.txt");
        }
        catch (NullPointerException e){
            logger.info("writeResultsIOException() NullPointerException caught.");
        }
        catch (IOException e){
            logger.info("writeResultsIOException() IOException caught.");
        }
    }

    @Test
    void outputFilePathExists() throws Exception{
        try{
            balloonCounter.writeResults(lines, "results.txt");
        }
        catch (FileAlreadyExistsException e){
            logger.info("outputFilePathExists() FileAlreadyExistsException caught.");
        }
    }
}