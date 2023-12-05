package org.example.day2;

import org.example.Reader;

import java.util.List;

public class Solution2 {
    public static final int MAX_RED = 12;
    public static final int MAX_GREEN = 13;
    public static final int MAX_BLUE = 14;
    public static int result = 0;

    public static void main(String[] args) {
        final String PATH = "";
        String[] gameSets;
        List<String> games = Reader.reader(PATH);
        assert games != null;
        for(String game : games){
            String[] tempSplit = game.split(":");
            //7 green, 6 red, 9 blue -> gameSets
            gameSets = tempSplit[1].split(";");
            //Game 81 -> tempSplit[0]
            // 81 -> subString(5)
            int gameId = Integer.parseInt(tempSplit[0].substring(5));
            validate(gameSets, gameId);
        }
        System.out.println(result);
    }


    //Validates whether a game is possible or not and takes the id of the valid games.
    //Game 81: 7 green, 6 red, 9 blue; 14 blue, 8 green; 15 green, 6 red, 4 blue; 1 red, 7 blue, 19 green thas a game.
    public static void validate(String[] gameSets, int gameId){
        //Separate sets in a game 7 green, 6 red, 9 blue; 14 blue, 8 green; 15 green, 6 red, 4 blue; 1 red, 7 blue, 19 green
        //                 [0, 1, 2]
        for(String gameSet : gameSets){
            String[] cubes = gameSet.split(",");

            for(String cube : cubes){
                String[] temp = cube.split(" ");
                String cubeQuantity = temp[1];
                String cuberColour = temp[2];

                switch (cuberColour) {
                    case "red" -> {
                        if (Integer.parseInt(cubeQuantity) > MAX_RED) return;
                    }
                    case "green" -> {
                        if (Integer.parseInt(cubeQuantity) > MAX_GREEN) return;
                    }
                    case "blue" -> {
                        if (Integer.parseInt(cubeQuantity) > MAX_BLUE) return;
                    }
                }

            }
        }
        result += gameId;
    }
}
