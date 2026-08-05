package BinarySerach.easy;

import java.util.Arrays;

public class _10_FindMinimumInRotatedSortedArray {

    /*
     * Problem:
     * Given a rotated sorted array
     * with unique elements,
     * return the minimum element.
     *
     * Example:
     *
     * nums = [4,5,6,7,0,1,2]
     *
     * Output:
     * 0
     */

    public static int findMin(int[] nums) {

        // Write your code here
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[mid]){
                //left is sorted
                ans = Math.min(ans,nums[low]);
                low =mid +1;
            } else{
                // right is sorted
                ans =Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }

        return ans;
    }

    private static void test(int[] nums, int expected) {

        int result = findMin(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Find Minimum =====");

        test(new int[]{4,5,6,7,0,1,2}, 0);

        test(new int[]{3,4,5,1,2}, 1);

        test(new int[]{11,13,15,17}, 11);

        test(new int[]{2,1}, 1);

        test(new int[]{1}, 1);
    }
}