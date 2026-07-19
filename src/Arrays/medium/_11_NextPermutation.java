package Arrays.medium;

import java.util.Arrays;

public class _11_NextPermutation {

    /*
     * Problem:
     * Implement the next permutation of numbers.
     *
     * If the array is already the largest permutation,
     * rearrange it into the smallest permutation.
     *
     * The replacement must be in-place.
     *
     * Sample Input:
     * arr = [1,2,3]
     *
     * Sample Output:
     * [1,3,2]
     *
     * Explanation:
     * Next lexicographically greater permutation.
     *
     * You already discovered the intuition:

    We want to make the number slightly bigger, so we change the rightmost position where we still can.
    We swap with the smallest larger value, so we increase it by the minimum possible amount.
    The suffix is currently in descending order (largest arrangement),
    * so after the swap we reverse it to make it the smallest possible arrangement.
     */

    public static void nextPermutation(int[] arr) {

        int n = arr.length;

        // Step 1: Find the breakpoint
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse entire array
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 3: Find the first element greater than arr[index] from the right
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }

        // Step 4: Reverse the suffix
        reverse(arr, index + 1, n - 1);
    }

    private static void reverse(int[] arr, int left, int right) {

        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void test(int[] arr, int[] expected) {

        nextPermutation(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        test(new int[]{1,2,3},
                new int[]{1,3,2});

        test(new int[]{3,2,1},
                new int[]{1,2,3});

        test(new int[]{1,1,5},
                new int[]{1,5,1});

        test(new int[]{1,3,2},
                new int[]{2,1,3});

        test(new int[]{2,1,3},
                new int[]{2,3,1});

        test(new int[]{1,5,1},
                new int[]{5,1,1});
    }
}