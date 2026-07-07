package Arrays.easy;

import java.util.Arrays;

public class MoveZeroesToEnd {

    /*
     * Problem:
     * Move all the zeroes to the end of the array while maintaining
     * the relative order of the non-zero elements.
     *
     * Sample Input:
     * arr = [0, 1, 0, 3, 12]
     *
     * Sample Output:
     * [1, 3, 12, 0, 0]
     *
     * Constraints:
     * - Do it in-place.
     * - Maintain the relative order of non-zero elements.
     * - Time Complexity: O(n)
     * - Space Complexity: O(1)
     */

    public static void moveZeroes(int[] arr) {

        // Write your code here
        int j = 0;
        for(int i=0;i<arr.length;i++){

            if(arr[i] != 0){
                if(arr[j] == 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }

    }

    private static void test(int[] arr, int[] expected) {

        moveZeroes(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        test(new int[]{0, 1, 0, 3, 12},
                new int[]{1, 3, 12, 0, 0});

        test(new int[]{1, 2, 3},
                new int[]{1, 2, 3});

        test(new int[]{0, 0, 0},
                new int[]{0, 0, 0});

        test(new int[]{1, 0, 2, 0, 3},
                new int[]{1, 2, 3, 0, 0});

        test(new int[]{0},
                new int[]{0});

        test(new int[]{4, 0, 5, 6, 0, 7},
                new int[]{4, 5, 6, 7, 0, 0});
    }
}