package ca.terrylockett.aoc2022.day08;

import ca.terrylockett.aoc2022.common.InputFileHelper;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day08Runner {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String inputFile = InputFileHelper.getFilePath(Day08Runner.class.getClassLoader(), "input.txt");
        
        int part1 = TreeHouseLocator.getNumberOfVisibleTrees_Part1(inputFile);
        System.out.println("Day08 Part01: "+ part1);
    }
    
}
