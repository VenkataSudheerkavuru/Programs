package Recursion;/*
    Check if there exists a subsequence with Sum K

    Given an array and K, return true if at least one
    subsequence has sum exactly K.

    Example:

    arr = [1, 2, 1]
    K = 2

    Valid subsequences include:
    [2]
    [1, 1]

    Answer = true


    Pattern:

    For every element:

        PICK
        NOT PICK

    Difference from the previous problem:

        Count all subsequences with sum K
        → return the NUMBER of valid subsequences

        This problem
        → return whether AT LEAST ONE exists

    Base case:

        When index reaches the end,
        return true if sum == K,
        otherwise false.

    Think about what should happen when:

        pick returns true
        OR
        notPick returns true
*/

import java.util.*;

class _10_CheckSubsequenceSumK {

    static boolean existsSubsequence(int[] arr, int k) {

        // Write your code here
        return check(arr,0,0,k);
    }

    static boolean check(
            int[] arr,
            int index,
            int sum,
            int k) {

        if(sum == k) return true;
        if (index == arr.length) {
            return false;
        }

        boolean pick = check(
                arr,
                index + 1,
                sum + arr[index],
                k
        );

        boolean notPick = check(
                arr,
                index + 1,
                sum,
                k
        );

        return pick || notPick;
    }

    static void test(int[] arr, int k, boolean expected) {

        boolean actual = existsSubsequence(arr, k);

        if (actual == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + Arrays.toString(arr));
            System.out.println("K        : " + k);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{1, 2, 1}, 2, true);

        test(new int[]{1, 2, 3}, 10, false);

        test(new int[]{1, 1, 1}, 2, true);

        test(new int[]{5, 2, 1}, 4, false);

        test(new int[]{2, 3, 1}, 5, true);

        test(new int[]{}, 0, true);
    }
}