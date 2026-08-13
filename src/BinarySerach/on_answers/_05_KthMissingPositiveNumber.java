package BinarySerach.on_answers;

public class _05_KthMissingPositiveNumber {

    /*
     * Problem:
     *
     * You are given a sorted array of positive integers.
     *
     * Some positive numbers are missing from the array.
     *
     * Find the k-th positive integer that is missing.
     *
     * Example:
     *
     * arr = [2,3,4,7,11]
     * k = 5
     *
     * Positive numbers:
     * 1,2,3,4,5,6,7,8,9,10,11...
     *
     * Missing numbers:
     * 1,5,6,8,9,10...
     *
     * The 5th missing number is 9.
     *
     * Output = 9
     *
     * Another example:
     *
     * arr = [1,2,3,4]
     * k = 2
     *
     * Missing numbers:
     * 5,6,7...
     *
     * Output = 6
     *
     * The array is sorted and contains positive integers.
     */

    public static int findKthPositive(int[] arr, int k) {

        // Write your code here

        return -1;
    }

    private static void test(int[] arr, int k, int expected) {

        int result = findKthPositive(arr, k);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Kth Missing Positive Number =====");

        test(new int[]{2,3,4,7,11}, 5, 9);

        test(new int[]{1,2,3,4}, 2, 6);

        test(new int[]{2}, 1, 1);

        test(new int[]{2}, 2, 3);

        test(new int[]{5,6,7,8}, 3, 3);
    }
}