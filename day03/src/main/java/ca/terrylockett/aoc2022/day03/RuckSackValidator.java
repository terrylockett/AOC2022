package ca.terrylockett.aoc2022.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class RuckSackValidator {

    //part 1
    public static int findDuplicateItemsTotal(String filePath) throws FileNotFoundException {

        int total = 0;

        Scanner scan = new Scanner(new FileInputStream(filePath));

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            String compartment1 = line.substring(0, (line.length() / 2));

            Set<Integer> comp1Set = new HashSet<>();
            for (char c : compartment1.toCharArray()) {
                comp1Set.add(charToPriority(c));
            }

            String compartment2 = line.substring((line.length() / 2));

            for (char c : compartment2.toCharArray()) {
                int priority;
                if (comp1Set.contains(priority = charToPriority(c))) {
                    total += priority;
                    break;
                }
            }
        }
        return total;
    }

    //part 2
    public static int findBadgeTotals(String filePath) throws Exception {

        int total = 0;

        Scanner scan = new Scanner(new FileInputStream(filePath));

        while (scan.hasNextLine()) {

            Set<Integer> line1Set = new HashSet<>();
            for (char c : scan.nextLine().toCharArray()) {
                line1Set.add(charToPriority(c));
            }

            Set<Integer> line1And2OverlapSet = new HashSet<>();
            for (char c : scan.nextLine().toCharArray()) {
                int priority;
                if (line1Set.contains(priority = charToPriority(c))) {
                    line1And2OverlapSet.add(priority);
                }
            }

            for (char c : scan.nextLine().toCharArray()) {
                int priority;
                if (line1And2OverlapSet.contains(priority = charToPriority(c))) {
                    total += priority;
                    break;
                }
            }
        }
        return total;
    }


    /**
     * converts a char to a priority:
     * <br/>
     * <br/>
     * - Lowercase item types 'a' through 'z' have priorities 1 through 26.<br/>
     * - Uppercase item types 'A' through 'Z' have priorities 27 through 52.
     *
     * @param c char to be converted. Must be in [a-zA_Z]
     * @return priority of the character
     */
    public static int charToPriority(char c) {
        if (Character.isUpperCase(c)) {
            return c - 0x26;
        }
        return c - 0x60;
    }
}
