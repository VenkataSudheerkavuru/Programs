package Arrays.hard;

import java.util.Arrays;

public class _10_CountInversions {

    /*
     * Problem:
     * Given an array of integers,
     * count the number of inversions.
     *
     * An inversion is a pair (i,j) such that:
     *
     *      i < j
     *      arr[i] > arr[j]
     *
     * Example:
     *
     * Input :
     * [5,3,2,4,1]
     *
     * Output:
     * 8
     */

    public static int inversionCount(int[] nums) {

        // Read Only Problem

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = (low + high) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);

        return count;
    }

    private static int merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        int count = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                count += (mid - left + 1);
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid)
            temp[k++] = nums[left++];

        while (right <= high)
            temp[k++] = nums[right++];

        for (int i = low; i <= high; i++)
            nums[i] = temp[i - low];

        return count;
    }

    private static void test(int[] nums, int expected) {

        int result = inversionCount(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Count Inversions =====");

        test(new int[]{5,3,2,4,1}, 8);

        test(new int[]{2,4,1,3,5}, 3);

        test(new int[]{1,2,3,4}, 0);

        test(new int[]{4,3,2,1}, 6);
    }
}