package org.example;

import org.example.day1.Trebuchet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
//    public static void main(String[] args) throws IOException {
//        final String PATH_TO = "C:\\Users\\55219\\Desktop\\dev\\adventofcode\\src\\main\\resources\\calibrationdoc.txt";
//        Trebuchet.trebuchet(PATH_TO);
//    }

    public static final int RED_CUBES = 12;
    public static final int GREEN_CUBES = 13;
    public static final int BLUE_CUBES = 14;

    public static int result = 0;

    public static void main(String[] args) {
        List<String> games = Reader.readFromFile();
        String[] sets;
        int resultPart2 = 0;
        assert games != null;
        for (String game : games) {
            String[] tempSplit = game.split(":");
            sets = tempSplit[1].split(";");
            part1(sets, Integer.parseInt(tempSplit[0].substring(5)));
//            resultPart2 += part2(sets, Integer.parseInt(tempSplit[0].substring(5)));
        }
        System.out.println(result);
        System.out.println(resultPart2);

    }

    private static void part1(String[] sets, int gameId) {
        for (String set : sets) {
            String[] cubes = set.split(",");

            for (String cube : cubes) {
                String[] temp = cube.split(" ");
                String numberOfCubes = temp[1];
                String colorOfCube = temp[2];
                switch (colorOfCube) {
                    case "red":
                        if (Integer.parseInt(numberOfCubes) > RED_CUBES) {
                            return;
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(numberOfCubes) > GREEN_CUBES) {
                            return;
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(numberOfCubes) > BLUE_CUBES) {
                            return;
                        }
                        break;
                }
            }
        }
        result += gameId;
    }

    public class Reader {
        public static List<String> readFromFile() {
            List<String> calibrations = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\55219\\Desktop\\dev\\adventofcode\\src\\main\\java\\org\\example\\day2\\test.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    calibrations.add(line);
                }
                reader.close();
                return calibrations;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}