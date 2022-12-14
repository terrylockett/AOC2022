package ca.terrylockett.aoc2022.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//This whole class is terrible. i love it tho <3

public class Grid {
    
    private final int width;
    private final int height;
    
    private final Tree[][] treeMatrix;
    
    public Grid(int width, int height){
        this.width = width;
        this.height = height;

        treeMatrix = new Tree[this.height][this.width];
    }

    //jeebus
    public void populateFromFile(String filePath) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream(filePath));

        int row = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineCharacters = line.split("");

            for(int col=0; col < lineCharacters.length; col++){
                this.add(row, col, Integer.parseInt(lineCharacters[col]));
            }

            row++;
        }
        
        calcVisibility();
    }
    
    void add(int row, int col, int treeValue) {
        treeMatrix[row][col] = new Tree(treeValue);
    }

    
    public void calcVisibility() {
        //double loop. oh hell yea.
        for( int row=0; row<height; row++){
            for( int col=0; col<width; col++){
                
                if( row == 0  ||  col ==0 || row == height-1 || col == width-1) {
                    treeMatrix[row][col].setVisible(true);
                    continue;
                }
                
                //TODO fix this mess.
                treeMatrix[row][col].setVisible(checkVisibilityOfTree(row,col,treeMatrix[row][col].getTreeHeight()));
            }
        }
    }
    
    
    //holy hell. I am a moron.
    //Lord, please forgive these sins.
    private boolean checkVisibilityOfTree(int row, int col, int treeHeight) {
        
        //check north.
        boolean blockedVis = false;
        for(int i=0; i<row; i++){
            if (treeMatrix[i][col].getTreeHeight() >= treeHeight) {
                blockedVis = true;
                break;
            }
        }
        if(!blockedVis){
            return true;
        }
        
        //check south
        blockedVis = false;
        for(int i=row+1; i<height; i++){
            if(treeMatrix[i][col].getTreeHeight() >= treeHeight) {
                blockedVis = true;
                break;
            }
        }
        if(!blockedVis){
            return true;
        }
        
        //check west
        blockedVis = false;
        for(int i=0; i<col; i++){
            if(treeMatrix[row][i].getTreeHeight() >= treeHeight) {
                blockedVis = true;
                break;
            }
        }
        if(!blockedVis){
            return true;
        }
        
        //check east
        blockedVis = false;
        for(int i=col+1; i<width; i++){
            if(treeMatrix[row][i].getTreeHeight() >= treeHeight) {
                blockedVis = true;
                break;
            }
        }

        return !blockedVis;
    }


    public int getNumberOfVisibleTrees() {
        int num = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (treeMatrix[row][col].isVisible()) {
                    num++;
                }
            }
        }

        return num;
    }
    
    
    Tree getTree(int row, int col) {
        return this.treeMatrix[row][col];
    }
    
}
