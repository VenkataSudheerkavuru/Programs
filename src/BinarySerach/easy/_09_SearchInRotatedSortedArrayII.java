package BinarySerach.easy;

import java.util.Arrays;

public class _09_SearchInRotatedSortedArrayII {

    /*
     * Problem:
     * There is an integer array nums sorted in ascending order,
     * possibly containing duplicates.
     *
     * It is rotated at some pivot.
     *
     * Return true if target exists,
     * otherwise false.
     *
     * Example:
     *
     * nums = [2,5,6,0,0,1,2]
     * target = 0
     *
     * Output:
     * true
     */

    public static boolean search(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length-1;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)return true;
            if(nums[mid] == nums[low] && nums[mid]== nums[high]){
                high--;
                low++;
                continue;
            }
            if(nums[low] <= nums[mid]){
                //left is sorted
                if(nums[low] <= target && nums[mid] > target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            } else{
                // right is sorted
                if(nums[high] >= target && nums[mid] < target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return false;
    }

    private static void test(int[] nums, int target, boolean expected) {

        boolean result = search(nums, target);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Search In Rotated Sorted Array II =====");

        test(new int[]{2,5,6,0,0,1,2}, 0, true);

        test(new int[]{2,5,6,0,0,1,2}, 3, false);

        test(new int[]{1,0,1,1,1}, 0, true);

        test(new int[]{1,1,1,1,1}, 2, false);

        test(new int[]{1,3,1,1,1}, 3, true);
    }
}