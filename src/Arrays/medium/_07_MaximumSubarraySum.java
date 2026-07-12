package Arrays.medium;

import java.util.Arrays;

public class _07_MaximumSubarraySum {

    /*
     * Problem:
     * Given an integer array nums,
     * find the contiguous subarray which has the largest sum,
     * and return its sum.
     *
     * Sample Input:
     * arr = [-2,1,-3,4,-1,2,1,-5,4]
     *
     * Sample Output:
     * 6
     *
     * Explanation:
     * The subarray [4,-1,2,1] has the largest sum = 6.
     *
     * Constraints:
     * - Array contains both positive and negative integers.
     * - At least one element exists.
     * A negative running sum can never help increase the sum of any future subarray. Therefore,
     *  once the running sum becomes negative,
     *  it's always better to discard it and start a new subarray from the next element.
     */

    public static int maxSubArray(int[] arr) {

        // Write your code here
        int count = 0;
        int max = arr[0];
        for(int i =0;i<arr.length;i++){
            count = count + arr[i];

            if (count > max) {
                max = count ;
            }
            if(count <= 0){
                count = 0;
            }
        }

        return max;
    }

    private static void test(int[] arr, int expected) {

        int actual = maxSubArray(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);

        test(new int[]{1}, 1);

        test(new int[]{5,4,-1,7,8}, 23);

        test(new int[]{-1,-2,-3,-4}, -1);

        test(new int[]{2,-1,2,3,4,-5}, 10);

        test(new int[]{-2,-1}, -1);

        test(new int[]{1,-2,3,10,-4,7,2,-5}, 18);
    }
}