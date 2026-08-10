package BinarySerach.on_arrays_1d;

public class _02_LowerBound {

    /*
     * Problem:
     * Given a sorted array and a target,
     * return the index of the first element
     * greater than or equal to the target.
     *
     * If no such element exists, return nums.length.
     *
     * Example:
     *
     * Input :
     * nums = [1,2,4,4,5,6]
     * target = 4
     *
     * Output:
     * 2
     *
     * Input :
     * nums = [1,2,4,4,5,6]
     * target = 3
     *
     * Output:
     * 2
     */

    public static int lowerBound(int[] nums, int target) {

        // Write your code here
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    private static void test(int[] nums, int target, int expected) {

        int result = lowerBound(nums, target);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Lower Bound =====");

        test(new int[]{1,2,4,4,5,6}, 4, 2);

        test(new int[]{1,2,4,4,5,6}, 3, 2);

        test(new int[]{1,2,4,4,5,6}, 7, 6);

        test(new int[]{1,2,4,4,5,6}, 0, 0);

        test(new int[]{1,2,4,4,5,6}, 5, 4);
    }
}