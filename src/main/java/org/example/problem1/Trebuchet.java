package org.example.problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Trebuchet {
    public static void trebuchet(String filePath) {
        long totalSum = 0L;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                totalSum += getInts(line);
            }
            System.out.println("The calibration number solving1 is: " + totalSum);

            totalSum = 0;
            for (String line : lines) {
                String digits = fromAlphabetToInt(line);
                int a = getFirstDigit(Integer.parseInt(digits));
                int b = getLastDigit(Integer.parseInt(digits));
                String result = a + Integer.toString(b);
                totalSum += Integer.parseInt(result);
            }
            System.out.println("Part 2 result: " + totalSum);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static Long getInts(String line) {
        String intOnly = line.replaceAll("[^0-9]", "");
        int nums = Integer.parseInt(intOnly);

        long lastInt = getLastDigit(nums);
        long firstInt = getFirstDigit(nums);

        String result = firstInt + Long.toString(lastInt);
        return Long.parseLong(result);
    }

    public static String fromAlphabetToInt(String inputLine) {
        String[] ints = {
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
        };

        String resultNumString = "";
        for(int i = 0; i < inputLine.length(); i++){
            if(Character.isDigit(inputLine.charAt(i))){
                resultNumString += inputLine.charAt(i);
                continue;
            }
            for(int x = 0; x < ints.length; x++){
                if(inputLine.substring(i).startsWith(ints[x])){
                    resultNumString += x + 1;
                    i += ints[x].length() - 2;
                    break;
                }
            }
        }
        return  resultNumString;
    }

    private static int getLastDigit(int num) {
        return num % 10;
    }

    private static int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}