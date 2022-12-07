package ca.terrylockett.aoc2022.day06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TuningTrouble {
    
    private static final Pattern PART1_REGEX = Pattern.compile("(((((\\w)(?!\\5)(\\w))(?!\\5|\\6)(\\w))(?!(\\5|\\6|\\7)(\\w)))(?!\\5|\\6|\\7)(\\w))");
    
    public static int findStartOfPacketIndex(String inputString) throws Exception {

        Matcher m = PART1_REGEX.matcher(inputString);
        if(!m.find()) {
            throw new Exception("RIP, I have failed the regex gods");
        }
        
        
        return m.end(10);
    }
    
}
