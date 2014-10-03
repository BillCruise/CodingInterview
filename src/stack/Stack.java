package stack;

public class Stack {

    private Node top;
    
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
     * Pop the top item off of the top
     * of the Stack and return it.
     * @return
     */
    public Object pop() {
        if(top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }
    
    /**
     * Push a new object onto the top of the Stack.
     * @param item
     */
    public void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }
    
    /**
     * Peek at the top value in the Stack
     * without popping it off of the Stack.
     * @return
     */
    public Object peek() {
        return top.data;
    }
}
