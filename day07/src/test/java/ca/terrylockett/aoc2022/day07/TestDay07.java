package ca.terrylockett.aoc2022.day07;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import ca.terrylockett.aoc2022.day07.filesystem.DeviceDir;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDay07 {

    static final String TEST_FILE_NAME = "test_input.txt";
    static String testFilePath = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay07.class.getClassLoader(), TEST_FILE_NAME);
    }
    
    
    @Test
    public void testDay07Part1() throws Exception {
        assertEquals(95437,  ElfComputerDevice.part01(testFilePath));
    }
    
    @Test
    public void testCreateFileSystemFromInput() throws FileNotFoundException {
        DeviceDir root = ElfComputerDevice.createFileSystemFromInput(testFilePath);
        
        //root dir
        assertEquals(2, root.getFiles().size());
        assertTrue(root.getFiles().containsKey("b.txt"));
        assertEquals(14848514, root.getFiles().get("b.txt").getSize());
        assertTrue(root.getFiles().containsKey("c.dat"));
        assertEquals(8504156, root.getFiles().get("c.dat").getSize());
        assertEquals(2, root.getDirs().size());
        assertTrue(root.getDirs().containsKey("a"));
        assertTrue(root.getDirs().containsKey("d"));
        
        //dir a
        DeviceDir aDir = root.getDirs().get("a");
        assertEquals(3, aDir.getFiles().size());
        assertTrue(aDir.getFiles().containsKey("f"));
        assertEquals(29116, aDir.getFiles().get("f").getSize());
        assertTrue(aDir.getFiles().containsKey("g"));
        assertEquals(2557, aDir.getFiles().get("g").getSize());
        assertTrue(aDir.getFiles().containsKey("h.lst"));
        assertEquals(62596, aDir.getFiles().get("h.lst").getSize());
        assertEquals(1, aDir.getDirs().size());
        assertTrue(aDir.getDirs().containsKey("e"));
        
        //dir e
        DeviceDir eDir = aDir.getDirs().get("e");
        assertEquals(1, eDir.getFiles().size());
        assertTrue(eDir.getFiles().containsKey("i"));
        assertEquals(584, eDir.getFiles().get("i").getSize());
        assertEquals(0, eDir.getDirs().size());
        
        //dir d
        DeviceDir dDir = root.getDirs().get("d");
        assertEquals(4, dDir.getFiles().size());
        assertTrue(dDir.getFiles().containsKey("j"));
        assertEquals(4060174, dDir.getFiles().get("j").getSize());
        assertTrue(dDir.getFiles().containsKey("d.log"));
        assertEquals(8033020, dDir.getFiles().get("d.log").getSize());
        assertTrue(dDir.getFiles().containsKey("d.ext"));
        assertEquals(5626152, dDir.getFiles().get("d.ext").getSize());
        assertTrue(dDir.getFiles().containsKey("k"));
        assertEquals(7214296, dDir.getFiles().get("k").getSize());
        assertEquals(0, dDir.getDirs().size());
    }
    
    @Test
    public void testDirSizes() throws Exception {
        DeviceDir root = ElfComputerDevice.createFileSystemFromInput(testFilePath);
        
        assertEquals(48381165, root.getDirSize());

        assertEquals(94853, root.getDirs().get("a").getDirSize());

        assertEquals(584, root.getDirs().get("a").getDirs().get("e").getDirSize());

        assertEquals(24933642, root.getDirs().get("d").getDirSize());
    }
    
}
