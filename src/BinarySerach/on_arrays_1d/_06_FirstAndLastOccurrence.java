package BinarySerach.on_arrays_1d;

import java.util.Arrays;

public class _06_FirstAndLastOccurrence {

    /*
     * Problem:
     * Given a sorted array and a target,
     * return the first and last occurrence
     * of the target.
     *
     * If the target is not found,
     * return {-1,-1}.
     *
     * Example:
     *
     * nums = [2,4,6,8,8,8,11,13]
     * target = 8
     *
     * Output:
     * [3,5]
     */

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

    private static void test(int[] nums, int target, int[] expected) {

        int[] result = searchRange(nums, target);

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {

        System.out.println("===== First And Last Occurrence =====");

        test(new int[]{2,4,6,8,8,8,11,13}, 8, new int[]{3,5});

        test(new int[]{1,2,3,4}, 2, new int[]{1,1});

        test(new int[]{1,2,3,4}, 5, new int[]{-1,-1});

        test(new int[]{5,5,5,5}, 5, new int[]{0,3});

        test(new int[]{1,2,3,4}, 0, new int[]{-1,-1});

        test(new int[]{1,2,3,4}, 5, new int[]{-1,-1});

        test(new int[]{1,1,2,2,3,3}, 2, new int[]{2,3});
    }
}