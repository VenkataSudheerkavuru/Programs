package Arrays.hard;

import java.util.Arrays;

public class _09_FindRepeatingAndMissingNumber {

    /*
     * Problem:
     * Given an array of size n containing numbers from 1 to n.
     * One number is missing and one number appears twice.
     *
     * Return:
     * [repeating, missing]
     *
     * Example:
     *
     * Input :
     * [3,1,2,5,3]
     *
     * Output:
     * [3,4]
     *
     * n(n+1)/2 = 14
     * (5*4)/2 = 10
     * 14 - 10 = 4 is missing
     */

    public static int[] findMissingRepeatingNumbers(int[] nums) {

        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate actual sum (S) and sum of squares (S2) of array elements
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN; // X - Y

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y
        val2 = val2 / val1;

        // Calculate X and Y
        long x = (val1 + val2) / 2; // repeating
        long y = x - val1;          // missing

        return new int[]{(int) x, (int) y};
    }

    private static void test(int[] nums, int[] expected) {

        int[] result = findMissingRepeatingNumbers(nums);

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Find Repeating And Missing Number =====");

        test(new int[]{3,1,2,5,3}, new int[]{3,4});

        test(new int[]{4,3,6,2,1,1}, new int[]{1,5});

        test(new int[]{1,2,2,4}, new int[]{2,3});
    }
}