package strings;

/**
 * Implement a function to reverse a string.
 * Cracking the Coding Interview question 1.2.
 * @author Bill
 *
 */
public class Reverse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(alphabet);
        System.out.println(reverse(alphabet));

    }
    
    /**
     * Reverses the input string.
     * Converts input to a char array to reverse in-place.
     * @param s
     * @return
     */
    public static String reverse(String s) {
        if(s.length() <= 1) {
            return s;
        }
        
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            // swap characters
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(c);
    }
}
