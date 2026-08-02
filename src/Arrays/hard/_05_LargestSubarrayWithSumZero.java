package Arrays.hard;

import java.util.Arrays;
import java.util.HashMap;

public class _05_LargestSubarrayWithSumZero {

    /*
     * Problem:
     * Given an integer array nums,
     * return the length of the longest subarray
     * whose sum is equal to 0.
     *
     * Example:
     * Input : [15,-2,2,-8,1,7,10,23]
     * Output: 5
     *
     * Explanation:
     * [-2,2,-8,1,7] has sum = 0 and length = 5.
     */

    public static int maxLen(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        // Prefix sum 0 occurs before the array starts
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If a previous prefix sum (sum-k) exists,
            // then the subarray between them sums to k.
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }

            // Store only the first occurrence of a prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    private static void test(int[] nums, int expected) {

        int result = maxLen(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Largest Subarray With Sum 0 =====");

        test(new int[]{15,-2,2,-8,1,7,10,23}, 5);

        test(new int[]{1,-1,3,2,-2,-3}, 6);

        test(new int[]{1,2,3}, 0);

        test(new int[]{0,0,0}, 3);

        test(new int[]{1,-1}, 2);
    }
}