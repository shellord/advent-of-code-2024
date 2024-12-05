package org.shellord.adventofcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 implements Solution<Number> {
    String parsedInput = parseInput();

    public Day3(){
        this.parsedInput = parseInput();
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        System.out.println("Part 1: " + day3.partOne());
        System.out.println("Part 2: " + day3.partTwo());
    }


    public String parseInput(){
      return Utils.readInput("day3.input");
    }

    @Override
    public Number partOne() {
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parsedInput);
        int sum = 0;
        while(matcher.find()){
           sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }
        return sum;
    }


    @Override
    public Number partTwo() {
        String regex = "do\\(\\)|don't\\(\\)|mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parsedInput);
        int sum = 0;
        boolean mulEnabled = true;

        while(matcher.find()){
            String matched = matcher.group();
            if(matched.equals("do()")) {
                mulEnabled = true;
            }
            else if(matched.equals("don't()")) {
                mulEnabled = false;
            }
            else if(matched.startsWith("mul(") && mulEnabled) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                sum += num1 * num2;
            }
        }
        return sum;
    }

}
