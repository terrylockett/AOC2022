package ca.terrylockett.aoc2022.day07.filesystem;

public class DeviceFile {
    
    private final String name;
    private final int size;
    
    public DeviceFile( String name, int size){
        this.name = name;
        this.size = size;
    }
    
    
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
