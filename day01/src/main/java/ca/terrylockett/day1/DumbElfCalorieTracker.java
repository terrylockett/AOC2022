package ca.terrylockett.day1;

import com.google.common.collect.TreeMultiset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class DumbElfCalorieTracker {


    // part 1 wrapper
    public static int findTheFoodHog(String pathToFile) throws FileNotFoundException, URISyntaxException {
        return findTheFoodHog(pathToFile, 1);
    }


    public static int findTheFoodHog(String pathToFile, int numElfs) throws FileNotFoundException, URISyntaxException {

        TreeMultiset<Integer> maxCalsSet = initTree(numElfs);

        Scanner scan = new Scanner(new FileInputStream(pathToFile));

        int currentElfFoodCount = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.length() > 0) {
                currentElfFoodCount += Integer.parseInt(line);
            } else {
                if (currentElfFoodCount > maxCalsSet.firstEntry().getElement()) {
                    maxCalsSet.add(currentElfFoodCount);
                    maxCalsSet.pollFirstEntry();
                }

                currentElfFoodCount = 0;
            }

        }
        if (currentElfFoodCount > maxCalsSet.firstEntry().getElement()) {
            maxCalsSet.add(currentElfFoodCount);
            maxCalsSet.pollFirstEntry();
        }

        System.out.println("final list:" + Arrays.toString(maxCalsSet.toArray()));

        return  maxCalsSet.stream().mapToInt(Integer::intValue).sum();
    }

    private static TreeMultiset<Integer> initTree(int n) {
        TreeMultiset<Integer> tree = TreeMultiset.create();

        for(int i =0; i< n; i++){
            tree.add(i*-1);
        }

        return tree;
    }

}
