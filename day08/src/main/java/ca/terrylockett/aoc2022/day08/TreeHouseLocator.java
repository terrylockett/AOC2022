package ca.terrylockett.aoc2022.day08;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class TreeHouseLocator {
    
    
    private static Grid createGrid(String filePath) throws IOException {
        int width = Objects.requireNonNull(com.google.common.io.Files.asCharSource(new File(filePath), StandardCharsets.UTF_8).readFirstLine()).length();
        int height;
        try (Stream<String> s = Files.lines(Paths.get(filePath))) {
            height = (int) s.count();
        }
        
        return new Grid(width, height);
    }
    
    //part1 
    public static int getNumberOfVisibleTrees_Part1(String filePath) throws IOException {
        Grid grid = createGrid(filePath);
        grid.populateFromFile(filePath);
        
        return grid.getNumberOfVisibleTrees();
    }

    public static int getMaxScenicScore_Part2(String filePath) throws IOException {
        Grid grid = createGrid(filePath);
        grid.populateFromFile(filePath); //why two lines for this?

        return grid.getMaxScenicScore();
    }
    
}
