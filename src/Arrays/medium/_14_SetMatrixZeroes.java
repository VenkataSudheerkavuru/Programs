package Arrays.medium;

import java.util.Arrays;

public class _14_SetMatrixZeroes {

    /*
     * Problem:
     * Given an m x n integer matrix, if an element is 0,
     * set its entire row and column to 0.
     * You must do it in place.
     *
     * Example 1:
     * Input:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     *
     * Output:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     *
     * Example 2:
     * Input:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     *
     * Output:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     */

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstColZero = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                firstColZero = true;
            }

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Update the inner matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

            }
        }

        // Step 3: Update the first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Update the first column
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void test(int[][] input, int[][] expected) {
        setZeroes(input);

        boolean pass = Arrays.deepEquals(input, expected);

        System.out.println(pass ? "PASS" : "FAIL");
        System.out.println("Result  : " + Arrays.deepToString(input));
        System.out.println("Expected: " + Arrays.deepToString(expected));
        System.out.println();
    }

    public static void main(String[] args) {

        test(
                new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                },
                new int[][]{
                        {1, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1}
                });

        test(
                new int[][]{
                        {0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}
                },
                new int[][]{
                        {0, 0, 0, 0},
                        {0, 4, 5, 0},
                        {0, 3, 1, 0}
                });

        test(
                new int[][]{
                        {1}
                },
                new int[][]{
                        {1}
                });

        test(
                new int[][]{
                        {0}
                },
                new int[][]{
                        {0}
                });
    }
}