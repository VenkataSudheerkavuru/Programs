  package Arrays.hard;

import java.util.Arrays;
import java.util.List;

public class _04_FourSum {

    /*
     * Problem:
     * Given an integer array nums and an integer target,
     * return all unique quadruplets
     * [nums[a], nums[b], nums[c], nums[d]]
     * such that:
     *
     *      a != b
     *      a != c
     *      a != d
     *      b != c
     *      b != d
     *      c != d
     *
     * and
     *
     *      nums[a] + nums[b] + nums[c] + nums[d] == target
     *
     * The solution set must not contain duplicate quadruplets.
     *
     * Example:
     *
     * Input :
     * nums = [1,0,-1,0,-2,2]
     * target = 0
     *
     * Output :
     * [
     *   [-2,-1,1,2],
     *   [-2,0,0,2],
     *   [-1,0,0,1]
     * ]
     */

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        // Write your code here
        //same as 3 sum array just need fix i,j

        return null;
    }

    private static void test(int[] nums, int target,
                             List<List<Integer>> expected) {

        List<List<Integer>> result = fourSum(nums, target);

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== 4 Sum =====");

        test(
                new int[]{1,0,-1,0,-2,2},
                0,
                Arrays.asList(
                        Arrays.asList(-2,-1,1,2),
                        Arrays.asList(-2,0,0,2),
                        Arrays.asList(-1,0,0,1)
                )
        );

        test(
                new int[]{2,2,2,2,2},
                8,
                Arrays.asList(
                        Arrays.asList(2,2,2,2)
                )
        );

        test(
                new int[]{1,2,3,4},
                100,
                Arrays.asList()
        );
    }
}