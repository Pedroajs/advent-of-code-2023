package org.example.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    public static Map<String, String> textToMap(){
        final String PATH_TO = "C:\\Users\\55219\\Desktop\\dev\\adventofcode\\gamesets.txt";
        String line;
        Map<String, String> gameSets = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(PATH_TO))){
            while((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(":");
                String key = parts[0];
                String value = parts[1].trim();

                gameSets.put(key, value);
            }

            for(String key : gameSets.keySet()){
                System.out.println(key + ":" + gameSets.get(key));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gameSets;
    }
    public static void main(String[] args) {
        textToMap();

    }
}
