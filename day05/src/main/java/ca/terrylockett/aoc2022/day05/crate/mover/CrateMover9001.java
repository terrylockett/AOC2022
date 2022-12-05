package ca.terrylockett.aoc2022.day05.crate.mover;

import ca.terrylockett.aoc2022.day05.crate.Crate;

import java.util.Deque;
import java.util.LinkedList;

// CrateMover 9001
public class CrateMover9001 extends CrateMover {

    public CrateMover9001(int numStacks) {
        super(numStacks);
    }

    public void moveCrate(int numCrates, String source, String target) {

        Deque<Crate> bucket = new LinkedList<>();
        
        for( int i=0; i < numCrates; i++) {
            bucket.addFirst(stacks.get(source).pop());
        }
        
        for(Crate crate : bucket) {
            stacks.get(target).push(crate);
        }
    }
}
