package Arrays.easy;

import java.util.HashSet;

public class _06_FindMissingNumber {

    /*
     * Problem:
     * Given an array containing n-1 distinct numbers in the range [1, n],
     * find the missing number.
     *
     * Sample Input:
     * arr = [1, 2, 4, 5]
     * n = 5
     *
     * Sample Output:
     * 3
     *
     * Approaches:
     * 1. Brute Force  - O(n²)
     * 2. Hashing      - O(n), O(n)
     * 3. XOR          - O(n), O(1)
     */

    // Brute Force
    public static int bruteForce(int[] arr, int n) {

        for (int i = 1; i <= n; i++) {

            boolean found = false;

            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }

            if (!found)
                return i;
        }

        return -1;
    }

    // Better - HashSet
    public static int hashing(int[] arr, int n) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1;
    }

    // Optimal - XOR
    public static int xorApproach(int[] arr, int n) {

        int xor1 = 0;
        int xor2 = 0;

        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        for (int num : arr) {
            xor2 ^= num;
        }

        return xor1 ^ xor2;
    }

    private static void test(int[] arr, int n, int expected) {

        int actual = xorApproach(arr, n);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{1, 2, 4, 5}, 5, 3);

        test(new int[]{2, 3, 1, 5}, 5, 4);

        test(new int[]{1}, 2, 2);

        test(new int[]{2}, 2, 1);

        test(new int[]{1, 2, 3, 4, 5, 7}, 7, 6);

        test(new int[]{3, 2, 1, 5, 6}, 6, 4);
    }
}