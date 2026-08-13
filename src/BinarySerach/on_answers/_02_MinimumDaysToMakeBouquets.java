package BinarySerach.on_answers;

public class _02_MinimumDaysToMakeBouquets {

    /*
     * Problem:
     *
     * You are given an array bloomDay[].
     *
     * bloomDay[i] = the day on which the i-th flower blooms.
     *
     * To make ONE bouquet:
     * - You need exactly k adjacent flowers.
     * - All k flowers must have bloomed by that day.
     *
     * You need to make m bouquets.
     *
     * Find the MINIMUM number of days required to make
     * at least m bouquets.
     *
     * Example:
     *
     * bloomDay = [1,10,3,10,2]
     * m = 3
     * k = 1
     *
     * Output = 3
     *
     * Explanation:
     * By day 3:
     * [1,  X,  3,  X,  2]
     *
     * We have 3 bloomed flowers, so we can make
     * 3 bouquets of 1 flower each.
     *
     * Another example:
     *
     * bloomDay = [1,10,3,10,2]
     * m = 3
     * k = 2
     *
     * Output = -1
     *
     * Because we need 3 * 2 = 6 flowers,
     * but only 5 flowers exist.
     *
     * Constraints:
     * - Flowers must be adjacent for the same bouquet.
     * - A flower can be used in only one bouquet.
     */

    public static int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length < m * k) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        int ans = -1;

        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while (min <= max) {

            int temp = 0;
            int count = 0;

            int mid = min + (max - min) / 2;

            for (int i : bloomDay) {

                if (i <= mid) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == k) {
                    temp++;
                    count = 0;
                }
            }

            if (temp >= m) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    private static void test(int[] bloomDay, int m, int k, int expected) {

        int result = minDays(bloomDay, m, k);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Minimum Days to Make M Bouquets =====");

        test(new int[]{1,10,3,10,2}, 3, 1, 3);

        test(new int[]{1,10,3,10,2}, 3, 2, -1);

        test(new int[]{7,7,7,7,12,7,7}, 2, 3, 12);

        test(new int[]{1,2,4,9,3,4,1}, 2, 2, 4);

        test(new int[]{1,1,1,1}, 2, 2, 1);
    }
}