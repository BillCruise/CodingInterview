package linkedlist;

/**
 * Implements a very basic singly-linked list.
 * @author Bill
 *
 */
public class Node {

    Node next = null;
    int data;
    
    public Node(int d) {
        data = d;
    }

    /**
     * Appends a new Node to the end of the list.
     * @param d
     */
    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
