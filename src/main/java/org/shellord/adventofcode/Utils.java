package org.shellord.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Utils {
    public static String readInput(String day){
        try{
            Path filePath = Paths.get("src/main/java/org/shellord/adventofcode/inputs/" + day);
            return Files.readString(filePath);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readInputLines(String day){
        try{
            String content = readInput(day);
            return Arrays.asList(content.split("\\R"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
