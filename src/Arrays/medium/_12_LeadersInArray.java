package Arrays.medium;

import java.util.*;

public class _12_LeadersInArray {

    /*
     * Problem:
     * Given an array, return all the leaders.
     *
     * A leader is an element that is greater than all the elements
     * to its right.
     *
     * The rightmost element is always a leader.
     *
     * Return the leaders in the same order as they appear in the array.
     *
     * Example:
     *
     * Input:
     * [10,22,12,3,0,6]
     *
     * Output:
     * [22,12,6]
     */

    public static List<Integer> leaders(int[] arr) {

        // Write your code here
        List<Integer> res = new ArrayList<>();
        int max = arr[arr.length-1];
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                max = arr[i];
                res.add(arr[i]);
            }
        }

        return res.reversed();
    }

    private static void test(int[] arr, List<Integer> expected) {

        List<Integer> actual = leaders(arr);

        if (actual.equals(expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{10,22,12,3,0,6},
                Arrays.asList(22,12,6));

        test(new int[]{4,7,1,0},
                Arrays.asList(7,1,0));

        test(new int[]{1,2,3},
                Arrays.asList(3));

        test(new int[]{3,2,1},
                Arrays.asList(3,2,1));

        test(new int[]{5},
                Arrays.asList(5));
    }
}