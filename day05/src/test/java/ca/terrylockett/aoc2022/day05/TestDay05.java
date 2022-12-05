package ca.terrylockett.aoc2022.day05;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay05 {

    static final String TEST_FILE_NAME = "test_input.txt";
    static String testFilePath = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay05.class.getClassLoader(), TEST_FILE_NAME);
    }

    @Test
    public void day5Part1() throws Exception {
        String result = SupplyStacks.unload(testFilePath);
        assertEquals("CMZ", result);
    }
    
    @Test
    public void day5Part2() throws Exception {
        String result = SupplyStacks.unload(testFilePath, true);
        assertEquals("MCD", result);
    }
}
