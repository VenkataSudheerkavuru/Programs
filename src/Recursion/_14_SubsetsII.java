package Recursion;

import java.util.*;

class _14_SubsetsII {

    /*
     * Problem:
     * Given an integer array nums that may contain duplicates,
     * return all possible subsets.
     *
     * The solution must not contain duplicate subsets.
     *
     * Example:
     *
     * Input:
     * [1,2,2]
     *
     * Output:
     * [
     *   [],
     *   [1],
     *   [2],
     *   [1,2],
     *   [2,2],
     *   [1,2,2]
     * ]
     *
     * Key idea:
     * 1. Sort the array so duplicates are adjacent.
     * 2. Use pick / not-pick recursion.
     * 3. When NOT picking a value, skip all duplicate
     *    copies of that value at the same recursion level.
     */

    static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        generate(
            nums,
            0,
            new ArrayList<>(),
            result
        );

        return result;
    }

    static void generate(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Write your code here
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        // PICK
        current.add(nums[index]);
        generate(nums, index + 1, current, result);

        // UNDO
        current.removeLast();

        int next = index+1;
        while (next<nums.length && nums[index] == nums[next]){
            next++;
        }

        generate(nums,next,current,result);


    }

    // ---------------- TEST HARNESS ----------------

    static void test(
            int[] nums,
            List<List<Integer>> expected) {

        List<List<Integer>> actual = subsetsWithDup(nums);

        Set<List<Integer>> expectedSet =
                new HashSet<>(expected);

        Set<List<Integer>> actualSet =
                new HashSet<>(actual);

        if (expectedSet.equals(actualSet)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println(
                    "Input    : " + Arrays.toString(nums)
            );
            System.out.println(
                    "Expected : " + expected
            );
            System.out.println(
                    "Actual   : " + actual
            );
        }
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        test(
            new int[]{1, 2, 2},

            Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 2, 2)
            )
        );

        test(
            new int[]{1, 2, 2, 2},

            Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2, 2, 2),
                Arrays.asList(1, 2, 2, 2)
            )
        );

        test(
            new int[]{0},

            Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)
            )
        );
    }
}