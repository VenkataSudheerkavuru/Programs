package Recursion;

import java.util.*;

class _02_PowXN {

    /*
     * Problem: Pow(x, n)
     *
     * Given a number x and an integer n, calculate x raised
     * to the power n.
     *
     * Example 1:
     *
     * Input:
     * x = 2.0
     * n = 10
     *
     * Output:
     * 1024.0
     *
     * Example 2:
     *
     * Input:
     * x = 2.1
     * n = 3
     *
     * Output:
     * 9.261
     *
     * Example 3:
     *
     * Input:
     * x = 2.0
     * n = -2
     *
     * Output:
     * 0.25
     *
     * Example 4:
     *
     * Input:
     * x = 1.0
     * n = 0
     *
     * Output:
     * 1.0
     *
     * IMPORTANT:
     * Do NOT simply multiply x n times.
     *
     * Target:
     * Time  : O(log n)
     * Space : O(log n) using recursion
     *
     * Think about:
     *
     * pow(x, n)
     *
     * If n is even:
     *     Can you express it using pow(x, n/2)?
     *
     * If n is odd:
     *     What extra x is required?
     *
     * Also think about negative n.
     */

    public static double myPow(double x, int n) {

        long exponent = n;

        if (exponent < 0) {
            exponent = -exponent;
        }

        double ans = power(x, exponent);

        return n < 0 ? 1 / ans : ans;
    }


    static double power(double x, long n) {

        if (n == 0) return 1;

        double half = power(x * x, n / 2);

        if (n % 2 == 0) {
            return half;
        }

        return x * half;
    }


    static void test(double x, int n, double expected) {

        double actual = myPow(x, n);

        // Floating-point comparison
        if (Math.abs(actual - expected) < 1e-9) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("x        : " + x);
            System.out.println("n        : " + n);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }


    public static void main(String[] args) {

        test(2.0, 10, 1024.0);

        test(2.1, 3, 9.261);

        test(2.0, -2, 0.25);

        test(2.0, 0, 1.0);

        test(5.0, 1, 5.0);

        test(5.0, -1, 0.2);

        test(1.0, 100, 1.0);

        test(-2.0, 3, -8.0);

        test(-2.0, 4, 16.0);

        test(0.0, 5, 0.0);
    }
}