package com.onideus;

import com.onideus.eleven.four.ElevenFourMain;
import com.onideus.eleven.three.ElevenThreeMain;
import com.onideus.eleven.two.ElevenTwoMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "-1";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(!input.equals("0")) {
            System.out.println(String.format("0 - Exit Program\n" +
                    "1 - %s\n" +
                    "2 - %s\n" +
                    "3 - %s", "Assignment Eleven-Two", "Assignment Eleven-Three", "Assignment Eleven-Four"));

            input = reader.readLine();

            switch(input) {
                case "1":
                    ElevenTwoMain elevenTwoMain = new ElevenTwoMain();
                    elevenTwoMain.run();
                    break;
                case "2":
                    ElevenThreeMain elevenThreeMain = new ElevenThreeMain();
                    elevenThreeMain.run();
                    break;
                case "3":
                    ElevenFourMain elevenFourMain = new ElevenFourMain();
                    elevenFourMain.run();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Input was not recognize, please try again");
            }

        }

        System.out.println("System Exiting");
        System.exit(0);
    }
}
