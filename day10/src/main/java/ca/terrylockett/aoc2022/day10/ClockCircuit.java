package ca.terrylockett.aoc2022.day10;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClockCircuit {
    
    private final Map<Integer, Integer> cyclesMap = new HashMap<>();
    private int xRegister = 1;
    private int cycle = 1;
    
    public void procesInstructionSet(String filePath) throws Exception{
        Scanner scan = new Scanner(new FileInputStream(filePath));
        
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String command = line.substring(0,4);
            
            if(command.equals("noop")){
                cyclesMap.put(cycle, xRegister);
                this.cycle++;
            }
            else {
                int addValue = Integer.parseInt(line.substring(5));
                cyclesMap.put(cycle, xRegister);
                this.cycle++;
                cyclesMap.put(cycle, xRegister);
                this.cycle++;
                xRegister += addValue;
            }
        }
    }

    //part2
    public String renderCrtLine(int lineNumber) {
        int startIndex = lineNumber * 40;
        int endIndex =  startIndex + 40;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=startIndex; i<endIndex; i++){
            
            int currentPixel = i%40;
            int spritePos = cyclesMap.get(i+1);
            
            if( currentPixel < spritePos-1 || currentPixel > spritePos+1) {
                sb.append(".");
                continue;
            }
            sb.append("#");
        }
        
        return sb.toString();
    }
    
    //part1 answer
    public int calcSignalStrengthsSum() {
        int totalSignalStrength = 0;
        
        for (int i=20; i<=220; i +=40){
            totalSignalStrength += (cyclesMap.get(i)*i);
        }
        
        return totalSignalStrength;
    }
    

    public Map<Integer, Integer> getCyclesMap() {
        return cyclesMap;
    }
}
