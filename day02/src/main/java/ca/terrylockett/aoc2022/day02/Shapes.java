package ca.terrylockett.aoc2022.day02;

public enum Shapes {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    final int playedScore;

    Shapes(int playedScore) {
        this.playedScore = playedScore;
    }

    public static Shapes getShapeBasedOnChar(char shapeChar) throws Exception {
        switch (shapeChar){
            case 'A':
            case 'X':
                return ROCK;
            case 'B':
            case 'Y':
                return PAPER;
            case 'C':
            case 'Z':
                return SCISSORS;
            default:
                throw new Exception("bad input dummy");
        }
    }

    public int getPlayedScore() {
        return this.playedScore;
    }


}
