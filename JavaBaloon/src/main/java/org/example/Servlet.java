package org.example;

import exceptions.FileAlreadyExistsException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/balloon")
public class Servlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    private String[] lines;
    private List<String> linesList = new ArrayList<String>();
    private Solution balloonCounter = new Solution();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        try {
            lines = balloonCounter.readLines("C:/Users/dmarkovic/Java/java module/CT360-Java-Module/stringsToCheck.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        for(String s : lines)
            writer.println(s);

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String wordToCount = req.getParameter("wordToCount");
        System.out.println("wordToCount :" + wordToCount);
        balloonCounter.setWordToFind(wordToCount);

        int numberOfLines = 0;

        try {
            numberOfLines = balloonCounter.writeResults(lines, "C:/Users/dmarkovic/Java/java module/CT360-Java-Module/resultsFromPostRequest.txt");
        }
        catch (FileAlreadyExistsException e){
            e.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        writer.println("Successfully wrote results into a new file. Number of lines: " + numberOfLines);
    }
}
