package Recursion;/*
    Combination Sum

    Given an array of distinct positive integers and a target,
    find all unique combinations whose sum equals target.

    An element can be chosen MULTIPLE times.

    Example:

    candidates = [2, 3, 6, 7]
    target = 7

    Output:

    [2, 2, 3]
    [7]

    Important:

    [2, 2, 3] is valid because 2 can be selected multiple times.

    Pattern:

    At every index we have two choices:

        1. PICK the current element
           → stay at the SAME index
           → because we can use it again

        2. DON'T PICK the current element
           → move to index + 1

    Example:

        candidates = [2, 3, 6, 7]

        At 2:

             PICK 2
                ↓
             index stays 0

             DON'T PICK 2
                ↓
             index becomes 1

    Base cases:

        If target == 0:
            We found a valid combination.

        If index reaches the end:
            No more candidates.

        If target becomes negative:
            This path cannot produce a valid combination
            because all numbers are positive.

    Important:
        Do NOT reuse the same element by moving backward.
        Staying at the same index is enough.
*/

import java.util.*;

class _11_CombinationSum {

    static List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
         generate(candidates,0,target,new ArrayList<>(),result);
         return result;
    }

    static void generate(
            int[] candidates,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> result) {

        // Write your code here
        if(index == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        //pick
        current.add(candidates[index]);
        generate(candidates,index,target-candidates[index],current,result);

        // not pick
        current.remove(current.size() - 1);
        generate(candidates,index+1,target,current,result);
    }

    static void test(
            int[] candidates,
            int target,
            List<List<Integer>> expected) {

        List<List<Integer>> actual =
                combinationSum(candidates, target);

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
            new int[]{2, 3, 6, 7},
            7,
            Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
            )
        );

        test(
            new int[]{2, 3, 5},
            8,
            Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
            )
        );

        test(
            new int[]{2},
            1,
            new ArrayList<>()
        );

        test(
            new int[]{1},
            3,
            Arrays.asList(
                Arrays.asList(1, 1, 1)
            )
        );
    }
}