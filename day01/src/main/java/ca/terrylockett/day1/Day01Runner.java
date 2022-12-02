package ca.terrylockett.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

public class Day01Runner {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

        ClassLoader classLoader = Day01Runner.class.getClassLoader();
        URL resource = classLoader.getResource("input.txt");
        String filePath = new File(resource.toURI()).getAbsolutePath();


        //*****  part 01  *****//
        int maxCals = DumbElfCalorieTracker.findTheFoodHog(filePath);
        System.out.println("part1 - biggest calorie total: " + maxCals);

        //*****  part 02  *****//
        int threeMaxCals = DumbElfCalorieTracker.findTheFoodHog(filePath, 3);
        System.out.println("part2 - Three biggest calorie totals: " + threeMaxCals);
    }
}