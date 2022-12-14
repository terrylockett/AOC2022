package ca.terrylockett.aoc2022.day07.filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceDir {
    
    private final String name;
    private Map<String, DeviceFile> files = new HashMap<>();
    private Map<String, DeviceDir> dirs = new HashMap<>();
    private DeviceDir parentDir;
    
    public DeviceDir(String name, DeviceDir parentDir) {
        this.name = name;
        this.parentDir = parentDir;
    }

    
    public DeviceDir addDir(String name) {
        if(!dirs.containsKey(name)) {
            dirs.put(name, new DeviceDir(name, this));
        }
        
        return dirs.get(name);
    }
    
    public void addFile(DeviceFile file) {
        this.files.put(file.getName(), file);
    }
    
    public DeviceDir getParentDir(){
        return parentDir;
    }

    public long getDirSize() {
        long total = 0L;
        
        for(String fileKey: files.keySet()){
            total += files.get(fileKey).getSize();
        }

        for(String dirKey: dirs.keySet()){
            total += dirs.get(dirKey).getDirSize();
        }
        
        return total;
    }
    
    public List<DeviceDir> getDirsSmallerThanN(int n){
        List<DeviceDir> returnDirs = new ArrayList<>();
        
        for(String dirKey: dirs.keySet()){
            long dirSize = dirs.get(dirKey).getDirSize();
            if(dirSize <= n){
                returnDirs.add(dirs.get(dirKey));
            }
            returnDirs.addAll(dirs.get(dirKey).getDirsSmallerThanN(n));
        }
        
        return returnDirs;
    }

    public List<DeviceDir> getDirsGreaterThanN(long n){
        List<DeviceDir> returnDirs = new ArrayList<>();

        for(String dirKey: dirs.keySet()){
            long dirSize = dirs.get(dirKey).getDirSize();
            if(dirSize >= n){
                returnDirs.add(dirs.get(dirKey));
            }
            returnDirs.addAll(dirs.get(dirKey).getDirsGreaterThanN(n));
        }

        return returnDirs;
    }
    
    
    
    public Map<String, DeviceFile> getFiles() {
        return this.files;
    }

    public Map<String, DeviceDir> getDirs() {
        return this.dirs;
    }
    
    public String getName() {
        return name;
    }
}
