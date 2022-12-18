package ca.terrylockett.aoc2022.day09;

import com.google.common.primitives.Ints;

import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rope {

    static final Pattern MOVES_REGEX = Pattern.compile("(\\w) (\\d+)");
    
    private final Deque<Knot> knotList = new LinkedList<>();
    
    
    public Rope(int knotsCount) {
        assert knotsCount >= 2;
        
        for(int i=0; i<knotsCount; i++){
            knotList.add(new Knot());
        }
    }
    
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

        Iterator<Knot> knot_iter = knotList.iterator();
        
        Knot head = knot_iter.next();
        Knot tail ;
        
        //move head
        head.setLocation(head.x + horizontalMove, head.y + verticalMove);
        printRope();
        
        do {
            tail = knot_iter.next();

            if (Math.abs(head.x - tail.x) < 2 && Math.abs(head.y - tail.y) < 2) {
                printRope();
                return; //dont move
            }
            
            int xMove = head.x - tail.x;
            int yMove = head.y - tail.y;
            int tailXMoveDirection = Ints.constrainToRange(xMove, -1, 1);
            int tailYMoveDirection = Ints.constrainToRange(yMove, -1, 1);
            
            tail.setLocation(tail.x + tailXMoveDirection, tail.y + tailYMoveDirection);
            
            //move down the knot chain.
            head = tail;
        } while (knot_iter.hasNext());
        
    }
    
    
    void printRope() {
        if(true) //why use a debugger when you can do this to disable debugging..
            return; 

        int xmax=30;
        int ymax=30;

        for (Knot knot : knotList) {
            if( knot.x > xmax)
                xmax = knot.x;
            
            if( knot.y > ymax)
                ymax = knot.y;
        }
        
        String[][] grid = new String[xmax][ymax];

        for (String[] strings : grid) {
            Arrays.fill(strings, ".");
        }
        
        
       Iterator<Knot> knotIter = knotList.descendingIterator();
       
       int count = knotList.size();
       while(knotIter.hasNext()) {
           count--;
           Knot knot = knotIter.next();
           if (count == 0) {
               grid[knot.x][knot.y] = "H";
               continue;
           }

           grid[knot.x][knot.y] = String.valueOf(count);
       }

        System.out.println("=========");
       
        for(int i=grid[0].length-1; i>= 0; i--){
            for(int j=0; j<grid.length; j++){
                System.out.print(grid[j][i]);
            }
            System.out.println();
        }
    }
    
    
    public Knot getTailKnot() {
        return knotList.peekLast();
    }
}


