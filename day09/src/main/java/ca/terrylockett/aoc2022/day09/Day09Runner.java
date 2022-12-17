package ca.terrylockett.aoc2022.day09;

import ca.terrylockett.aoc2022.common.InputFileHelper;

import java.net.URISyntaxException;

public class Day09Runner {

    public static void main(String[] args) throws Exception {
        String inputFile = InputFileHelper.getFilePath(Day09Runner.class.getClassLoader(), "input.txt");
        
        Rope rope = new Rope();
        rope.processMoves(inputFile);
        
        System.out.println("Day 09 Part 01: "+ rope.tail.getVisitedLocationsCount());
    }
    
}
