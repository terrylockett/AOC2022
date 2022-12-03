package ca.terrylockett.aoc2022.day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static int playGames(String filePath) throws Exception {
        return playGames(new FileInputStream(filePath));
    }

    static int playGames(InputStream fileInStreamPath) throws Exception {

        Scanner scan = new Scanner(fileInStreamPath);
        int gameScore = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();

            Shapes opponentPlay = Shapes.getShapeBasedOnChar(line.charAt(0));
            Shapes myPlay = Shapes.getShapeBasedOnChar(line.charAt(2));

            int roundScore = 0;

            switch(opponentPlay) {
                case ROCK: //Rock
                    if(myPlay == Shapes.ROCK){ //Ties vs rock
                        roundScore+=3;
                    }
                    if(myPlay == Shapes.PAPER){ // beats scissors
                        roundScore+=6;
                    }
                    break;
                case PAPER: //Paper
                    if(myPlay == Shapes.PAPER){ //ties paper
                        roundScore+=3;
                    }
                    if(myPlay == Shapes.SCISSORS){ //beat rock
                        roundScore+=6;
                    }
                    break;
                case SCISSORS: //Scissors
                    if(myPlay == Shapes.SCISSORS){ //ties scissors
                        roundScore+=3;
                    }
                    if(myPlay == Shapes.ROCK){ // beats papers
                        roundScore+=6;
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
        while(scan.hasNextLine()) {
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
                            shapePlayedScore =Shapes.PAPER.getPlayedScore();
                            break;
                        case SCISSORS:
                            shapePlayedScore =Shapes.SCISSORS.getPlayedScore();
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

            gameScore += (shapePlayedScore+IntendedResult.score);

        }


        return gameScore;
    }

}
