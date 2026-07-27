package Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16_SpiralMatrix {

    /*
     * Problem:
     * Given an m x n matrix, return all elements of the matrix in spiral order.
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
     * [1,2,3,6,9,8,7,4,5]
     */

    public static List<Integer> spiralOrder(int[][] matrix) {

        // Write your code here
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {

            // Top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Check BEFORE printing bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Check BEFORE printing left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    private static void test(int[][] matrix, List<Integer> expected) {

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result.equals(expected) ? "PASS" : "FAIL");
        System.out.println("Result  : " + result);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    public static void main(String[] args) {

        test(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                },
                Arrays.asList(1,2,3,6,9,8,7,4,5)
        );

        test(
                new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}
                },
                Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7)
        );
    }
}