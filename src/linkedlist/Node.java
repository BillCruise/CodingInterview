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
        next = null;
    }
    
    public Node() {
        data = 0;
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
        System.out.println("Length: " + list.length());
        System.out.println(list.kthToLastNode(1));
        
        System.out.println("\nTesting reverse copy...");
        Node reverse = list.reverseCopy();
        reverse.print();
        
        System.out.println("\nTesting delete(1)...");
        list = list.deleteNode(1);
        list.print();
        System.out.println("Length: " + list.length());
        System.out.println(list.kthToLastNode(3));
        
        list = list.deleteNode(5);
        list.print();
        System.out.println(list.kthToLastNode(3));
        
        System.out.println("\nTesting remove duplicates...");
        Node list2 = new Node(3);
        list2.appendToTail(1);
        list2.appendToTail(2);
        list2.appendToTail(3);
        list2.appendToTail(5);
        list2.appendToTail(8);
        list2.appendToTail(3);
        list2.print();
        list2.removeDuplicates();
        list2.print();
        
        System.out.println("\nTesting append to tail...");
        Node list3 = new Node(3);
        list3.appendToTail(1);
        list3.appendToTail(4);
        list3.appendToTail(1);
        Node five = new Node(5);
        list3.appendToTail(five);
        list3.appendToTail(5);
        list3.appendToTail(9);
        list3.appendToTail(2);
        list3.appendToTail(6);
        list3.print();
        list3.deleteNode(five);
        list3.print();
        
        
        System.out.println("\nTest partitioning...");
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
        numbers.print();
        numbers = numbers.partition(5);
        numbers.print();
        
        System.out.println("\nTest sum...");
        Node a1 = new Node(7);
        a1.appendToTail(1);
        a1.appendToTail(6);
        Node a2 = new Node(5);
        a2.appendToTail(9);
        a2.appendToTail(2);
        Node sum = Node.sum(a1, a2);
        a1.print();
        a2.print();
        sum.print();
        
        System.out.println("\nTest finding a cycle...");
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.appendToTail(b);
        a.appendToTail(c);
        a.appendToTail(d);
        a.appendToTail(e);
        a.appendToTail(c);
        Node s = a.findCycle();
        System.out.println("Value at start of cycle: " + s.data);
        
        System.out.println("\nTesting isPalindrome...");
        System.out.println(numbers.isPalindrome());
        Node pal = new Node(1);
        pal.appendToTail(6);
        pal.appendToTail(1);
        pal.appendToTail(8);
        pal.appendToTail(1);
        pal.appendToTail(6);
        pal.appendToTail(1);
        System.out.println(pal.isPalindrome());
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
     * Finds the length of the linked list provided.
     * @param head
     * @return
     */
    public int length() {
        int len = 1;
        Node n = this;
        while(n.next != null) {
            len++;
            n = n.next;
        }
        return len;
    }

    /**
     * Appends a new value to the end of the list.
     * @param d
     */
    void appendToTail(int d) {
        Node end = new Node(d);
        appendToTail(end);
    }
    
    /**
     * Appends a new Node to the end of the list.
     * @param end
     */
    void appendToTail(Node end) {
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
    Node deleteNode(int d) {
        Node head = this;
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
    void removeDuplicates() {
        Node current = this;
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
     * @param k
     * @return the value in the kth to last node.
     * @throws IllegalArgumentException if k is larger than the size of the list.
     */
    int kthToLastNode(int k) {
        if(k == 0) {
            throw new IllegalArgumentException("k must be > 0.");
        }
        
        Node current = this;
        
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        
        if(k > count) {
            throw new IllegalArgumentException("k is too large.");
        }
        
        int target = count - (k - 1);
        current = this;
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
    
    /**
     * Delete a node in the middle of a singly linked list
     * given only access to that node.
     * Cracking the Coding Interview question 2.3.
     * @param n
     */
    boolean deleteNode(Node n) {
        if(n == null || n.next == null) {
            return false;
        }
        
        // We can't delete n, because we don't have previous.
        // Copy the value from the next node and delete that.
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
    
    /**
     * Partitions a linked list around a value x,
     * such that all nodes less than x come before
     * all nodes greater than or equal to x.
     * 
     * Cracking the Coding Interview question 2.4.
     * @param x
     * @return
     */
    Node partition(int x) {
        Node less = null;
        Node more = null;
        
        Node current = this;
        while(current != null) {
            if(current.data < x) {
                if(less != null) {
                    less.appendToTail(current.data);
                }
                else {
                    less = new Node(current.data);
                }
            }
            else {
                if(more != null) {
                    more.appendToTail(current.data);
                }
                else {
                    more = new Node(current.data);
                }
            }
            current = current.next;
        }
        
        less.appendToTail(more);
        return less;
    }
    
    /**
     * Adds two numbers represented by linked lists and returns
     * their sum as a linked list. The two numbers are stored
     * in reverse order.
     * @param list1
     * @param list2
     * @return
     */
    public static Node sum(Node list1, Node list2) {
        return sum(list1, list2, 0);
    }
    
    private static Node sum(Node list1, Node list2, int carry) {
        if(list1 == null && list2 == null && carry == 0) {
            return null;
        }
        
        int value = carry;
        if(list1 != null) {
            value += list1.data;
        }
        if(list2 != null) {
            value += list2.data;
        }
        Node result = new Node(0);
        
        result.data = value % 10;
        
        if(list1 != null || list2 != null || value >= 10) {
            Node next = sum(list1 == null ? null : list1.next,
                            list2 == null ? null : list2.next,
                            value >= 10 ? 1 : 0);
            result.appendToTail(next);
        }
        
        return result;
    }
    
    /**
     * Find the start of a cycle in a linked list.
     * Based on Floyd's "tortoise and hare" cycle-finding algorithm.
     * http://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
     * @param head
     * @return
     */
    Node findCycle() {
        Node tortoise = this.next;
        Node hare = this.next.next;
        while(tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        
        tortoise = this;
        while(tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        
        return tortoise;
    }
    
    /**
     * Create a reversed copy of the linked 
     * list that starts at the Node provided.
     * @param head
     * @return
     */
    Node reverseCopy() {
        int len = this.length();
        int count = 1;
        
        int value = this.kthToLastNode(count);
        Node copy = new Node(value);
        count++;
        
        while(count <= len) {
            value = this.kthToLastNode(count);
            copy.appendToTail(value);
            count++;
        }
        
        return copy;
    }
    
    /**
     * Tests to see if the given linked list is a palindrome.
     * Uses the reverse and check approach.
     * @param list
     * @return
     */
    boolean isPalindrome() {
        Node reverse = this.reverseCopy();

        Node n = this;
        Node r = reverse;
        if(n.data != r.data) {
            return false;
        }
        
        while(n.next != null) {
            n = n.next;
            r = r.next;
            if(n.data != r.data) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (data != other.data)
            return false;
        if (this.length() != other.length())
            return false;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        
        Node n = this;
        Node o = other;
        while(n.next != null) {
            n = n.next;
            o = o.next;
            if(n.data != o.data) {
                return false;
            }
        }
        return true;
    }
}
