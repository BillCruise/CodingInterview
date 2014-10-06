package queue;

public class Queue {

    private Node first;
    private Node last;
    
    /* 
     * Helper class.
     * Wrap an object reference
     * and the next Node.
     */
    private class Node {
        private Object data;
        private Node next;
        
        public Node(Object item) {
            this.data = item;
        }
    }
    
    /**
     * Add a new item to the end of the queue.
     * @param item
     */
    public void enqueue(Object item) {
        if(first == null) {
            last = new Node(item);
            first = last;
        }
        else {
            last.next = new Node(item);
            last = last.next;
        }
    }
    
    /**
     * Remove an item from the front of the queue.
     * @return
     */
    public Object dequeue() {
        if(first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
