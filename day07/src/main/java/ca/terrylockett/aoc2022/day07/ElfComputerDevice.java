package ca.terrylockett.aoc2022.day07;

import ca.terrylockett.aoc2022.day07.filesystem.DeviceDir;
import ca.terrylockett.aoc2022.day07.filesystem.DeviceFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ElfComputerDevice {
    
    public static final int PART_01_MAX_FILE_SIZE = 100000;
    
    public static final long MAX_DISC_SPACE = 70000000L;
    public static final long UPDATE_SPACE = 30000000L;
    
    public static long part01(String filePath) throws FileNotFoundException {
        
        DeviceDir root = createFileSystemFromInput(filePath);
        
        List<DeviceDir> smallDirs = root.getDirsSmallerThanN(PART_01_MAX_FILE_SIZE);
        
        long total = 0;
        for(DeviceDir dir: smallDirs){
            total += dir.getDirSize();
        }
        return total;
    }

    public static long part02(String filePath) throws FileNotFoundException {
        DeviceDir root = createFileSystemFromInput(filePath);
        
        long currentFreeSpace = MAX_DISC_SPACE - root.getDirSize();
        long spaceNeeded = UPDATE_SPACE - currentFreeSpace;
        
        List<DeviceDir> dirsToDelete = root.getDirsGreaterThanN(spaceNeeded);
        dirsToDelete.sort(Comparator.comparing(DeviceDir::getDirSize));
        
        return dirsToDelete.get(0).getDirSize();
    }


    static DeviceDir createFileSystemFromInput(String filePath) throws FileNotFoundException {
        
        DeviceDir rootDir = new DeviceDir("/", null);
        Scanner scan =  new Scanner(new FileInputStream(filePath));
        
        DeviceDir currentDir = rootDir;
        
        while (scan.hasNextLine()){
            String line = scan.nextLine();;
            
            if(line.startsWith("$ ls")) {
                continue;
            }
            
            if (line.startsWith("$ cd")) {
                String dirName = line.substring(5);
                if (dirName.equals("/")) {
                    currentDir = rootDir;
                    continue;
                }
                if (dirName.equals("..")) {
                    if (currentDir.getParentDir() != null) {
                        currentDir = currentDir.getParentDir();
                    }
                    continue;
                }
                currentDir = currentDir.addDir(dirName);
                continue;
            }
            
            if(line.startsWith("dir")){
                String dirName =  line.substring(4);
                currentDir.addDir(dirName);
                continue;
            }
            
            String sizeStr = line.substring(0, line.indexOf(" "));
            String fileName = line.substring(line.indexOf(" ")+1);
            
            DeviceFile file = new DeviceFile(fileName, Integer.parseInt(sizeStr));
            currentDir.addFile(file);
        }
        return rootDir;
    }
    
}
