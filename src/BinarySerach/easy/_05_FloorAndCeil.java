package BinarySerach.easy;

import java.util.Arrays;

public class _05_FloorAndCeil {

    /*
     * Problem:
     * Given a sorted array and a target,
     * return the Floor and Ceil.
     *
     * Floor = Largest element <= target
     * Ceil  = Smallest element >= target
     *
     * If Floor doesn't exist, return -1.
     * If Ceil doesn't exist, return -1.
     *
     * Example:
     *
     * nums = [1,2,4,6,8]
     * target = 5
     *
     * Floor = 4
     * Ceil  = 6
     */

    public static int[] floorAndCeil(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length - 1;
        int floor = -1;
        int ceil = -1;

        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] <= target){
                floor = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        low = 0;
        high = nums.length-1;

        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] >= target){
                ceil = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[]{(floor == -1? -1:nums[floor]),(ceil ==-1 ? -1 : nums[ceil])};
    }

    private static void test(int[] nums, int target, int[] expected) {

        int[] result = floorAndCeil(nums, target);

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Floor And Ceil =====");

        test(new int[]{1,2,4,6,8}, 5, new int[]{4,6});

        test(new int[]{1,2,4,6,8}, 4, new int[]{4,4});

        test(new int[]{1,2,4,6,8}, 0, new int[]{-1,1});

        test(new int[]{1,2,4,6,8}, 10, new int[]{8,-1});
    }
}