package org.example.problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Trebuchet {
    public static void trebuchet(String filePath){
        long totalSum = 0L;
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for(String line : lines){
                totalSum += getInts(line);
            }
            System.out.println("The calibration number is: " + totalSum);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
    private static Long getInts(String line){
        String intOnly = line.replaceAll("[^0-9]","");
        int nums = Integer.parseInt(intOnly);

        int lastInt = nums % 10;
        int firstInt = getFirstInt(nums);

        String result = firstInt + Integer.toString(lastInt);
        return Long.parseLong(result);
    }
    private static int getFirstInt(int num){
        while (num >= 10){
            num /=10;
        }
        return num;
    }
}