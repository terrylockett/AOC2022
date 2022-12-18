package ca.terrylockett.aoc2022.day09;

import java.util.HashSet;
import java.util.Set;

public class Knot {
    
    public int x = 12;
    public int y = 12;
    
    private final Set<String> tracksMap = new HashSet<>();
    
    public Knot() {
        this.setLocation(x,y);
    }
    
    public void setLocation(int x, int y) {
        tracksMap.add(x+"-"+y);
        this.x = x;
        this.y = y;
    }
    
    
    public int getVisitedLocationsCount() {
        return tracksMap.size();
    }
    
}
