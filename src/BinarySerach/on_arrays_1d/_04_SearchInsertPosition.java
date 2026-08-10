package BinarySerach.on_arrays_1d;

public class _04_SearchInsertPosition {

    /*
     * Problem:
     * Given a sorted array and a target,
     * return its index if found.
     *
     * If not found,
     * return the index where it should be inserted
     * to maintain sorted order.
     *
     * Example:
     *
     * Input :
     * nums = [1,3,5,6]
     * target = 5
     *
     * Output:
     * 2
     *
     * Input :
     * nums = [1,3,5,6]
     * target = 2
     *
     * Output:
     * 1
     */

    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                ans =  mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static void test(int[] nums, int target, int expected) {

        int result = searchInsert(nums, target);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Search Insert Position =====");

        test(new int[]{1,3,5,6}, 5, 2);

        test(new int[]{1,3,5,6}, 2, 1);

        test(new int[]{1,3,5,6}, 7, 4);

        test(new int[]{1,3,5,6}, 0, 0);

        test(new int[]{1}, 0, 0);
    }
}