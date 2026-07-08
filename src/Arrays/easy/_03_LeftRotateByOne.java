package Arrays.easy;

import java.util.Arrays;

public class _03_LeftRotateByOne {

    /*
     * Problem:
     * Rotate the given array to the left by one position.
     *
     * Sample Input:
     * arr = [1, 2, 3, 4, 5]
     *
     * Sample Output:
     * [2, 3, 4, 5, 1]
     *
     * Constraints:
     * - In-place
     * - O(n) Time
     * - O(1) Space
     */

    public static void leftRotateByOne(int[] arr) {

        // Write your code here{
        int initial = arr[0];
        for (int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1]=initial;
    }

    private static void test(int[] arr, int[] expected) {

        leftRotateByOne(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Got     : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        test(new int[]{1,2,3,4,5}, new int[]{2,3,4,5,1});
        test(new int[]{10,20,30}, new int[]{20,30,10});
        test(new int[]{1}, new int[]{1});
        test(new int[]{5,5,5}, new int[]{5,5,5});
        test(new int[]{-1,-2,-3}, new int[]{-2,-3,-1});
    }
}