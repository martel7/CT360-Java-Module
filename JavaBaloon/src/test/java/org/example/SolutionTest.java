package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Solution balloonCounter = new Solution("BALLOON");
    private static String[] lines;

//    @Test
//    @Order(1)
    @BeforeAll
    static void readLines() {
        lines = balloonCounter.readLines("../stringsToCheck.txt");
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
    void writeResults() {
        System.out.println("blabla");
    }
}