package queue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Queue q = new Queue();
        assertEquals(0, q.size());
        
        q.enqueue(2);
        q.enqueue(6);
        q.enqueue(1);
        q.enqueue(8);
        assertEquals(4, q.size());
    }

}
