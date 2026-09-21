package Recursion;/*
    Generate Binary Strings Without Consecutive 1s

    Given an integer n, generate all binary strings of length n
    such that no two consecutive characters are '1'.

    Examples:

    n = 1
    Output:
    0
    1

    n = 2
    Output:
    00
    01
    10

    n = 3
    Output:
    000
    001
    010
    100
    101

    Important:
    "11" is not allowed because there are consecutive 1s.

    Think recursively:

    At every position, we can choose:
        0 → always allowed
        1 → allowed only if the previous character was not 1

    Base case:
        When the string length becomes n,
        add the generated string to the result.
*/

import java.util.*;

class _06_GenerateBinaryStrings {

    static List<String> generateBinaryStrings(int n) {

        // Write your code here
        List<String> result = new ArrayList<>();
        generate(n,"",result);
        return result;
    }

    static void generate(int n, String current, List<String> result) {

        if (current.length() == n) {
            result.add(current);
            return;
        }

        // 0 is always allowed
        generate(n, current + "0", result);

        // 1 is allowed only if previous character is 0
        if (current.isEmpty() || current.charAt(current.length() - 1) == '0') {
            generate(n, current + "1", result);
        }
    }

    static void test(int n, List<String> expected) {

        List<String> actual = generateBinaryStrings(n);

        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("n        : " + n);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test(1, Arrays.asList(
                "0", "1"
        ));

        test(2, Arrays.asList(
                "00", "01", "10"
        ));

        test(3, Arrays.asList(
                "000", "001", "010", "100", "101"
        ));

        test(0, Arrays.asList(
                ""
        ));
    }
}