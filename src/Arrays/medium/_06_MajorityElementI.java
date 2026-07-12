package Arrays.medium;

import java.util.Arrays;

public class _06_MajorityElementI {

    /*
     * Problem:
     * Given an array of size n,
     * find the element that appears more than n/2 times.
     *
     * You may assume that the majority element always exists.
     *
     * Sample Input:
     * arr = [3,2,3]
     *
     * Sample Output:
     * 3
     *
     * Constraints:
     * - Majority element is guaranteed to exist.
     * - Try to minimize time complexity and extra space.
     */

    //Boyer-Moore works because every occurrence of a non-majority element can cancel at most one occurrence
    // of the majority element. Since the majority appears more than half the time,
    // it cannot be completely cancelled and must be the final candidate.

    public static int majorityElement(int[] arr) {

        // Write your code here
        int count=0;
        int ele = -1;
        for(int i=0;i<arr.length;i++){
            if(count == 0){
                ele = arr[i];
            }
            if(arr[i] == ele){
                count++;
            }else{
                count--;
            }
        }


        return ele;
    }

    private static void test(int[] arr, int expected) {

        int actual = majorityElement(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{3,2,3}, 3);

        test(new int[]{2,2,1,1,1,2,2}, 2);

        test(new int[]{1}, 1);

        test(new int[]{5,5,5,2,2}, 5);

        test(new int[]{7,7,3,7,4,7,7}, 7);

        test(new int[]{9,9,9,1,2}, 9);
    }
}