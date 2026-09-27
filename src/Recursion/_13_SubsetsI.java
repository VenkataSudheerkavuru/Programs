package Recursion;

import java.util.*;

class _13_SubsetsI {

    /*
     * Problem:
     * Given an integer array nums containing distinct integers,
     * return all possible subsets (the power set).
     *
     * The solution can be returned in any order.
     *
     * Example 1:
     * Input:
     * nums = [1,2,3]
     *
     * Output:
     * [
     *   [],
     *   [1],
     *   [2],
     *   [3],
     *   [1,2],
     *   [1,3],
     *   [2,3],
     *   [1,2,3]
     * ]
     *
     * Example 2:
     * Input:
     * nums = [0]
     *
     * Output:
     * [
     *   [],
     *   [0]
     * ]
     *
     * Key Pattern:
     * For every element we have two choices:
     *
     * 1. Pick the element
     * 2. Don't pick the element
     *
     * Recursion:
     *
     *              element
     *              /     \
     *           PICK    NOT PICK
     *
     * Remember:
     * Pick -> Recurse -> Undo -> Not Pick -> Recurse
     */

    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

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

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // PICK
        current.add(nums[index]);
        generate(nums, index + 1, current, result);

        // UNDO
        current.removeLast();

        // NOT PICK
        generate(nums, index + 1, current, result);

    }

    // ---------------- TEST HARNESS ----------------

    static void test(
            int[] nums,
            List<List<Integer>> expected) {

        List<List<Integer>> actual = subsets(nums);

        // Order of subsets does not matter
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
                new int[]{1, 2, 3},

                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(3),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3),
                        Arrays.asList(1, 2, 3)
                )
        );

        test(
                new int[]{0},

                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(0)
                )
        );

        test(
                new int[]{1, 2},

                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(1, 2)
                )
        );
    }
}