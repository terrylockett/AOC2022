package ca.terrylockett.aoc2022.day02;

import java.io.File;
import java.io.FileNotFoundException;

public class Day02Runner {

    public static void main(String[] args) throws Exception {

        System.out.println(new File("./").getAbsolutePath());

        String filePath = "./etc/input/main/input.txt";

        System.out.println("Part 01 Game Total: " + RockPaperScissorsGame.playGames(filePath));



        //********  part 02 **********
        System.out.println("Part 02 Game Total: " + RockPaperScissorsGame.playGames02(filePath));

    }
    
}
