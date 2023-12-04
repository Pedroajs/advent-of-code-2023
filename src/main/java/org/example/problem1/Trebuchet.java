package org.example.problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trebuchet {
    public static void trebuchet(String filePath){
        Long totalSum = 0L;
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
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        Integer firstInt = null;
        Integer lastInt = null;

        while (matcher.find()){
            int integerValue = Integer.parseInt(matcher.group());
            if(firstInt == null) firstInt = integerValue;
            lastInt = integerValue;
        }
        if(firstInt != null){
            return Long.parseLong(firstInt + lastInt.toString());
        }
        return 0L;
    }
}