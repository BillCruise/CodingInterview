package strings;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. The string aabcccccaaa would become a2b1c5a3.
 * If the compressed string would not be smaller than the original string,
 * the method should return the original string.
 * 
 * Cracking the Coding Interview question 1.5.
 * @author Bill
 *
 */
public class Compression {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aaaaa"));
        System.out.println(compress("bb"));
    }
    
    /**
     * Performs basic string compression.
     * @param s
     * @return
     */
    public static String compress(String s) {
        if(s.length() <= 1) {
            return s;
        }
        
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(c == s.charAt(i)) {
                count++;
            }
            else {
                sb.append(c);
                sb.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        
        sb.append(c);
        sb.append(count);
        
        return s.length() <= sb.length() ? s : sb.toString();
    }
}
