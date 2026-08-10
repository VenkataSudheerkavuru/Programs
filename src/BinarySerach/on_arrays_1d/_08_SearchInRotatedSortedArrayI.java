package BinarySerach.on_arrays_1d;

public class _08_SearchInRotatedSortedArrayI {

    /*
     * Problem:
     * There is an integer array nums sorted in ascending order.
     *
     * It is rotated at some pivot.
     *
     * Search the target.
     *
     * Return its index if found,
     * otherwise return -1.
     *
     * Example:
     *
     * nums = [4,5,6,7,0,1,2]
     * target = 0
     *
     * Output:
     * 4
     */

    public static int search(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length-1;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)return mid;
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

        System.out.println("===== Search In Rotated Sorted Array I =====");

        test(new int[]{4,5,6,7,0,1,2}, 0, 4);

        test(new int[]{4,5,6,7,0,1,2}, 3, -1);

        test(new int[]{1}, 0, -1);

        test(new int[]{1}, 1, 0);

        test(new int[]{3,1}, 1, 1);
    }
}