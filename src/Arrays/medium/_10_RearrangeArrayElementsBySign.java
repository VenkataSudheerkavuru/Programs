package Arrays.medium;

public class _10_RearrangeArrayElementsBySign {

    /*
     * Problem:
     * Given an array of equal number of positive and negative integers,
     * rearrange the array such that positive and negative numbers
     * alternate.
     *
     * The relative order of positive and negative numbers should be preserved.
     *
     * Sample Input:
     * arr = [3,1,-2,-5,2,-4]
     *
     * Sample Output:
     * [3,-2,1,-5,2,-4]
     *
     * Constraints:
     * - Number of positive and negative elements are equal.
     * - First element should be positive.
     */

    public static int[] rearrangeArray(int[] arr) {

        // Write your code here 3,1,-2,-5,2,-4
        int k = 0;
        int j= 1;
        int []res = new int[arr.length];
        for(int i =0;i< arr.length;i++){
            if(arr[i]>=0){
                res[k] = arr[i];
                k = k+2;
            }else{
                res[j] = arr[i];
                j = j+2;
            }
        }

        return res;
    }

    private static void test(int[] arr, int[] expected) {

        int[] actual = rearrangeArray(arr);

        if (java.util.Arrays.equals(actual, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + java.util.Arrays.toString(expected));
            System.out.println("Got      : " + java.util.Arrays.toString(actual));
        }
    }

    public static void main(String[] args) {

        test(new int[]{3,1,-2,-5,2,-4},
                new int[]{3,-2,1,-5,2,-4});

        test(new int[]{1,-1},
                new int[]{1,-1});

        test(new int[]{1,2,-1,-2},
                new int[]{1,-1,2,-2});

        test(new int[]{5,-7,8,-2},
                new int[]{5,-7,8,-2});

        test(new int[]{10,20,-30,-40},
                new int[]{10,-30,20,-40});
    }
}