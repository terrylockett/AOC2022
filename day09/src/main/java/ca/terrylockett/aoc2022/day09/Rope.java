package ca.terrylockett.aoc2022.day09;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rope {

    static final Pattern MOVES_REGEX = Pattern.compile("(\\w) (\\d+)");
    
    Knot head = new Knot();
    Knot tail = new Knot();

    

    public void processMoves(String filePath) throws Exception {
        Scanner scan = new Scanner(new FileInputStream(filePath));
        
        while(scan.hasNextLine()){
            String line = scan.nextLine();;
            Matcher m = MOVES_REGEX.matcher(line);
            if(!m.find()) {
                throw new Exception("REGEX DIDNT MATCH");
            }
            
            String direction = m.group(1);
            int distance = Integer.parseInt(m.group(2));
            
            switch (direction) {
                case "U":
                    moveNTimes(0,1,distance);
                    break;
                case "D":
                    moveNTimes(0,-1,distance);
                    break;
                case "L":
                    moveNTimes(-1,0,distance);
                    break;
                case "R":
                    moveNTimes(1,0,distance);
                    break;
            }
        }
    }
    
    
    void moveNTimes(int x, int y, int n){
        for(int i=0;i<n;i++){
            move(x,y);
        }
    }
    
    void move(int horizontalMove, int verticalMove) {
        //move head
        head.setLocation(head.x + horizontalMove, head.y + verticalMove);
        
        //move tail.
        if (Math.abs(head.x - tail.x) < 2 && Math.abs(head.y - tail.y) < 2) {
            //dont move
            return;
        }
        
        tail.setLocation(head.x + (-1 * horizontalMove), head.y + (-1 * verticalMove));
    }


}


