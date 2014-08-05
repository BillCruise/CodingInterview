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
    
    /**
     * Delete the first Node with the given value from a linked list.
     * @param head
     * @param d
     * @return a linked list without the deleted Node.
     */
    Node deleteNode(Node head, int d) {
        Node n = head;
        
        if(n.data == d) {
            return head.next; // return a list that excludes the current head
        }
        
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
