package Arrays.medium;

import java.util.Arrays;

public class _05_SortArrayOf0s1s2s {

    /*
     * Problem:
     * Given an array consisting only of 0's, 1's and 2's,
     * sort the array in ascending order.
     *
     * Sample Input:
     * arr = [2,0,2,1,1,0]
     *
     * Sample Output:
     * [0,0,1,1,2,2]
     *
     * Constraints:
     * - Do not use any built-in sorting algorithm.
     * - Try to minimize time complexity.
     * - Try to minimize extra space.
     */

    public static void sortArray(int[] arr) {

        // Write your code here
        int i =0;
        int j =arr.length-1;
        int k = 0;
        int prev;
        while (k <= j){
            prev= arr[k];
            if(arr[k] == 0){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
            }else if(arr[k] == 2){
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
            }
            if(prev == arr[k]){
                k++;
            }
        }
    }

    private static void test(int[] arr, int[] expected) {

        sortArray(arr);

        if (Arrays.equals(arr, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        test(new int[]{2,0,2,1,1,0},
                new int[]{0,0,1,1,2,2});

        test(new int[]{0,1,2},
                new int[]{0,1,2});

        test(new int[]{2,2,2},
                new int[]{2,2,2});

        test(new int[]{1,1,1},
                new int[]{1,1,1});

        test(new int[]{0,0,0},
                new int[]{0,0,0});

        test(new int[]{2,1,0},
                new int[]{0,1,2});

        test(new int[]{1,2,0,1,2,0},
                new int[]{0,0,1,1,2,2});
    }
}