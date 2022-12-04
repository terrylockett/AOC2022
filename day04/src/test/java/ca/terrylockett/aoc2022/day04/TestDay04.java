package ca.terrylockett.aoc2022.day04;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay04 {

    static final String TEST_FILE_NAME = "test_input.txt";
    static String testFilePath = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay04.class.getClassLoader(), TEST_FILE_NAME);
    }


    @Test
    public void day4Part1() throws Exception {
        assertEquals(2, CampAssignmentCleaner.findAssignmentsErrorsCount(testFilePath));
    }

    @Test
    public void day4Part2() throws Exception {
        assertEquals(4, CampAssignmentCleaner.findAssignmentsErrorsCount(testFilePath, true));
    }
}
