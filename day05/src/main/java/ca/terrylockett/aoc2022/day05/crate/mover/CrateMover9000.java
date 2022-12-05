package ca.terrylockett.aoc2022.day05.crate.mover;


// CrateMover 9000
public class CrateMover9000 extends CrateMover {
    
    public CrateMover9000(int numStacks) {
        super(numStacks);
    }

    public void moveCrate(int numCrates, String source, String target) {
        for( int i=0; i < numCrates; i++) {
            stacks.get(target).push(stacks.get(source).pop());
        }
   }
}
