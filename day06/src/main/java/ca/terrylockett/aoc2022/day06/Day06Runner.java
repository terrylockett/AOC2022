package ca.terrylockett.aoc2022.day06;

import ca.terrylockett.aoc2022.common.InputFileHelper;

import java.nio.file.Files;
import java.nio.file.Path;

public class Day06Runner {

    public static void main(String[] args) throws Exception {
        String file = InputFileHelper.getFilePath(Day06Runner.class.getClassLoader(), "input.txt");
        
        String input = Files.readString(Path.of(file));
        
        
        int part1 = TuningTrouble.findStartOfPacketIndexPart1(input);
        System.out.println("Day06 Part1: " + part1);

        int part2 = TuningTrouble.findStartOfPacketIndexPart2(input);
        System.out.println("Day06 Part2: " + part2);
    }
    
}
