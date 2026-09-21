package Recursion;/*
    Combination Sum II

    Given an array of candidates and a target,
    find all unique combinations whose sum equals target.

    IMPORTANT:

    - Each element can be used ONLY ONCE.
    - The input may contain duplicate values.
    - The result must not contain duplicate combinations.

    Example:

    candidates = [10,1,2,7,6,1,5]
    target = 8

    Output:

    [1,1,6]
    [1,2,5]
    [1,7]
    [2,6]


    Key difference from Combination Sum I:

    Combination Sum I:
        PICK → stay at same index
        because an element can be reused.

    Combination Sum II:
        PICK → move to index + 1
        because every element can be used only once.

    IMPORTANT:
        Sort the array first.

        Sorting allows us to skip duplicate choices
        at the same recursion level.

    Backtracking pattern:

        choose
        → recurse
        → undo

    Think carefully about:

        1. When should we add the current combination?
        2. What happens when target becomes negative?
        3. Why do we need to skip duplicates?
        4. Why is duplicate skipping based on the
           previous element at the SAME recursion level?
*/

import java.util.*;

class _12_CombinationSumII {

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        generate(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    static void generate(
            int[] candidates,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // PICK
        current.add(candidates[index]);

        generate(
                candidates,
                index + 1,
                target - candidates[index],
                current,
                result
        );

        // UNDO
        current.removeLast();

        // NOT PICK
        int next = index + 1;

        while (next < candidates.length &&
                candidates[next] == candidates[index]) {
            next++;
        }

        generate(
                candidates,
                next,
                target,
                current,
                result
        );
    }

    static void test(
            int[] candidates,
            int target,
            List<List<Integer>> expected) {

        List<List<Integer>> actual =
                combinationSum2(candidates, target);

        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Candidates : "
                    + Arrays.toString(candidates));
            System.out.println("Target     : " + target);
            System.out.println("Expected   : " + expected);
            System.out.println("Actual     : " + actual);
        }
    }

    public static void main(String[] args) {

        test(
            new int[]{10, 1, 2, 7, 6, 1, 5},
            8,
            Arrays.asList(
                Arrays.asList(1, 1, 6),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 7),
                Arrays.asList(2, 6)
            )
        );

        test(
            new int[]{2, 5, 2, 1, 2},
            5,
            Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5)
            )
        );

        test(
            new int[]{1},
            1,
            Arrays.asList(
                Arrays.asList(1)
            )
        );

        test(
            new int[]{1, 1, 1, 1},
            2,
            Arrays.asList(
                Arrays.asList(1, 1)
            )
        );
    }
}