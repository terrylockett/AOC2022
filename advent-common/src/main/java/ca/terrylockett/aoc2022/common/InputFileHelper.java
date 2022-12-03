package ca.terrylockett.aoc2022.common;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class InputFileHelper {

    //This is an odd way to get files But I think its cute, so it says. <3
    public static String getFilePath(Class input, String fileName) throws URISyntaxException {
        URL resource = input.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        return new File(resource.toURI()).getAbsolutePath();
    }
}
