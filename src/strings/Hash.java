package strings;

public class Hash {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(hash("leepadg"));
    }
    
    /**
     * Implementation of the hash function found at
     * https://trello.com/jobs/developer
     * 
     * @param s
     * @return
     */
    public static long hash(String s) {
        long h = 7;
        String letters = "acdegilmnoprstuw";
        for(int i = 0; i < s.length(); i++) {
            h = (h * 37 + letters.indexOf(s.charAt(i)));
        }
        return h;
    }
}
