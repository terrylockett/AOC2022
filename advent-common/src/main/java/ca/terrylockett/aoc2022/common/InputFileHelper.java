package ca.terrylockett.aoc2022.common;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class InputFileHelper {

    /**
     *
     * This is an odd way to get files, but I think its cute, so it says. <3
     * <br/><br/>
     * Running a main method in intellij vs running it from the run task will have different working dirs which breaks relative paths to the input file.
     * As a mucked up way around this I put the input file into the resources dir and then class load the file to find the path.
     *
     * @param classLoader class loader to use.
     * @param fileName name of the file.
     * @return The absolute path to the file.
     */
    public static String getFilePath(ClassLoader classLoader, String fileName) throws URISyntaxException {
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        return new File(resource.toURI()).getAbsolutePath();
    }
}
