package Recursion;/*
    Power Set

    Given a string, generate all possible subsets
    (subsequences) of the string.

    For every character, we have exactly 2 choices:

        1. Pick the character
        2. Don't pick the character

    Example:

    Input:
        "abc"

    Output:
        ""
        "a"
        "b"
        "ab"
        "c"
        "ac"
        "bc"
        "abc"

    There are 2^n possible subsets for a string of length n.

    Example:

        "ab"

        ""
        "a"
        "b"
        "ab"

    Think recursively:

        At index i:

              current
              /     \
           pick     don't pick
            /         \
        include      skip
        s[i]          s[i]

    Base case:
        When index reaches the end of the string,
        add the current subsequence to the result.
*/

import java.util.*;

class _08_PowerSet {

    static List<String> powerSet(String s) {

        // Write your code here
        List<String> result = new ArrayList<>();
        generate(s,0,"",result);
        return result;
    }

    static void generate(
            String s,
            int index,
            String current,
            List<String> result) {

        // Write your code here
        if(index == s.length()){
            result.add(current);
            return;
        }
        //pick
        generate(s,index+1,current + s.charAt(index),result);
        //not pick
        generate(s,index+1,current,result);


    }

    static void test(String s, List<String> expected) {

        List<String> actual = powerSet(s);

        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + s);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test("a", Arrays.asList(
                "",
                "a"
        ));

        test("ab", Arrays.asList(
                "",
                "a",
                "b",
                "ab"
        ));

        test("abc", Arrays.asList(
                "",
                "a",
                "b",
                "ab",
                "c",
                "ac",
                "bc",
                "abc"
        ));

        test("", Arrays.asList(
                ""
        ));
    }
}