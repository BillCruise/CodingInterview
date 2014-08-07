package linkedlist;

/**
 * Implements a very basic singly-linked list.
 * 
 * Cracking the Coding Interview chapter 2.
 * @author Bill
 *
 */
public class Node {

    Node next = null;
    int data;
    
    public Node(int d) {
        data = d;
    }
    
    public static void main(String[] args) {
        Node list = new Node(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(13);
        list.print();
        
        list = list.deleteNode(list, 1);
        list.print();
        
        list = list.deleteNode(list, 5);
        list.print();
    }
    
    /**
     * Print all values in this linked list.
     */
    public void print() {
        Node n = this;
        System.out.print(n.data + " ");
        
        while(n.next != null) {
            n = n.next;
            System.out.print(n.data + " ");
        }
        System.out.println();
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
