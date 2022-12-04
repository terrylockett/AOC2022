package ca.terrylockett.aoc2022.day04;

public class Assignment {

    private final int start;
    private final int end;

    public Assignment(int start, int end) {
        this.start = start;
        this.end = end;
    }


    //part1
    public boolean containsRange(Assignment assignmentIn) {
        return (assignmentIn.getStart() >= start && assignmentIn.getEnd() <= end);
    }

    //part2
    public boolean overlapsRange(Assignment assignmentIn) {

        return (isIntInRange(assignmentIn.getStart()) || isIntInRange(assignmentIn.getEnd()));
    }

    private boolean isIntInRange(int i) {
        return (i >= start && i <= end);
    }



    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
