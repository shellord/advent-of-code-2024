package org.shellord.adventofcode;
import java.util.*;
import java.util.stream.Collectors;

public class Day2 implements Solution<Number> {
    List<List<Integer>> parsedInput = parseInput();

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        System.out.println("Part One: " + day2.partOne());
        System.out.println("Part Two: " + day2.partTwo());
    }

    public List<List<Integer>> parseInput(){
      List<String> input =  Utils.readInputLines("Day2.input");
      return input.stream().map(i-> Arrays.stream(i.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        ).collect(Collectors.toList());
    }

    public Number partOne(){
       return parsedInput.stream().filter(this::isSafe).count();
    }

    private boolean isSafe(List<Integer> i){
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for(int j = 0; j < i.size() -1 ; j++){
            if(i.get(j) < i.get(j+1)){
                isIncreasing = true;
            }else{
                isDecreasing = true;
            }
            if(isIncreasing && isDecreasing
                    || Math.abs(i.get(j) - i.get(j+1)) > 3
                    || Math.abs(i.get(j) - i.get(j+1)) < 1){
                return false;
            }
        }
        return true;
    }

    public Number partTwo(){
        return parsedInput.stream().filter(i -> {
          if(isSafe(i)){
              return true;
          }
          for(int j = 0; j < i.size(); j++){
              List<Integer> tempList = new ArrayList<>(i);
              tempList.remove(j);
              if(isSafe(tempList)){
                  return true;
              }
          }
          return false;
        }).count();
    }
}
