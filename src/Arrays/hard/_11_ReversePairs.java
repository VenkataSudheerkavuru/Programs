package Arrays.hard;

import java.util.Arrays;

public class _11_ReversePairs {

    /*
     * Problem:
     * Given an integer array nums,
     * return the number of reverse pairs.
     *
     * A reverse pair is:
     *
     *      i < j
     *      nums[i] > 2 * nums[j]
     *
     * Example:
     *
     * Input :
     * [1,3,2,3,1]
     *
     * Output:
     * 2
     */

    public static int reversePairs(int[] nums) {

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
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid)
            temp[k++] = nums[left++];

        while (right <= high)
            temp[k++] = nums[right++];

        for (int i = low; i <= high; i++)
            nums[i] = temp[i - low];
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;

        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                    nums[left] > (long)2 * nums[right]) {

                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private static void test(int[] nums, int expected) {

        int result = reversePairs(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Reverse Pairs =====");

        test(new int[]{1,3,2,3,1}, 2);

        test(new int[]{2,4,3,5,1}, 3);

        test(new int[]{1,2,3,4}, 0);

        test(new int[]{5,4,3,2,1}, 4);
    }
}