package Recursion;

class _01_RecursiveAtoi {

    /*
     * Problem: Recursive Implementation of atoi()
     *
     * Given a string representing a valid integer, convert it into
     * its integer value using recursion.
     *
     * Example 1:
     *
     * Input:
     * "1234"
     *
     * Output:
     * 1234
     *
     * Example 2:
     *
     * Input:
     * "-1234"
     *
     * Output:
     * -1234
     *
     * Example 3:
     *
     * Input:
     * "42"
     *
     * Output:
     * 42
     *
     * Think about:
     * - How to process one character at a time
     * - How to move to the next index recursively
     * - How to build the number
     * - How to handle the sign
     *
     * Try to identify:
     * 1. Base case
     * 2. Current character's contribution
     * 3. Recursive call
     * 4. How the result comes back
     */


    static long solve(String str, int index, long result, int sign) {

        // Base case
        if (index >= str.length() || !Character.isDigit(str.charAt(index))) {

            return result * sign;
        }

        int digit = str.charAt(index) - '0';

        long next = result * 10 + digit;

        // Positive overflow
        if (sign == 1 && next > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        // Negative overflow
        if (sign == -1 && next > -(long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return solve(str, index + 1, next, sign);
    }

    static void test(String input, int expected) {

        int actual = myAtoi(input);

        if (actual == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + input);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test("1234", 1234);
        test("42", 42);
        test("7", 7);
        test("-1234", -1234);
        test("-42", -42);
        test("0", 0);
        test("987654", 987654);
    }

    public static int myAtoi(String str) {

        int sign = 1;
        int i = 0;

        // Skip leading spaces
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        // Handle sign
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {

            if (str.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        long result = solve(str, i, 0, sign);

        return (int) result;
    }
}