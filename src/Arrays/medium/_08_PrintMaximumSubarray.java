package Arrays.medium;

import java.util.Arrays;

public class _08_PrintMaximumSubarray {

    /*
     * Problem:
     * Given an integer array,
     * print the subarray having the maximum sum.
     *
     * If multiple subarrays have the same maximum sum,
     * returning any one of them is acceptable.
     *
     * Sample Input:
     * arr = [-2,1,-3,4,-1,2,1,-5,4]
     *
     * Sample Output:
     * [4, -1, 2, 1]
     *
     * Maximum Sum = 6
     */

    public static int[] maximumSubarray(int[] arr) {

        // Write your code here
        int[] res = new int[2];
        int x =0;
        int count = 0;
        int max = arr[0];
        for(int i = 0;i<arr.length;i++){
            count += arr[i];

            if(count > max){
                res[0]=x;
                res[1]=i;
                max = count;
            }

            if(count < 0){
                x = i+1;
                count = 0;
            }
        }
        int[] a = new int[res[1] - res[0] + 1];
        for(int j=0,i =res[0];i<=res[1];i++){
            a[j++] = arr[i];
        }


        return a;
    }

    private static void test(int[] arr, int[] expected) {

        int[] actual = maximumSubarray(arr);

        if (Arrays.equals(actual, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Got      : " + Arrays.toString(actual));
        }
    }

    public static void main(String[] args) {

        test(new int[]{-2,1,-3,4,-1,2,1,-5,4},
                new int[]{4,-1,2,1});

        test(new int[]{1},
                new int[]{1});

        test(new int[]{5,4,-1,7,8},
                new int[]{5,4,-1,7,8});

        test(new int[]{-1,-2,-3,-4},
                new int[]{-1});

        test(new int[]{2,-1,2,3,4,-5},
                new int[]{2,-1,2,3,4});

        test(new int[]{1,-2,3,10,-4,7,2,-5},
                new int[]{3,10,-4,7,2});
    }
}