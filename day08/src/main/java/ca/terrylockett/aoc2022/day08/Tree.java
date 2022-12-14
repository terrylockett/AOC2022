package ca.terrylockett.aoc2022.day08;

public class Tree {
    
    private boolean visible = false;
    private final int height;
    
    public Tree(int height){
        this.height = height;
    }


    
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getTreeHeight() {
        return height;
    }
}
