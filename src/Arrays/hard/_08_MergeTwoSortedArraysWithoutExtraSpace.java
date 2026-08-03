package Arrays.hard;

import java.util.Arrays;

public class _08_MergeTwoSortedArraysWithoutExtraSpace {

    /*
     * Problem:
     * You are given two sorted arrays.
     *
     * nums1 has size m + n where the last n positions are empty.
     * nums2 has size n.
     *
     * Merge nums2 into nums1 so that nums1 becomes sorted.
     *
     * Example:
     * nums1 = [-5,-2,4,5,0,0,0]
     * m = 4
     * nums2 = [-3,1,8]
     * n = 3
     *
     * Output:
     * [-5,-3,-2,1,4,5,8]
     * /*
     * Brute Force:
     * 1. Copy all elements of nums2 into the empty positions of nums1.
     * 2. Sort nums1.
     *
     * Time  : O((m+n) log(m+n))
     * Space : O(1)
     *
     *
     * Optimal (Three Pointers):
     * 1. Since nums1 has empty spaces at the end,
     *    start filling from the last index.
     * 2. Maintain three pointers:
     *      i = last valid element of nums1 (m-1)
     *      j = last element of nums2 (n-1)
     *      k = last index of nums1 (m+n-1)
     * 3. Compare nums1[i] and nums2[j].
     *      - If nums1[i] is larger, place it at nums1[k].
     *      - Otherwise, place nums2[j] at nums1[k].
     * 4. Move the corresponding pointer and decrement k.
     * 5. Continue until one array is exhausted.
     * 6. If nums2 still has elements left,
     *    copy them into nums1.
     * 7. No need to copy remaining elements of nums1,
     *    as they are already in the correct position.
     *
     * Time  : O(m+n)
     * Space : O(1)
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements of nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    private static void test(int[] nums1, int m,
                             int[] nums2, int n,
                             int[] expected) {

        merge(nums1, m, nums2, n);

        if (Arrays.equals(nums1, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(nums1));
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Merge Sorted Array =====");

        test(
                new int[]{-5,-2,4,5,0,0,0},
                4,
                new int[]{-3,1,8},
                3,
                new int[]{-5,-3,-2,1,4,5,8}
        );

        test(
                new int[]{1,2,3,0,0,0},
                3,
                new int[]{2,5,6},
                3,
                new int[]{1,2,2,3,5,6}
        );
    }
}