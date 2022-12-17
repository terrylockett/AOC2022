package ca.terrylockett.aoc2022.day09;

import ca.terrylockett.aoc2022.common.InputFileHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay09 {


    static final String TEST_FILE_NAME = "test_input.txt";
    static String testFilePath = "";

    @BeforeAll
    public static void setup() throws URISyntaxException {
        testFilePath = InputFileHelper.getFilePath(TestDay09.class.getClassLoader(), TEST_FILE_NAME);
    }
    
    @Test
    public void testDay09Part01() throws Exception {
        Rope rope = new Rope();
        rope.processMoves(testFilePath);
        
        assertEquals(2, rope.head.x);
        assertEquals(2, rope.head.y);

        assertEquals(1, rope.tail.x);
        assertEquals(2, rope.tail.y);
        
        assertEquals(13, rope.tail.getVisitedLocationsCount());
    }
    
    
    @Test
    public void testRope() throws Exception {
        Rope rope = new Rope();
        rope.move(1,0);
        
        assertEquals(1, rope.head.x);
        assertEquals(0, rope.head.y);

        assertEquals(0, rope.tail.x);
        assertEquals(0, rope.tail.y);
    }

    @Test
    public void testRope1() throws Exception {
        Rope rope = new Rope();
        rope.move(1,0);
        rope.move(1,0);

        assertEquals(2, rope.head.x);
        assertEquals(0, rope.head.y);

        assertEquals(1, rope.tail.x);
        assertEquals(0, rope.tail.y);
    }

    @Test
    public void testRope2() throws Exception {
        Rope rope = new Rope();
        rope.move(1,0);
        rope.move(0,1);

        assertEquals(1, rope.head.x);
        assertEquals(1, rope.head.y);

        assertEquals(0, rope.tail.x);
        assertEquals(0, rope.tail.y);
    }

    @Test
    public void testRope3() throws Exception {
        Rope rope = new Rope();
        rope.move(1,0);
        rope.move(0,1);
        rope.move(0,1);

        assertEquals(1, rope.head.x);
        assertEquals(2, rope.head.y);

        assertEquals(1, rope.tail.x);
        assertEquals(1, rope.tail.y);
    }

    @Test
    public void testRope4() throws Exception {
        Rope rope = new Rope();
        rope.head.x = 3;
        rope.head.y = 3;
        rope.tail.x = 3;
        rope.tail.y = 3;
        
        
        rope.move(-1,0);
        rope.move(-1,0);
        
        assertEquals(1, rope.head.x);
        assertEquals(3, rope.head.y);

        assertEquals(2, rope.tail.x);
        assertEquals(3, rope.tail.y);
    }
}
