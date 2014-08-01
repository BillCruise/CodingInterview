package utils;

public class Printer {
    
    /**
     * Pretty-print convenience function for 2D int arrays.
     * @param img
     */
    public static void printMatrix(int[][] img) {
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[i].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }
}
