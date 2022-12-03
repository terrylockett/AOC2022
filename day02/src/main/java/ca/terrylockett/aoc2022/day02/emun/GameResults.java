package ca.terrylockett.aoc2022.day02.emun;

public enum GameResults {
    LOST(0),
    TIE(3),
    WIN(6);



    public final int score;

    GameResults(int score) {
        this.score = score;
    }

    public static GameResults getResultBasedOnChar(char input) throws Exception {
        switch (input){
            case 'X':
                return LOST;
            case 'Y':
                return TIE;
            case 'Z':
                return WIN;
            default:
                throw new Exception("bad input dummy");
        }
    }
}
