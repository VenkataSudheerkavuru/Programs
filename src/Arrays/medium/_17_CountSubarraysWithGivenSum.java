package Arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class _17_CountSubarraysWithGivenSum {

    /*
     * Problem:
     * Given an integer array nums and an integer k,
     * return the total number of subarrays whose sum equals k.
     *
     * Example 1:
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     *
     * Example 2:
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     */

    public static int subarraySum(int[] nums, int k) {

        // Write your code here
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        for (int num : nums) {
            sum += num;
            int target = sum - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    private static void test(int[] nums, int k, int expected) {

        int result = subarraySum(nums, k);

        System.out.println(result == expected ? "PASS" : "FAIL");
        System.out.println("Result  : " + result);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    public static void main(String[] args) {

        test(new int[]{1,1,1}, 2, 2);

        test(new int[]{1,2,3}, 3, 2);

        test(new int[]{3,4,7,2,-3,1,4,2}, 7, 4);
    }
}