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
    public void testSize() {
        Queue q = new Queue();
        assertEquals(0, q.size());
        
        q.enqueue(2);
        q.enqueue(6);
        q.enqueue(1);
        q.enqueue(8);
        assertEquals(4, q.size());
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue();
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
    }
}
