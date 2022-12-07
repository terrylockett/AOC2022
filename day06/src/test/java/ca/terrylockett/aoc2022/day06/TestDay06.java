package ca.terrylockett.aoc2022.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay06 {
    
    
    @Test
    public void testPart01() throws Exception{
        
        assertEquals(7, TuningTrouble.findStartOfPacketIndex("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        
    }

    @Test
    public void testPart01_b() throws Exception{

        assertEquals(5, TuningTrouble.findStartOfPacketIndex("bvwbjplbgvbhsrlpgdmjqwftvncz"));

    }

    @Test
    public void testPart01_c() throws Exception{

        assertEquals(6, TuningTrouble.findStartOfPacketIndex("nppdvjthqldpwncqszvftbrmjlhg"));

    }

    @Test
    public void testPart01_d() throws Exception{

        assertEquals(10, TuningTrouble.findStartOfPacketIndex("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));

    }

    @Test
    public void testPart01_e() throws Exception{

        assertEquals(11, TuningTrouble.findStartOfPacketIndex("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));

    }
    
}
