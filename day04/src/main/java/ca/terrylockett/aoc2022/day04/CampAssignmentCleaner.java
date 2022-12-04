package ca.terrylockett.aoc2022.day04;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CampAssignmentCleaner {

    private static final Pattern ASSIGN_PAT = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");



    static int findAssignmentsErrorsCount(String filePath) throws Exception {
        return findAssignmentsErrorsCount(filePath, false);
    }


    public static int findAssignmentsErrorsCount(String filePath, boolean checkOverlaps) throws Exception {

        int duplicateAssignmentCount = 0;

        Scanner scan = new Scanner(new FileInputStream(filePath));

        Matcher m;

        while(scan.hasNextLine()) {
            m = ASSIGN_PAT.matcher(scan.nextLine());
            if(!m.find()) {
                throw new Exception("REGEX DIDN'T MATCH AAHHHHHH!");
            }

            Assignment first = new Assignment(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
            Assignment second = new Assignment(Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));

            if(checkAssignmentErrors(first, second, checkOverlaps)) {
                duplicateAssignmentCount++;
            }
        }

        return duplicateAssignmentCount;
    }


    private static boolean checkAssignmentErrors(Assignment a1, Assignment a2, boolean checkOverlaps) {
        if(checkOverlaps) {
            return a1.overlapsRange(a2) || a2.overlapsRange(a1);
        }

        return a1.containsRange(a2) || a2.containsRange(a1);
    }





}
