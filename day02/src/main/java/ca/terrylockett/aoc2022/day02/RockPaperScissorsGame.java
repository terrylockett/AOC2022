package ca.terrylockett.aoc2022.day02;

import ca.terrylockett.aoc2022.day02.emun.GameResults;
import ca.terrylockett.aoc2022.day02.emun.Shapes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static int playGames(String filePath) throws Exception {
        return playGames(new FileInputStream(filePath));
    }

    static int playGames(InputStream fileInStreamPath) throws Exception {

        Scanner scan = new Scanner(fileInStreamPath);
        int gameScore = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            Shapes opponentPlay = Shapes.getShapeBasedOnChar(line.charAt(0));
            Shapes myPlay = Shapes.getShapeBasedOnChar(line.charAt(2));

            int roundScore = 0;

            switch (opponentPlay) {
                case ROCK:
                    if (myPlay == Shapes.ROCK) {
                        roundScore += 3;
                    }
                    if (myPlay == Shapes.PAPER) {
                        roundScore += 6;
                    }
                    break;
                case PAPER:
                    if (myPlay == Shapes.PAPER) {
                        roundScore += 3;
                    }
                    if (myPlay == Shapes.SCISSORS) {
                        roundScore += 6;
                    }
                    break;
                case SCISSORS:
                    if (myPlay == Shapes.SCISSORS) {
                        roundScore += 3;
                    }
                    if (myPlay == Shapes.ROCK) {
                        roundScore += 6;
                    }
                    break;
            }


            gameScore += roundScore + myPlay.playedScore;
        }

        return gameScore;
    }


    public static int playGames02(String filePath) throws Exception {
        return playGames02(new FileInputStream(filePath));
    }

    static int playGames02(InputStream fileInStreamPath) throws Exception {

        Scanner scan = new Scanner(fileInStreamPath);
        int gameScore = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            Shapes opponentPlay = Shapes.getShapeBasedOnChar(line.charAt(0));
            GameResults IntendedResult = GameResults.getResultBasedOnChar(line.charAt(2));

            int shapePlayedScore = 0;

            switch (IntendedResult) {
                case LOST: //lose
                    switch (opponentPlay) {
                        case ROCK:
                            shapePlayedScore = Shapes.SCISSORS.getPlayedScore();
                            break;
                        case PAPER:
                            shapePlayedScore = Shapes.ROCK.getPlayedScore();
                            break;
                        case SCISSORS:
                            shapePlayedScore = Shapes.PAPER.getPlayedScore();
                            break;
                    }
                    break;
                case TIE:
                    switch (opponentPlay) {
                        case ROCK:
                            shapePlayedScore = Shapes.ROCK.getPlayedScore();
                            break;
                        case PAPER:
                            shapePlayedScore = Shapes.PAPER.getPlayedScore();
                            break;
                        case SCISSORS:
                            shapePlayedScore = Shapes.SCISSORS.getPlayedScore();
                            break;
                    }
                    break;
                case WIN:
                    switch (opponentPlay) {
                        case ROCK:
                            shapePlayedScore = Shapes.PAPER.getPlayedScore();
                            break;
                        case PAPER:
                            shapePlayedScore = Shapes.SCISSORS.getPlayedScore();
                            break;
                        case SCISSORS:
                            shapePlayedScore = Shapes.ROCK.getPlayedScore();
                            break;
                    }
                    break;
            }

            gameScore += (shapePlayedScore + IntendedResult.score);

        }


        return gameScore;
    }

}
