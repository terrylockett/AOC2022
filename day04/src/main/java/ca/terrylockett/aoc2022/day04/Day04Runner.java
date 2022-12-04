package ca.terrylockett.aoc2022.day04;

import ca.terrylockett.aoc2022.common.InputFileHelper;

public class Day04Runner {

    public static void main(String[] args) throws Exception {
        String inputFile = InputFileHelper.getFilePath(Day04Runner.class.getClassLoader(), "input.txt");

        //***** part 01 *****
        int count = CampAssignmentCleaner.findDuplicateAssignments(inputFile);
        System.out.println("Part 1: " + count);

        //***** part 01 *****
        count = CampAssignmentCleaner.findDuplicateAssignments(inputFile, true);
        System.out.println("Part 2: " + count);

    }
    
}
