package org.example;

public class Solution {

    public String wordToFind;

    public Solution(String wordToFind) {
        this.wordToFind = wordToFind;
    }
    public int solution (String S){

        //Base case, there is no Balloons in a string with less than 7 characters
        if(S.length() < 7) return 0;

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
}
