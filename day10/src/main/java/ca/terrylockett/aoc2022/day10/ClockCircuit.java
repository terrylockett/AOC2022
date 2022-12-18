package ca.terrylockett.aoc2022.day10;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClockCircuit {
    
    Map<Integer, Integer> cyclesMap = new HashMap<>();
    int xRegister = 1;
    int cycle = 1;
    
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
