package Arrays.hard;

import java.util.Arrays;

public class _12_MaximumProductSubarray {

    /*
     * Problem:
     * Given an integer array nums,
     * find the contiguous subarray
     * which has the largest product.
     *
     * Example:
     *
     * Input :
     * [2,3,-2,4]
     *
     * Output:
     * 6
     *
     * Input :
     * [-2,0,-1]
     *
     * Output:
     * 0
     *
     * /*
     * Brute Force:
     * --------------------
     * Generate all subarrays.
     * Compute the product of each subarray.
     * Return the maximum product.
     *
     * Time  : O(n²)
     * Space : O(1)
     *
     *
     * Optimal (Prefix & Suffix):
     * --------------------------
     * A zero breaks the product, so restart the product after a zero.
     *
     * A negative product can become positive if another
     * negative number appears later.
     *
     * Therefore:
     * 1. Traverse from left -> right (prefix product).
     * 2. Traverse from right -> left (suffix product).
     * 3. Reset product to 1 whenever it becomes 0.
     * 4. At every step, take the maximum of:
     *      prefix product,
     *      suffix product.
     *
     * One of the traversals will naturally ignore the
     * extra negative element if the total number of
     * negatives is odd.
     *
     * Time  : O(n)
     * Space : O(1)
     */

    public static int maxProduct(int[] arr) {

        // Get the length of the array
        int n = arr.length;

        // Initialize prefix and suffix product
        int pre = 1, suff = 1;

        // Initialize answer with smallest integer
        int ans = Integer.MIN_VALUE;

        // Traverse from both left and right
        for (int i = 0; i < n; i++) {
            // Reset prefix if zero
            if (pre == 0) pre = 1;

            // Reset suffix if zero
            if (suff == 0) suff = 1;

            // Multiply prefix with current element from front
            pre *= arr[i];

            // Multiply suffix with current element from back
            suff *= arr[n - i - 1];

            // Update maximum value so far
            ans = Math.max(ans, Math.max(pre, suff));
        }

        // Return the final result
        return ans;
    }

    private static void test(int[] nums, int expected) {

        int result = maxProduct(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Maximum Product Subarray =====");

        test(new int[]{2,3,-2,4}, 6);

        test(new int[]{-2,0,-1}, 0);

        test(new int[]{-2,3,-4}, 24);

        test(new int[]{-1,-2,-3}, 6);
    }
}