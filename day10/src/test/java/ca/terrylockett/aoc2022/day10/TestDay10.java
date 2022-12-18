package ca.terrylockett.aoc2022.day10;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay10 {

    static final String TEST_FILE1 = "test_input1.txt";
    static final String TEST_FILE2 = "test_input2.txt";
    static String testFile1Path = "";
    static String testfile2Path = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFile1Path = InputFileHelper.getFilePath(TestDay10.class.getClassLoader(), TEST_FILE1);
        testfile2Path = InputFileHelper.getFilePath(TestDay10.class.getClassLoader(), TEST_FILE2);
    }
    
    @Test
    public void testDay10Part01_a() throws Exception {
        ClockCircuit clock = new ClockCircuit();
        
        clock.procesInstructionSet(testFile1Path);
        
        assertEquals(1, clock.getCyclesMap().get(1));
        assertEquals(1, clock.getCyclesMap().get(2));
        assertEquals(1, clock.getCyclesMap().get(3));
        assertEquals(4, clock.getCyclesMap().get(4));
        assertEquals(4, clock.getCyclesMap().get(5));
    }

    @Test
    public void testDay10Part01_b() throws Exception {
        ClockCircuit clock = new ClockCircuit();
        clock.procesInstructionSet(testfile2Path);

        assertEquals(13140, clock.calcSignalStrengthsSum());
    }

    @Test
    public void testDay10Part02() throws Exception {
        ClockCircuit clock = new ClockCircuit();
        clock.procesInstructionSet(testfile2Path);
        
        String expectedLine0 = "##..##..##..##..##..##..##..##..##..##..";
        assertEquals(expectedLine0, clock.renderCrtLine(0));
        
        String expectedLine1 = "###...###...###...###...###...###...###.";
        assertEquals(expectedLine1, clock.renderCrtLine(1));

        String expectedLine2 ="####....####....####....####....####....";
        assertEquals(expectedLine2, clock.renderCrtLine(2));

        String expectedLine3 ="#####.....#####.....#####.....#####.....";
        assertEquals(expectedLine3, clock.renderCrtLine(3));

        String expectedLine4 ="######......######......######......####";
        assertEquals(expectedLine4, clock.renderCrtLine(4));

        String expectedLine5 ="#######.......#######.......#######.....";
        assertEquals(expectedLine5, clock.renderCrtLine(5));
    }
    
    @Test
    public void testCyclesMapValues() throws Exception {
        ClockCircuit clock = new ClockCircuit();
        clock.procesInstructionSet(testfile2Path);

        assertEquals(21, clock.getCyclesMap().get(20));
        assertEquals(19, clock.getCyclesMap().get(60));
        assertEquals(18, clock.getCyclesMap().get(100));
        assertEquals(21, clock.getCyclesMap().get(140));
        assertEquals(16, clock.getCyclesMap().get(180));
        assertEquals(18, clock.getCyclesMap().get(220));
    }
    
}
