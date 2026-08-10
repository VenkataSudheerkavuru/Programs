package BinarySerach.on_arrays_1d;

public class _01_BinarySearch {

    /*
     * Problem:
     * Given a sorted array of integers and a target,
     * return the index of the target.
     *
     * If the target is not present, return -1.
     *
     * Example:
     *
     * Input :
     * nums = [1,3,5,7,9]
     * target = 5
     *
     * Output:
     * 2
     */

    public static int search(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }

    private static void test(int[] nums, int target, int expected) {

        int result = search(nums, target);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Binary Search =====");

        test(new int[]{1,3,5,7,9}, 5, 2);

        test(new int[]{1,3,5,7,9}, 1, 0);

        test(new int[]{1,3,5,7,9}, 9, 4);

        test(new int[]{1,3,5,7,9}, 6, -1);

        test(new int[]{5}, 5, 0);

        test(new int[]{5}, 1, -1);
    }
}
