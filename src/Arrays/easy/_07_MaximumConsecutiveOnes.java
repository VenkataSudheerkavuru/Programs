package Arrays.easy;

public class _07_MaximumConsecutiveOnes {

    /*
     * Problem:
     * Given a binary array, find the maximum number of consecutive 1's.
     *
     * Sample Input:
     * arr = [1, 1, 0, 1, 1, 1]
     *
     * Sample Output:
     * 3
     *
     * Constraints:
     * - Array contains only 0's and 1's.
     * - Time Complexity: O(n)
     * - Space Complexity: O(1)
     */

    public static int findMaxConsecutiveOnes(int[] arr) {

        // Write your code here
        int max = 0;
        int c = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                c++;
            }else{
                max = Math.max(max,c);
                c = 0;
            }
        }

        return Math.max(max,c);
    }

    private static void test(int[] arr, int expected) {

        int actual = findMaxConsecutiveOnes(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{1,1,0,1,1,1}, 3);

        test(new int[]{1,0,1,1,0,1}, 2);

        test(new int[]{0,0,0}, 0);

        test(new int[]{1,1,1,1}, 4);

        test(new int[]{1}, 1);

        test(new int[]{0}, 0);

        test(new int[]{1,0,1,1,1,0,1,1}, 3);
    }
}