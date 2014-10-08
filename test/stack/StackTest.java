package stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSize() {
        Stack s = new Stack();
        assertEquals(0,  s.size());
        
        s.push(3);
        s.push(1);
        s.push(4);
        assertEquals(3, s.size());
    }

}
