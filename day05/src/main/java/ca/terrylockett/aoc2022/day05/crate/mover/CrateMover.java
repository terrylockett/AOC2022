package ca.terrylockett.aoc2022.day05.crate.mover;

import ca.terrylockett.aoc2022.day05.crate.Crate;
import ca.terrylockett.aoc2022.day05.crate.CrateStack;

import java.util.HashMap;
import java.util.Map;

public abstract class CrateMover {

    //yes... I'm using Strings of numbers for the keys
    protected Map<String, CrateStack> stacks;

    
    public CrateMover(int numStacks) {
        stacks = new HashMap<>();
        for (int i = 1; i <= numStacks; i++) {
            stacks.put(String.valueOf(i), new CrateStack());
        }
    }


    public abstract void moveCrate(int numCrates, String source, String target);
    
    
    public void initCrate(String stack, Crate crate) {
        stacks.get(stack).addLast(crate);
    }
    
    public String getResult() {
        String result = "";

        for (String key : stacks.keySet()) {
            result += stacks.get(key).peekFirst().getName();
        }

        return result;
    }
}
