package ca.terrylockett.aoc2022.day11;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay11 {

    static final String TEST_FILE = "test_input.txt";
    static String testFilePath = "";

    MonkeyProcessor mp;
    
    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay11.class.getClassLoader(), TEST_FILE);
    }
    
    @BeforeEach
    public void setupMonkeys() throws FileNotFoundException {
        mp = new MonkeyProcessor();
        mp.processInput(testFilePath);
    }

    
    @Test
    public void testDay11Part01() throws Exception {
        mp.playNRounds(20);

        assertEquals(10605, mp.getMonkeyBusinessScore());
    }
    
    @Test
    public void testMonkeyProcessor_loadInput_monkey0() throws Exception{
        Monkey testMonkey = mp.getMonkeys().get(0);
        List<Integer> expectedItems = List.of(79, 98);
        
        assertEquals(0, testMonkey.getName());
        assertEquals(expectedItems, testMonkey.getItems());
        assertEquals("*", testMonkey.getOperationOperator());
        assertEquals("19", testMonkey.getOperationValue());
        assertEquals(23, testMonkey.getTest());
        assertEquals(2, testMonkey.getTrueDestination());
        assertEquals(3, testMonkey.getFalseDestination());
    }

    @Test
    public void testMonkeyProcessor_loadInput_monkey1() throws Exception{
        Monkey testMonkey = mp.getMonkeys().get(1);
        List<Integer> expectedItems = List.of(54, 65, 75, 74);
        
        assertEquals(1, testMonkey.getName());
        assertEquals(expectedItems, testMonkey.getItems());
        assertEquals("+", testMonkey.getOperationOperator());
        assertEquals("6", testMonkey.getOperationValue());
        assertEquals(19, testMonkey.getTest());
        assertEquals(2, testMonkey.getTrueDestination());
        assertEquals(0, testMonkey.getFalseDestination());
    }

    @Test
    public void testMonkeyProcessor_loadInput_monkey2() throws Exception{
        MonkeyProcessor mp = new MonkeyProcessor();
        mp.processInput(testFilePath);
        Monkey testMonkey = mp.getMonkeys().get(2);
        List<Integer> expectedItems = List.of(79, 60, 97);


        assertEquals(2, testMonkey.getName());
        assertEquals(expectedItems, testMonkey.getItems());
        assertEquals("*", testMonkey.getOperationOperator());
        assertEquals("old", testMonkey.getOperationValue());
        assertEquals(13, testMonkey.getTest());
        assertEquals(1, testMonkey.getTrueDestination());
        assertEquals(3, testMonkey.getFalseDestination());
    }

    @Test
    public void testMonkeyProcessor_loadInput_monkey3() throws Exception{
        Monkey testMonkey = mp.getMonkeys().get(3);
        List<Integer> expectedItems = List.of(74);
        
        assertEquals(3, testMonkey.getName());
        assertEquals(expectedItems, testMonkey.getItems());
        assertEquals("+", testMonkey.getOperationOperator());
        assertEquals("3", testMonkey.getOperationValue());
        assertEquals(17, testMonkey.getTest());
        assertEquals(0, testMonkey.getTrueDestination());
        assertEquals(1, testMonkey.getFalseDestination());
    }

    
    @Test
    public void testRound1() throws Exception {
        mp.playOneRound();

        List<Integer> expectedItems = List.of(20, 23, 27, 26);
        assertEquals(expectedItems, mp.getMonkeys().get(0).getItems());
        
        expectedItems = List.of(2080, 25, 167, 207,401,1046);
        assertEquals(expectedItems, mp.getMonkeys().get(1).getItems());
        
        assertEquals(0, mp.getMonkeys().get(2).getItems().size());
        assertEquals(0, mp.getMonkeys().get(3).getItems().size());
    }

    @Test
    public void testRound2() throws Exception {
        mp.playNRounds(2);

        List<Integer> expectedItems = List.of(695, 10, 71, 135,350);
        assertEquals(expectedItems, mp.getMonkeys().get(0).getItems());
        
        expectedItems = List.of(43, 49, 58, 55,362);
        assertEquals(expectedItems, mp.getMonkeys().get(1).getItems());

        assertEquals(0, mp.getMonkeys().get(2).getItems().size());
        assertEquals(0, mp.getMonkeys().get(3).getItems().size());
    }

    @Test
    public void testRound20() throws Exception {
        mp.playNRounds(20);

        List<Integer> expectedItems = List.of(10, 12, 14, 26, 34);
        assertEquals(expectedItems, mp.getMonkeys().get(0).getItems());

        expectedItems = List.of(245, 93, 53, 199, 115);
        assertEquals(expectedItems, mp.getMonkeys().get(1).getItems());

        assertEquals(0, mp.getMonkeys().get(2).getItems().size());
        assertEquals(0, mp.getMonkeys().get(3).getItems().size());
        
        assertEquals(101, mp.getMonkeys().get(0).getInspectionCount());
        assertEquals(95, mp.getMonkeys().get(1).getInspectionCount());
        assertEquals(7, mp.getMonkeys().get(2).getInspectionCount());
        assertEquals(105, mp.getMonkeys().get(3).getInspectionCount());
    }

}
