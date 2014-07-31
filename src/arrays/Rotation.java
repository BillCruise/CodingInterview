package arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * 
 * Cracking the Coding Interview question 1.6.
 * @author Bill
 *
 */
public class Rotation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] img3 = { {1, 2, 3}, 
                         {3, 4, 5}, 
                         {6, 7, 8} };
        int[][] img4 = { {1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16} };
        
        printMatrix(img3);
        System.out.println();
        rotate90CCW(img3);
        printMatrix(img3);
        
        System.out.println();
        
        printMatrix(img4);
        System.out.println();
        rotate90CCW(img4);
        printMatrix(img4);
    }
    
    /**
     * Rotate an image by 90 degrees in-place.
     * @param image
     */
    public static void rotate90CCW(int[][] image) {
        if(image.length != image[0].length) {
            throw new IllegalArgumentException("The matrix must be square.");
        }
        
        double n = image.length;
        int f = (int)Math.floor(n/2);
        int c = (int)Math.ceil(n/2);
        
        // rotate 4 "pixels" of the image at a time
        for(int x = 0; x < f; x++) {
            for(int y = 0; y < c; y++) {
                int temp = image[x][y];
                image[x][y] = image[y][image.length-1-x];
                image[y][image.length-1-x] = image[image.length-1-x][image.length-1-y];
                image[image.length-1-x][image.length-1-y] = image[image.length-1-y][x];
                image[image.length-1-y][x] = temp;
            }
        }
    }
    
    /**
     * Pretty-print convenience function.
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
