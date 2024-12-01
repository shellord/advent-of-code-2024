package org.shellord.adventofcode;

import java.util.*;


public class Day1 {
    List<List<Integer>> parsedInput = new ArrayList<>();

    public Day1(){
        this.parsedInput = parseInput();
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println("Part 1: " + day1.partOne());
        System.out.println("Part 2: " + day1.partTwo());
    }

    private List<List<Integer>> parseInput(){
        List<String> content = Utils.readInputLines("Day1");
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> locationIds1 = new ArrayList<>();
        List<Integer> locationIds2 = new ArrayList<>();
        for (String line : content) {
            String locId1 = line.split("   ")[0];
            String locId2 = line.split("   ")[1];

            locationIds1.add(Integer.parseInt(locId1));
            locationIds2.add(Integer.parseInt(locId2));
        }
        result.add(locationIds1);
        result.add(locationIds2);
        return result;
    }

    private Integer partOne(){
        List<Integer> locationIds1 = new ArrayList<>(parsedInput.get(0));
        List<Integer> locationIds2 = new ArrayList<>(parsedInput.get(1));
        Collections.sort(locationIds1);
        Collections.sort(locationIds2);
        int totalDistance = 0;
        for(int i=0; i<locationIds1.size(); i++){
            totalDistance += Math.abs(locationIds1.get(i) - locationIds2.get(i));
        }
        return totalDistance;
    }

    private Integer partTwo(){
        List<Integer> locationIds1 = new ArrayList<>(parsedInput.get(0));
        List<Integer> locationIds2 = new ArrayList<>(parsedInput.get(1));

        HashMap<Integer,Integer> locCount1 = new HashMap<>();
        HashMap<Integer,Integer> locCount2 = new HashMap<>();

        for(int i=0; i<locationIds1.size(); i++){
            locCount1.put(locationIds1.get(i),locCount1.getOrDefault(locationIds1.get(i),0)+1);
            locCount2.put(locationIds2.get(i),locCount2.getOrDefault(locationIds2.get(i),0)+1);
        }

        int similarityScore = 0;
        for(Map.Entry<Integer,Integer> entry : locCount1.entrySet()){
            if(!locCount2.containsKey(entry.getKey())){
               continue;
            }
            similarityScore += entry.getKey() * entry.getValue() * locCount2.get(entry.getKey());
        }
        return similarityScore;
    }

}
