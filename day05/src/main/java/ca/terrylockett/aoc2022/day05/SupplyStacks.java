package ca.terrylockett.aoc2022.day05;

import ca.terrylockett.aoc2022.day05.crate.Crate;
import ca.terrylockett.aoc2022.day05.crate.mover.CrateMover;
import ca.terrylockett.aoc2022.day05.crate.mover.CrateMover9000;
import ca.terrylockett.aoc2022.day05.crate.mover.CrateMover9001;

import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplyStacks {

    private static final Pattern CRATE_REGEX = Pattern.compile("(\\[\\w\\])");
    private static final Pattern INSTRUCTION_REGEX = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");


    //part 1 wrapper.
    public static String unload(String inputFile) throws Exception {
        return unload(inputFile, false);
    }
    
    public static String unload(String inputFile, boolean isPart2) throws Exception {

        Scanner scan = new Scanner(new FileInputStream(inputFile));
        int numStacks = (scan.nextLine().length()+1)/4;

        CrateMover crateMover;
        if(isPart2) {
            crateMover = new CrateMover9001(numStacks);
        }
        else {
            crateMover = new CrateMover9000(numStacks);
        }
        
        //reset scanner...
        scan = new Scanner(new FileInputStream(inputFile));
        
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if(line.startsWith(" 1")) {
                break;
            }
            
            Matcher m = CRATE_REGEX.matcher(line);

            int searchIndex = 0;
            while(m.find(searchIndex)){
                searchIndex = m.end(1);
                int stackNumber = (m.start(1)/4)+1;
                
                crateMover.initCrate(String.valueOf(stackNumber), new Crate(m.group(1).substring(1,2)));
            }
        }

        scan.nextLine(); //skip the blank line.
        
        //move stuff
        while(scan.hasNextLine()) {
            String line  = scan.nextLine();
            
            Matcher m = INSTRUCTION_REGEX.matcher(line);
            if(!m.find()) {
                throw new Exception("REGEX DIDN'T MATCH... PANIC!!");
            }
            
            int numberOfCratesToMove = Integer.parseInt(m.group(1));
            String sourceStack = m.group(2);
            String targetStack = m.group(3);
            
            crateMover.moveCrate(numberOfCratesToMove, sourceStack, targetStack);
        }
        
        return crateMover.getResult();
    }

}
