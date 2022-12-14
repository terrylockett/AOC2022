package ca.terrylockett.aoc2022.day06;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TuningTrouble {
    
    //BDC regex.
    private static final Pattern PART1_REGEX = Pattern.compile("(((((\\w)(?!\\5)(\\w))(?!\\5|\\6)(\\w))(?!(\\5|\\6|\\7)(\\w)))(?!\\5|\\6|\\7)(\\w))");
    
    //part1
    public static int findStartOfPacketIndexPart1(String inputString) throws Exception {

        Matcher m = PART1_REGEX.matcher(inputString);
        if(!m.find()) {
            throw new Exception("RIP, I have failed the regex gods");
        }
        
        return m.end(10);
    }


    //part2
    public static int findStartOfPacketIndexPart2(String inputString) throws Exception {
        
        int lookBackLength = 14;
        String [] inputCharacters = inputString.split("");
        
        LinkedList<String> lookBackQueue = new LinkedList<>();
        
        //set first 14 chars.
        for( int i=0; i < lookBackLength; i++){
            lookBackQueue.add(inputCharacters[i]);
        }
        
        //this is a terrible way to hunt for dupes.
        for(int i=lookBackLength; i < inputCharacters.length; i++){
            lookBackQueue.add(inputCharacters[i]);
            lookBackQueue.poll();
            
            LinkedList<String> tmpList = (LinkedList<String>) lookBackQueue.clone();
            if(new HashSet<>(tmpList).size() == lookBackLength) {
                return i+1; //gg we win.
            }
        }
        
       return 0; // :(
    }
    
}
