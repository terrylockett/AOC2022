package ca.terrylockett.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay01 {

    private static final String TEST_FILE_NAME = "test_input.txt";

    static String testFilePath ;

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = getFileAbsPath(TEST_FILE_NAME);
    }

    @Test
    public void test1_a() throws URISyntaxException, FileNotFoundException {
        assertEquals(24000, DumbElfCalorieTracker.findTheFoodHog(testFilePath));
    }


    @Test
    public void test1_b() throws URISyntaxException, FileNotFoundException {
        assertEquals(45000, DumbElfCalorieTracker.findTheFoodHog(testFilePath,3));
    }


    //What a way to load a file.
    //truly magnificent.
    static String getFileAbsPath(String fileName) throws URISyntaxException {
        ClassLoader classLoader = DumbElfCalorieTracker.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        return new File(resource.toURI()).getAbsolutePath();
    }

}
