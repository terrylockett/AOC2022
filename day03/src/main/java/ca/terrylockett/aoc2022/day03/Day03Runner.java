package ca.terrylockett.aoc2022.day03;

import java.io.File;
import java.net.URL;

public class Day03Runner {

    final static String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) throws Exception {

        URL resource = Day03Runner.class.getClassLoader().getResource(INPUT_FILE_NAME);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + INPUT_FILE_NAME);
        }
        String inputFilePath = new File(resource.toURI()).getAbsolutePath();


        //******** Part 01 ********
        System.out.println("Day3 Part1: " + RuckSackValidator.findDuplicateItemsTotal(inputFilePath));


        //******** Part 02 ********
        System.out.println("Day3 Part2: " + RuckSackValidator.findBadgeTotals(inputFilePath));

    }
    
}
