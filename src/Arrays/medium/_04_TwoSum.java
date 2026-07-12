package Arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class _04_TwoSum {

    /*
     * Problem:
     * Given an array of integers and an integer target,
     * return the indices of the two numbers such that
     * they add up to the target.
     *
     * You may assume that exactly one solution exists,
     * and you may not use the same element twice.
     *
     * Sample Input:
     * arr = [2, 7, 11, 15]
     * target = 9
     *
     * Sample Output:
     * [0, 1]
     *
     * Constraints:
     * - Exactly one valid answer exists.
     * - Return indices, not the values.
     * - Try to minimize time complexity.
     */

    public static int[] twoSum(int[] arr, int target) {

        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int x = target - arr[i];
            if(map.containsKey(x)){
                return new int[]{map.get(x),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1, -1};
    }

    private static void test(int[] arr, int target, int[] expected) {

        int[] actual = twoSum(arr, target);

        if (Arrays.equals(actual, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(actual));
        }
    }

    public static void main(String[] args) {

        test(new int[]{2,7,11,15}, 9, new int[]{0,1});

        test(new int[]{3,2,4}, 6, new int[]{1,2});

        test(new int[]{3,3}, 6, new int[]{0,1});

        test(new int[]{10,20,30,40}, 50, new int[]{1,2});

        test(new int[]{5,1,9,6}, 15, new int[]{2,3});

        test(new int[]{8,-3,4,11}, 9, new int[]{-1,-1});
    }
}