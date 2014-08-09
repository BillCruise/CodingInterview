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
        System.out.println(list.kthToLastNode(list, 1));
        
        list = list.deleteNode(list, 1);
        list.print();
        System.out.println(list.kthToLastNode(list, 3));
        
        list = list.deleteNode(list, 5);
        list.print();
        System.out.println(list.kthToLastNode(list, 3));
        
        Node list2 = new Node(3);
        list2.appendToTail(1);
        list2.appendToTail(2);
        list2.appendToTail(3);
        list2.appendToTail(5);
        list2.appendToTail(8);
        list2.appendToTail(3);
        list2.print();
        list2.removeDuplicates(list2);
        list2.print();
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
    
    /**
     * Write code to remove duplicates from an unsorted list.
     * This implementation uses the "runner" technique.
     * 
     * Cracking the Coding Interview question 2.1.
     * @param head
     */
    void removeDuplicates(Node head) {
        if(head == null) {
            return;
        }
        
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
    /**
     * Find the kth to last element of a singly linked list.
     * Iterative approach.
     * Cracking the Coding Interview question 2.2.
     * @param head
     * @param k
     * @return the value in the kth to last node.
     * @throws IllegalArgumentException if k is larger than the size of the list.
     */
    int kthToLastNode(Node head, int k) {
        if(k == 0) {
            throw new IllegalArgumentException("k must be > 0.");
        }
        
        Node current = head;
        
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        
        if(k > count) {
            throw new IllegalArgumentException("k is too large.");
        }
        
        int target = count - (k - 1);
        current = head;
        count = 0;
        while(current != null) {
            count++;
            if(count == target) {
                return current.data;
            }
            current = current.next;
        }
        return current.data;
    }
}
