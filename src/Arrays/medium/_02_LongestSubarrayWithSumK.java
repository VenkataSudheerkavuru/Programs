package Arrays.medium;

public class _02_LongestSubarrayWithSumK {

    /*
     * Problem:
     * Given an array of positive integers and an integer K,
     * find the length of the longest subarray whose sum equals K.
     *
     * Sample Input:
     * arr = [1, 2, 3, 1, 1, 1, 1]
     * k = 6
     *
     * Sample Output:
     * 4
     *
     * Explanation:
     * Longest subarray with sum = 6 is [3,1,1,1]
     * Length = 4
     *
     * Constraints:
     * - Array contains only positive integers.
     * - Try to minimize time complexity.
     */

    public static int longestSubarray(int[] arr, int k) {

        // Write your code here
        int sum = 0;
        int res = 0;
        for(int i =0,j=0;i<arr.length;i++){
            sum = sum+arr[i];

            while(sum > k){
                sum = sum - arr[j];
                j++;
            }
            if(sum == k){
                res = Math.max(res,i-j+1);
            }
        }

        return res;
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

        test(new int[]{1,2,3,1,1,1,1}, 6, 4);

        test(new int[]{1,2,1,1,1}, 3, 3);

        test(new int[]{1,1,1,1}, 2, 2);

        test(new int[]{2,1,1,1,3}, 5, 4);

        test(new int[]{5,1,2,3}, 5, 2);

        test(new int[]{1,2,3}, 7, 0);

        test(new int[]{3,1,2,1,1,1}, 5, 4);
        test(new int[]{1,2,1,1,3}, 3, 2);
        test(new int[]{2, 5}, 5, 1);
    }
}