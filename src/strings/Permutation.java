package strings;

import java.util.Arrays;

/**
 * Given two strings write a method to determine if one is a permutation of the other.
 * Cracking the Coding Interview question 1.3.
 * @author Bill
 *
 */
public class Permutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "a"));
        System.out.println(isPermutation("abc", "cba"));
        System.out.println(isPermutation("abcd", "abc"));
        System.out.println(isPermutation("abcd    ", "abcd"));
        System.out.println(isPermutation("abc", "Abc"));
    }

    /**
     * Determine if one string is a permutation of another.
     * This implementation assumes only ASCII characters.
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        int[] counts1 = new int[256];
        int[] counts2 = new int[256];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        for(int i = 0; i < chars1.length; i++) {
            counts1[chars1[i]]++;
            counts2[chars2[i]]++;
        }
        
        return Arrays.equals(counts1, counts2);
    }
}
