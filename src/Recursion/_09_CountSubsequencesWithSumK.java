package Recursion;/*
    Count all subsequences with Sum K

    Given an array of integers and an integer K,
    count how many subsequences have sum exactly K.

    Example:

    arr = [1, 2, 1]
    K = 2

    Valid subsequences:

    [2]       → sum = 2
    [1, 1]     → sum = 2

    Answer = 2


    Core pattern:

    For every element we have 2 choices:

        1. Pick the element
        2. Don't pick the element

    Difference from Power Set:

        Power Set → store every subsequence

        This problem → only count subsequences
                     whose sum is K


    Think about the recursive state:

        index → which element we're processing
        sum   → current sum


    Base case:

        When index reaches the end,
        check whether sum == K.

    IMPORTANT:

        Do not generate/store all subsequences.
        Just return the count.
*/

import java.util.*;

class _09_CountSubsequencesWithSumK {

    static int countSubsequences(int[] arr, int k) {
        return count(arr, 0, 0, k);
    }

    static int count(
            int[] arr,
            int index,
            int sum,
            int k) {

        if (index == arr.length) {
            return sum == k ? 1 : 0;
        }

        int pick = count(
                arr,
                index + 1,
                sum + arr[index],
                k
        );

        int notPick = count(
                arr,
                index + 1,
                sum,
                k
        );

        return pick + notPick;
    }

    static void test(int[] arr, int k, int expected) {

        int actual = countSubsequences(arr, k);

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

        test(
            new int[]{1, 2, 1},
            2,
            2
        );

        test(
            new int[]{1, 2, 3},
            3,
            2
        );

        test(
            new int[]{1, 1, 1},
            2,
            3
        );

        test(
            new int[]{1, 2, 1, 3},
            3,
            3
        );

        test(
            new int[]{1, 2, 3},
            10,
            0
        );

        test(
            new int[]{},
            0,
            1
        );
    }
}