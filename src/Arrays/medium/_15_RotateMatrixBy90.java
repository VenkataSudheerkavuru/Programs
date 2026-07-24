package Arrays.medium;

import java.util.Arrays;

public class _15_RotateMatrixBy90 {

    /*
     * Problem:
     * Given an n x n matrix, rotate the matrix by 90 degrees clockwise.
     * You have to rotate the matrix in-place.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ]
     *
     * Output:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     */

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap element at (i, j) with (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            // Swap elements from both ends moving toward center
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

    }

    private static void test(int[][] input, int[][] expected) {
        rotate(input);

        boolean pass = Arrays.deepEquals(input, expected);

        System.out.println(pass ? "PASS" : "FAIL");
        System.out.println("Result  : " + Arrays.deepToString(input));
        System.out.println("Expected: " + Arrays.deepToString(expected));
        System.out.println();
    }

    public static void main(String[] args) {

        test(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                },
                new int[][]{
                        {7,4,1},
                        {8,5,2},
                        {9,6,3}
                });

        test(
                new int[][]{
                        {5,1},
                        {2,4}
                },
                new int[][]{
                        {2,5},
                        {4,1}
                });
    }
}