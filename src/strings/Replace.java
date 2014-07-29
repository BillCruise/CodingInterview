package strings;

/**
 * Replace all spaces in a string with '%20'.
 * Cracking the Coding Interview question 1.4.
 * @author Bill
 *
 */
public class Replace {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(replaceSpaces("abcdefg"));
        System.out.println(replaceSpaces("The quick brown fox jumped over the lazy dog."));
        System.out.println(replaceSpaces("The quick brown fox   "));
    }
    
    /**
     * Replaces all spaces in a string with '%20'.
     * @param s
     * @return
     */
    public static String replaceSpaces(String s) {
        // count the spaces in the original string
        int nSpaces = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                nSpaces++;
            }
        }
        
        if(nSpaces == 0) {
            return s;
        }
        
        char[] chars = new char[s.length() + (nSpaces * 2)];
        
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            }
            else {
                chars[j++] = s.charAt(i);
            }
        }
        
        return new String(chars);
    }
}
