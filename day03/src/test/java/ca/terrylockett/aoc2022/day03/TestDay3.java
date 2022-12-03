package ca.terrylockett.aoc2022.day03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay3 {

    static final String TEST_FILE_NAME = "test_input.txt";

    static String testFilePath = "";


    @BeforeAll
    static void setup() throws URISyntaxException {
        URL resource = TestDay3.class.getClassLoader().getResource(TEST_FILE_NAME);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + TEST_FILE_NAME);
        }

        testFilePath = new File(resource.toURI()).getAbsolutePath();
    }

    @Test
    public void testCharConversions() {
        assertEquals(1, RuckSackValidator.charToPriority('a'));
        assertEquals(2, RuckSackValidator.charToPriority('b'));
        assertEquals(25, RuckSackValidator.charToPriority('y'));
        assertEquals(26, RuckSackValidator.charToPriority('z'));

        assertEquals(27, RuckSackValidator.charToPriority('A'));
        assertEquals(28, RuckSackValidator.charToPriority('B'));
        assertEquals(51, RuckSackValidator.charToPriority('Y'));
        assertEquals(52, RuckSackValidator.charToPriority('Z'));
    }

    @Test
    public void testDay3_part1() throws Exception{
        int total = RuckSackValidator.findDuplicateItemsTotal(testFilePath);

        assertEquals(157, total);
    }



    @Test
    public void testDay3_part2() throws Exception{
        int total = RuckSackValidator.findBadgeTotals(testFilePath);

        assertEquals(70, total);
    }

}
