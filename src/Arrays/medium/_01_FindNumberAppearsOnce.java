package Arrays.medium;

public class _01_FindNumberAppearsOnce {

    /*
     * Problem:
     * Given a non-empty array of integers, every element appears exactly twice
     * except for one element, which appears only once.
     *
     * Find that single element.
     *
     * Sample Input:
     * arr = [2, 2, 1]
     *
     * Sample Output:
     * 1
     *
     * Constraints:
     * - Exactly one element appears once.
     * - All other elements appear exactly twice.
     *
     * Expected:
     * Try to minimize both time and space complexity.
     */

    public static int singleNumber(int[] arr) {

        // Write your code here
        int x = 0;
        for(int ar : arr){
            x = x^ar;
        }

        return x;
    }

    private static void test(int[] arr, int expected) {

        int actual = singleNumber(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{2, 2, 1}, 1);

        test(new int[]{4, 1, 2, 1, 2}, 4);

        test(new int[]{1}, 1);

        test(new int[]{7, 3, 5, 3, 5}, 7);

        test(new int[]{10, 20, 20, 30, 30}, 10);

        test(new int[]{99, 15, 15}, 99);
    }
}