package ca.terrylockett.aoc2022.day02;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    static final String TEST_FILE_PATH = "./etc/input/test/test_input.txt";

    @Test
    public void part01_sampleInput() throws Exception {
        assertEquals(15, RockPaperScissorsGame.playGames(TEST_FILE_PATH));
    }

    @Test
    public void part01_ties() throws Exception {
        String input = "" +
                "A X\n" + //Rock(A) vs Rock(X)
                "B Y\n" + //Paper(B) vs Paper(Y)
                "C Z";    //Scissors(C) vs Scissors(Z)

        //3 ties = 9
        //shapes = (1,2,3) = 6
        //total = 15

        int score = RockPaperScissorsGame.playGames(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(15, score);
    }

    @Test
    public void part01_wins() throws Exception {
        String input = "" +
                "A Y\n" + //rock(A) vs paper(Y)
                "B Z\n" + //paper(B) vs Scissors(Z)
                "C X";    //Scissors(C) vs Rock(X)

        //3 wins = 18
        //shapes = (1,2,3) = 6
        //total = 24

        int score = RockPaperScissorsGame.playGames(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(24, score);
    }

    @Test
    public void part01_loses() throws Exception {
        String input = "" +
                "A Z\n" + //Rock(A) vs Scissors(Z)
                "B X\n" + //Paper(B) vs Rocks(X)
                "C Y";    //Scissors(C) vs paper(Y)

        //3 loses = 0
        //shapes = (1,2,3) = 6
        //total = 6

        int score = RockPaperScissorsGame.playGames(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(6, score);
    }


    @Test void part02_sampleInput() throws Exception {

        assertEquals(12, RockPaperScissorsGame.playGames02(TEST_FILE_PATH));
    }

    @Test
    public void part02_ties() throws Exception {
        String input = "" +
                "A Y\n" + //Rock(A) -> Tie -> Rock
                "B Y\n" + //Paper(B) -> Tie -> Paper
                "C Y";    //Scissors(C) -> Tie -> Scissors

        //3 ties = 9
        //shapes = (1,2,3) = 6
        //total = 15

        int score = RockPaperScissorsGame.playGames02(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(15, score);
    }

    @Test
    public void part02_wins() throws Exception {
        String input = "" +
                "A Z\n" + //Rock(A) -> Win -> Paper
                "B Z\n" + //Paper(B) -> Win -> Scissor
                "C Z";    //Scissors(C) -> Win -> Rock

        //3 wins = 18
        //shapes = (1,2,3) = 6
        //total = 24

        int score = RockPaperScissorsGame.playGames02(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(24, score);
    }

    @Test
    public void part02_Lose() throws Exception {
        String input = "" +
                "A X\n" + //Rock(A) -> Lose -> Scissor
                "B X\n" + //Paper(B) -> Lose -> Rock
                "C X";    //Scissors(C) -> Lose -> Paper

        //3 lose = 0
        //shapes = (1,2,3) = 6
        //total = 24

        int score = RockPaperScissorsGame.playGames02(IOUtils.toInputStream(input, StandardCharsets.UTF_8));

        assertEquals(6, score);
    }

}
