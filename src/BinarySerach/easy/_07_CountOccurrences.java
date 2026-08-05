package BinarySerach.easy;

import java.util.Arrays;

public class _07_CountOccurrences {

    /*
     * Problem:
     * Given a sorted array and a target,
     * return the number of occurrences
     * of the target.
     *
     * If the target is not present,
     * return 0.
     *
     * Example:
     *
     * nums = [2,4,6,8,8,8,11,13]
     * target = 8
     *
     * Output:
     * 3
     */

    public static int countOccurrences(int[] nums, int target) {

        // Write your code here
        int[] arr = searchRange(nums,target);
        return arr[1] == -1  ? 0 : arr[1] - arr[0]+1;
    }

    public static int[] searchRange(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length-1;
        int first = -1;
        int last = -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target)
                    first = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        low = 0;
        high = nums.length-1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target)
                    last = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return new int[]{first,last};
    }

    private static void test(int[] nums, int target, int expected) {

        int result = countOccurrences(nums, target);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Count Occurrences =====");

        test(new int[]{1,2,3,4}, 1, 1);

        test(new int[]{2,4,6,8,8,8,11,13}, 8, 3);

        test(new int[]{1,2,3,4}, 2, 1);

        test(new int[]{1,2,3,4}, 5, 0);

        test(new int[]{5,5,5,5}, 5, 4);

        test(new int[]{1,1,2,2,2,3}, 2, 3);

        test(new int[]{5,5,5},5,3);
    }
}