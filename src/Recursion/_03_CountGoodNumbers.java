package Recursion;/*
    Count Good Numbers

    A digit string of length n is considered "good" if:

    - Digits at even indices (0, 2, 4, ...) are even digits:
      {0, 2, 4, 6, 8} → 5 choices

    - Digits at odd indices (1, 3, 5, ...) are prime digits:
      {2, 3, 5, 7} → 4 choices

    Return the total number of good digit strings of length n.

    Since the answer can be very large, return it modulo:
    1_000_000_007

    Examples:

    n = 1
    Output = 5

    n = 2
    Output = 20

    n = 3
    Output = 100

    n = 4
    Output = 400

    n = 5
    Output = 2000

    Hint:
    Think about how many even-indexed positions and
    odd-indexed positions exist.

    Then think about how this relates to the Pow(x, n)
    problem you just solved.

    IMPORTANT:
    n can be extremely large, so O(n) is not acceptable.
*/

class _03_CountGoodNumbers {

    static final long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {

        long ans;

        if (n % 2 == 0) {
            ans = power(4, n / 2) * power(5, n / 2);
        } else {
            ans = power(5, (n + 1) / 2) * power(4, n / 2);
        }

        return (int) (ans % MOD);
    }

    static long power(long x, long n) {

        if (n == 0) return 1;

        long half = power((x * x) % MOD, n / 2);

        if (n % 2 == 0) {
            return half;
        }

        return (x * half) % MOD;
    }

    static void test(long n, long expected) {

        long actual = countGoodNumbers(n);

        if (actual == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("n        : " + n);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test(1, 5);
        test(2, 20);
        test(3, 100);
        test(4, 400);
        test(5, 2000);
        test(6, 8000);
        test(10, 3200000);
        test(50, 564908303);
        test(100, 564490093);
    }
}