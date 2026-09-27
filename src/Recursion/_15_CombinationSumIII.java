package Recursion;

import java.util.*;

class _15_CombinationSumIII {

    /*
     * Problem:
     * Find all valid combinations of k distinct numbers
     * from 1 through 9 whose sum is exactly n.
     *
     * Each number can be used at most once.
     *
     * Example:
     *
     * Input:
     * k = 3
     * n = 7
     *
     * Output:
     * [[1,2,4]]
     *
     * Key idea:
     * - Choose numbers from 1 to 9
     * - Each number can be used once
     * - Exactly k numbers must be selected
     * - Their sum must equal n
     *
     * Think:
     * Combination Sum II
     * +
     * exactly k elements
     * +
     * numbers restricted to 1...9
     */

    static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        generate(
            1,
            k,
            n,
            new ArrayList<>(),
            result
        );

        return result;
    }

    static void generate(
            int index,
            int k,
            int target,
            List<Integer> candidates,
            List<List<Integer>> result) {


        // Exactly k numbers selected and target reached
        if (k == candidates.size() && target == 0) {
            result.add(new ArrayList<>(candidates));
            return;
        }

        // Invalid branch
        if (index>9 || target < 0 || k == candidates.size()) {
            return;
        }

        // PICK
        candidates.add(index);

        generate(
                index + 1,
                k,
                target - index,
                candidates,
                result
        );

        // UNDO
        candidates.remove(candidates.size() - 1);

        // NOT PICK
        generate(
                index + 1,
                k,
                target,
                candidates,
                result
        );
    }

    // ---------------- TEST HARNESS ----------------

    static void test(
            int k,
            int n,
            List<List<Integer>> expected) {

        List<List<Integer>> actual =
                combinationSum3(k, n);

        Set<List<Integer>> expectedSet =
                new HashSet<>(expected);

        Set<List<Integer>> actualSet =
                new HashSet<>(actual);

        if (expectedSet.equals(actualSet)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("K        : " + k);
            System.out.println("Target   : " + n);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        test(
            3,
            7,
            Arrays.asList(
                Arrays.asList(1, 2, 4)
            )
        );

        test(
            3,
            9,
            Arrays.asList(
                Arrays.asList(1, 2, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 3, 4)
            )
        );

        test(
            4,
            1,
            Arrays.asList()
        );

        test(
            3,
            15,
            Arrays.asList(
                Arrays.asList(1, 5, 9),
                Arrays.asList(1, 6, 8),
                Arrays.asList(2, 4, 9),
                Arrays.asList(2, 5, 8),
                Arrays.asList(2, 6, 7),
                Arrays.asList(3, 4, 8),
                Arrays.asList(3, 5, 7),
                Arrays.asList(4, 5, 6)
            )
        );
    }
}