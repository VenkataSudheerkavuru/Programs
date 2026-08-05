package BinarySerach.easy;

import java.util.Arrays;

public class _11_RotationCount {

    /*
     * Problem:
     * Given a sorted array that has been rotated
     * some number of times,
     * return the number of rotations.
     *
     * Example:
     *
     * nums = [4,5,6,7,0,1,2]
     *
     * Output:
     * 4
     *
     * Explanation:
     * The minimum element (0) is at index 4,
     * so the array has been rotated 4 times.
     */

    public static int rotationCount(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[mid]) {

                if (nums[low] < nums[ans]) ans = low;

                low = mid + 1;

            } else {

                if (nums[mid] < nums[ans]) ans = mid;

                high = mid - 1;
            }
        }

        return ans;
    }

    private static void test(int[] nums, int expected) {

        int result = rotationCount(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Rotation Count =====");

        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);

        test(new int[]{3, 4, 5, 1, 2}, 3);

        test(new int[]{1, 2, 3, 4, 5}, 0);

        test(new int[]{2, 1}, 1);

        test(new int[]{1}, 0);
    }
}