import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 1;
        numbers[1] = 2;
        // numbers[10] = 9; // Index doesn't exist

        System.out.println(numbers); /* Printing an array prints the memory location of the array */

        System.out.println(Arrays.toString(numbers));

        int[] newNumbers = { 1, 2, 4, 6, 8};
        System.out.println(newNumbers.length);

        // Multiple dimensions
        int[][] matrix = new int[2][3];

        matrix[0][0] = 1;

        System.out.println(Arrays.toString(matrix)); // Prints the memory location again because it's multidimensional
        System.out.println(Arrays.deepToString(matrix)); // For printing objects

        int[][] litmatrix = { {1, 2, 3}, {4, 5, 6} };
        System.out.println(Arrays.deepToString(litmatrix)); // For printing objects
    }
}