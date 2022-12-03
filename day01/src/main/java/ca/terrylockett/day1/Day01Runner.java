package ca.terrylockett.day1;

import ca.terrylockett.aoc2022.common.InputFileHelper;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Day01Runner {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

        String filePath = InputFileHelper.getFilePath(Day01Runner.class.getClassLoader(), "input.txt");


        //*****  part 01  *****//
        int maxCals = DumbElfCalorieTracker.findTheFoodHog(filePath);
        System.out.println("part1 - biggest calorie total: " + maxCals);

        //*****  part 02  *****//
        int threeMaxCals = DumbElfCalorieTracker.findTheFoodHog(filePath, 3);
        System.out.println("part2 - Three biggest calorie totals: " + threeMaxCals);
    }
}