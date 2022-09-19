package org.example;

public class Solution {

    public int solution (String S){

        //Base case, there is no Balloons in a string with less than 7 characters
        if(S.length() < 7) return 0;

        int noOfBalloons = 0;
        String balloon = "BALLOON";
        String findBalloon = "";
        String replace, addChar;

        for(int i = 0; i < 7; i++){

            if(S.indexOf(balloon.charAt(i)) >= 0){
                //System.out.println(S.indexOf(balloon.charAt(i)));
                replace = "";
                replace += balloon.charAt(i);
                S = S.replaceFirst(replace, "");

                addChar = "";
                addChar += balloon.charAt(i);
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
