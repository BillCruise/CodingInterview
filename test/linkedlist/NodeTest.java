package linkedlist;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLength() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(13);
        assertEquals(7, list.length());
    }

    @Test
    public void testAppendToTailInt() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        assertEquals(4, list.length());
        
        list.appendToTail(5);
        assertEquals(5, list.length());
    }

    @Test
    public void testAppendToTailNode() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        assertEquals(4, list.length());
        
        list.appendToTail(new Node(5));
        assertEquals(5, list.length());
    }

    @Test
    public void testDeleteNodeNodeInt() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(13);
        
        assertEquals(7, list.length());
        
        list = list.deleteNode(1);
        assertEquals(6, list.length());
    }
    
    @Test
    public void testDeleteNodeNode() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        Node five = new Node(5);
        list.appendToTail(five);
        list.appendToTail(8);
        list.appendToTail(13);
        
        assertEquals(7, list.length());
        
        list.deleteNode(five);
        assertEquals(6, list.length());
    }

    @Test
    public void testRemoveDuplicates() {
        Node list = new Node(3);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(3);
        
        assertEquals(7, list.length());
        
        list.removeDuplicates();
        assertEquals(5, list.length());
    }

    @Test
    public void testKthToLastNode() {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(13);
        
        int val = list.kthToLastNode(1);
        assertEquals(13, val);
        
        val = list.kthToLastNode(2);
        assertEquals(8, val);
    }

    @Test
    public void testPartition() {
        Node numbers = new Node(10);
        numbers.appendToTail(9);
        numbers.appendToTail(8);
        numbers.appendToTail(7);
        numbers.appendToTail(6);
        numbers.appendToTail(5);
        numbers.appendToTail(4);
        numbers.appendToTail(3);
        numbers.appendToTail(2);
        numbers.appendToTail(1);
        
        numbers = numbers.partition(5);
        
        assertTrue(numbers.data < 5);
        assertTrue(numbers.next.data < 5);
        assertTrue(numbers.next.next.data < 5);
        assertTrue(numbers.next.next.next.data < 5);
        
        assertFalse(numbers.next.next.next.next.data < 5);
    }

    @Test
    public void testSum() {
        Node a1 = new Node(7);
        a1.appendToTail(1);
        a1.appendToTail(6);
        Node a2 = new Node(5);
        a2.appendToTail(9);
        a2.appendToTail(2);
        Node sum = Node.sum(a1, a2);
        
        assertEquals(2, sum.data);
        assertEquals(1, sum.next.data);
        assertEquals(9, sum.next.next.data);
    }

    @Test
    public void testFindCycle() {
        fail("Not yet implemented");
    }

    @Test
    public void testReverseCopy() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsPalindrome() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testHashCode() {
        fail("Not yet implemented");
    }

    @Test
    public void testEquals() {
        Node list1 = new Node(1);
        list1.appendToTail(1);
        list1.appendToTail(2);
        list1.appendToTail(3);
        list1.appendToTail(5);
        list1.appendToTail(8);
        list1.appendToTail(13);
        
        Node list2 = new Node(1);
        list2.appendToTail(1);
        list2.appendToTail(2);
        list2.appendToTail(3);
        list2.appendToTail(5);
        list2.appendToTail(8);
        list2.appendToTail(13);
        
        assertTrue(list1.equals(list2));
        
        list1.appendToTail(21);
        //list1.print();
        
        assertFalse(list1.equals(list2));
    }
}
