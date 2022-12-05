package ca.terrylockett.aoc2022.day05;

import ca.terrylockett.aoc2022.common.InputFileHelper;

import java.net.URISyntaxException;

public class Day05Runner {

    public static void main(String[] args) throws Exception {
        String inputFile = InputFileHelper.getFilePath(Day05Runner.class.getClassLoader(), "input.txt");
        
        String part1 = SupplyStacks.unload(inputFile);
        System.out.println("Day5 Part1: " +part1);

        String part2 = SupplyStacks.unload(inputFile, true);
        System.out.println("Day5 Part1: " +part2);
    }
    
}
