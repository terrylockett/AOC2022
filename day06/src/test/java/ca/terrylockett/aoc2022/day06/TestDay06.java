package ca.terrylockett.aoc2022.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay06 {
    
    
    @Test
    public void testPart01() throws Exception{
        
        assertEquals(7, TuningTrouble.findStartOfPacketIndexPart1("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        
    }

    @Test
    public void testPart01_b() throws Exception{

        assertEquals(5, TuningTrouble.findStartOfPacketIndexPart1("bvwbjplbgvbhsrlpgdmjqwftvncz"));

    }

    @Test
    public void testPart01_c() throws Exception{

        assertEquals(6, TuningTrouble.findStartOfPacketIndexPart1("nppdvjthqldpwncqszvftbrmjlhg"));

    }

    @Test
    public void testPart01_d() throws Exception{

        assertEquals(10, TuningTrouble.findStartOfPacketIndexPart1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));

    }

    @Test
    public void testPart01_e() throws Exception{

        assertEquals(11, TuningTrouble.findStartOfPacketIndexPart1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));

    }
    
    
    @Test
    public void testPart2_a() throws Exception {
        assertEquals(19, TuningTrouble.findStartOfPacketIndexPart2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
    }


    @Test
    public void testPart2_b() throws Exception {
        assertEquals(23, TuningTrouble.findStartOfPacketIndexPart2("bvwbjplbgvbhsrlpgdmjqwftvncz"));
    }

    @Test
    public void testPart2_c() throws Exception {
        assertEquals(23, TuningTrouble.findStartOfPacketIndexPart2("nppdvjthqldpwncqszvftbrmjlhg"));
    }

    @Test
    public void testPart2_d() throws Exception {
        assertEquals(29, TuningTrouble.findStartOfPacketIndexPart2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
    }

    @Test
    public void testPart2_e() throws Exception {
        assertEquals(26, TuningTrouble.findStartOfPacketIndexPart2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }
}
