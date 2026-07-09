package Arrays.medium;

import java.util.HashMap;

public class _03_LongestSubarrayWithSumKPositivesAndNegatives {

    /*
     * Problem:
     * Given an array of integers (can contain positive, negative and zero)
     * and an integer K, find the length of the longest subarray whose sum equals K.
     *
     * Sample Input:
     * arr = [1, -1, 5, -2, 3]
     * k = 3
     *
     * Sample Output:
     * 4
     *
     * Explanation:
     * Longest subarray with sum = 3 is [1, -1, 5, -2]
     * Length = 4
     *
     * Constraints:
     * - Array may contain positive, negative and zero values.
     * - Expected Time Complexity: O(n)
     */

    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        // Prefix sum 0 occurs before the array starts
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If a previous prefix sum (sum-k) exists,
            // then the subarray between them sums to k.
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store only the first occurrence of a prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    private static void test(int[] arr, int k, int expected) {

        int actual = longestSubarray(arr, k);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{1, -1, 5, -2, 3}, 3, 4);

        test(new int[]{-2, -1, 2, 1}, 1, 2);

        test(new int[]{1, 2, 3}, 3, 2);

        test(new int[]{2, -1, 2, 3}, 4, 3);

        test(new int[]{0, 0, 0}, 0, 3);

        test(new int[]{-1, 1, -1, 1}, 0, 4);

        test(new int[]{3, -1, -2, 5, 1}, 3, 3);
    }
}