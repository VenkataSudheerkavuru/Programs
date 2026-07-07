package Arrays.easy;

import java.util.Arrays;

public class LeftRotateByK {

    /*
     * Problem:
     * Rotate the given array to the left by K positions.
     *
     * Sample Input:
     * arr = [1, 2, 3, 4, 5, 6, 7]
     * k = 2
     *
     * Sample Output:
     * [3, 4, 5, 6, 7, 1, 2]
     *
     * Constraints:
     * - Rotate in-place if possible.
     * - Handle cases where k > arr.length.
     *
     * Expected:
     * First solve using extra array.
     * Then we'll optimize it.
     */

   /* public static void leftRotateByK(int[] arr, int k) {

        // Write your code here
        int[] arr1 = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            arr1[i] = arr[(i+k)%arr.length];
        }
        for(int i =0;i<arr.length;i++){
            arr[i]= arr1[i];
        }

    }*/

    /**
     * divide the array into two parts: A (first k elements) and B (remaining elements).
     * Our goal is to transform AB into BA. After reversing each part individually, we have ArBr.
     * Reversing the whole array uses the property reverse(XY) = reverse(Y) + reverse(X),
     * so reverse(ArBr) = reverse(Br) + reverse(Ar) = BA, which is exactly the left-rotated array.
     **/

    public static void leftRotateByK(int[] arr, int k) {

        if (arr == null || arr.length <= 1) return;

        k = k % arr.length;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int left, int right) {

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    private static void test(int[] arr, int k, int[] expected) {

        leftRotateByK(arr, k);

        if (Arrays.equals(arr, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("k        : " + k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{3, 4, 5, 6, 7, 1, 2});

        test(new int[]{1, 2, 3, 4, 5}, 3, new int[]{4, 5, 1, 2, 3});

        test(new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5});

        test(new int[]{1, 2, 3, 4, 5}, 7, new int[]{3, 4, 5, 1, 2});

        test(new int[]{10}, 100, new int[]{10});
    }
}