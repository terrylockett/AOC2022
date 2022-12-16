package ca.terrylockett.aoc2022.day08;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDay08 {

    static final String TEST_FILE_NAME = "test_input.txt";
    static String testFilePath = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay08.class.getClassLoader(), TEST_FILE_NAME);
    }
    
    @Test
    public void testDay08Part01() throws Exception {
        assertEquals(21,TreeHouseLocator.getNumberOfVisibleTrees_Part1(testFilePath));
    }

    @Test
    public void testDay08Part02() throws Exception {
        assertEquals(8,TreeHouseLocator.getMaxScenicScore_Part2(testFilePath));
    }

    @Test
    public void testPopulateScenicScore() throws Exception {
        Grid grid = new Grid(5,5);
        grid.populateFromFile(testFilePath);

        assertEquals(4, grid.getTree(1,2).getScenicScore());

        assertEquals(8, grid.getTree(3,2).getScenicScore());
    }



    @Test
    public void testPopulateGrid() throws IOException {
        Grid grid = new Grid(5,5);
        grid.populateFromFile(testFilePath);
        
        assertEquals(3, grid.getTree(0,0).getTreeHeight());
        assertEquals(0, grid.getTree(0,1).getTreeHeight());
        assertEquals(3, grid.getTree(0,2).getTreeHeight());
        assertEquals(7, grid.getTree(0,3).getTreeHeight());
        assertEquals(3, grid.getTree(0,4).getTreeHeight());

        assertEquals(2, grid.getTree(1,0).getTreeHeight());
        assertEquals(5, grid.getTree(1,1).getTreeHeight());
        assertEquals(5, grid.getTree(1,2).getTreeHeight());
        assertEquals(1, grid.getTree(1,3).getTreeHeight());
        assertEquals(2, grid.getTree(1,4).getTreeHeight());

        assertEquals(6, grid.getTree(2,0).getTreeHeight());
        assertEquals(5, grid.getTree(2,1).getTreeHeight());
        assertEquals(3, grid.getTree(2,2).getTreeHeight());
        assertEquals(3, grid.getTree(2,3).getTreeHeight());
        assertEquals(2, grid.getTree(2,4).getTreeHeight());

        assertEquals(3, grid.getTree(3,0).getTreeHeight());
        assertEquals(3, grid.getTree(3,1).getTreeHeight());
        assertEquals(5, grid.getTree(3,2).getTreeHeight());
        assertEquals(4, grid.getTree(3,3).getTreeHeight());
        assertEquals(9, grid.getTree(3,4).getTreeHeight());

        assertEquals(3, grid.getTree(4,0).getTreeHeight());
        assertEquals(5, grid.getTree(4,1).getTreeHeight());
        assertEquals(3, grid.getTree(4,2).getTreeHeight());
        assertEquals(9, grid.getTree(4,3).getTreeHeight());
        assertEquals(0, grid.getTree(4,4).getTreeHeight());
        
    }


    @Test
    public void testGridCoreVisibility() throws IOException {
        Grid grid = new Grid(5,5);
        grid.populateFromFile(testFilePath);


        assertTrue( grid.getTree(1,1).isVisible());
        assertTrue( grid.getTree(1,2).isVisible());
        assertFalse( grid.getTree(1,3).isVisible());



        assertTrue( grid.getTree(2,1).isVisible());
        assertFalse( grid.getTree(2,2).isVisible());
        assertTrue( grid.getTree(2,3).isVisible());


        assertFalse( grid.getTree(3,1).isVisible());
        assertTrue( grid.getTree(3,2).isVisible());
        assertFalse( grid.getTree(3,3).isVisible());
    }
    

    @Test
    public void testGridBoundaryVisibility() throws IOException {
        Grid grid = new Grid(5,5);
        grid.populateFromFile(testFilePath);

        assertTrue(grid.getTree(0,0).isVisible());
        assertTrue(grid.getTree(0,1).isVisible());
        assertTrue(grid.getTree(0,2).isVisible());
        assertTrue(grid.getTree(0,3).isVisible());
        assertTrue(grid.getTree(0,4).isVisible());

        assertTrue(grid.getTree(4,0).isVisible());
        assertTrue(grid.getTree(4,1).isVisible());
        assertTrue(grid.getTree(4,2).isVisible());
        assertTrue(grid.getTree(4,3).isVisible());
        assertTrue(grid.getTree(4,4).isVisible());

        
        assertTrue(grid.getTree(0,0).isVisible());
        assertTrue(grid.getTree(1,0).isVisible());
        assertTrue(grid.getTree(2,0).isVisible());
        assertTrue(grid.getTree(3,0).isVisible());
        assertTrue(grid.getTree(4,0).isVisible());

        assertTrue(grid.getTree(0,4).isVisible());
        assertTrue(grid.getTree(1,4).isVisible());
        assertTrue(grid.getTree(2,4).isVisible());
        assertTrue(grid.getTree(3,4).isVisible());
        assertTrue(grid.getTree(4,4).isVisible());
    }
    
}

