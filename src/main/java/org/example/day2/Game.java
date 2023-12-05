package org.example.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    public static int result = 0;
    public static void main(String[] args) {


        Game game = new Game();
        String[] sets;
        Map<String, String> gameSets = game.textToMap();
        for(String set : gameSets.values()){
            String[] splitString = set.split(":");
            sets = splitString[1].split(";");
            validateSet(sets, Integer.parseInt(splitString[0].substring(5)));
        }

        System.out.println(result);

    }


    // reads the file into a Map <Game ID: 13 blue, 1 red; 3 green>
    public  Map<String, String> textToMap(){
//        final String PATH_TO = "C:\\Users\\55219\\Desktop\\dev\\adventofcode\\gamesets.txt";
        final String PATH_TO = "C:\\Users\\55219\\Desktop\\dev\\adventofcode\\src\\main\\java\\org\\example\\day2\\test.txt";
        String line;
        Map<String, String> gameSets = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(PATH_TO))){
            while((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(":");
                String key = parts[0];
                String value = parts[1].trim();

                gameSets.put(key, value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gameSets;
    }

    //validates the value parte of the map ex: "12 red, 14 green; 3 blue, 9 red"
//    private static boolean validateSet(String[] set){
//        final int maxRed = 12;
//        final int maxGreen = 13;
//        final int maxBlue = 14;
//
//        int countRed = 0;
//        int countGreen = 0;
//        int countBlue = 0;
//
//        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)");
//        Matcher matcher = pattern.matcher(set);
//
//        while(matcher.find()){
//            int quantity = Integer.parseInt(matcher.group(1));
//            String colour = matcher.group(2);
//
//            switch (colour) {
//                case "red":
//                    countRed += quantity;
//                    break;
//                case "green":
//                    countGreen += quantity;
//                    break;
//                case "blue":
//                    countBlue += quantity;
//                    break;
//                // Adicione mais casos conforme necessário para outras cores
//            }
//
////            switch (colour){
////                case "red" -> countRed += quantity;
////                case "green" -> countGreen += quantity;
////                case "blue" -> countBlue += quantity;
////            }
//        }
//        return countRed <= maxRed && countGreen <= maxGreen && countBlue <= maxBlue;
//
//    }

    private static void validateSet(String[] sets, int gameId){
        final int maxRed = 12;
        final int maxGreen = 13;
        final int maxBlue = 14;

        for(String set : sets){
            String[] cubes = set.split(",");
            for (String cube: cubes){
                String[] temp = cube.split(" ");
                String numOfCubes = temp[0];
                String colour = temp[1];
                switch (colour) {
                    case "red" -> {
                        if (Integer.parseInt(numOfCubes) > maxRed) return;
                    }
                    case "green" -> {
                        if (Integer.parseInt(numOfCubes) > maxGreen) return;
                        ;
                    }
                    case "blue" -> {
                        if (Integer.parseInt(numOfCubes) > maxBlue) return;
                    }
                }
            }
        }
        result+=gameId;
    }
}
