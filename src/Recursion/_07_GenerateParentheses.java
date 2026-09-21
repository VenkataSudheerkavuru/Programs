package Recursion;/*
    Generate Parentheses

    Given n pairs of parentheses, generate all combinations
    of well-formed parentheses.

    Examples:

    n = 1
    Output:
    ()

    n = 2
    Output:
    (())
    ()()

    n = 3
    Output:
    ((()))
    (()())
    (())()
    ()(())
    ()()()

    Rules:

    1. We can add '(' while we still have opening brackets left.
    2. We can add ')' only when the number of ')' used is
       less than the number of '(' used.

    Why?

    We must never have more closing brackets than opening
    brackets at any point.

    Example:

    "())"  → invalid
           because at the second position we already have
           more ')' than '('.

    Think recursively:

        Choose '('
            OR
        Choose ')'

    But each choice has a condition.

    Base case:
        When the string length becomes 2 * n,
        we have a complete valid combination.
*/

import java.util.*;

class _07_GenerateParentheses {

    static List<String> generateParentheses(int n) {

        // Write your code here
        List<String> result = new ArrayList<>();
        generate(n,0,0,"",result);
        return result;
    }

    static void generate(
            int n,
            int open,
            int close,
            String current,
            List<String> result) {

        if(open == n && close==n){
            result.add(current);
            return;
        }
        if(open < n ) generate(n,open+1,close,current + "(",result);
        if(close < open){
            generate(n,open,close+1,current + ")",result);
        }

    }

    static void test(int n, List<String> expected) {

        List<String> actual = generateParentheses(n);

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
                "()"
        ));

        test(2, Arrays.asList(
                "(())",
                "()()"
        ));

        test(3, Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ));

        test(0, Arrays.asList(
                ""
        ));
    }
}