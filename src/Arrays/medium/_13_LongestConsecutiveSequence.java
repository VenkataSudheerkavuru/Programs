package Arrays.medium;

import java.util.*;

public class _13_LongestConsecutiveSequence {

    /*
     * Problem:
     *
     * Given an unsorted array of integers, return the length
     * of the longest consecutive sequence.
     *
     * A consecutive sequence contains numbers that follow each
     * other without any gaps.
     *
     * The algorithm should run in O(n) time.
     *
     * Example 1:
     *
     * Input:
     * [100,4,200,1,3,2]
     *
     * Output:
     * 4
     *
     * Explanation:
     * Sequence = 1,2,3,4
     *
     * Example 2:
     *
     * Input:
     * [0,3,7,2,5,8,4,6,0,1]
     *
     * Output:
     * 9
     *
     * Explanation:
     * Sequence = 0,1,2,3,4,5,6,7,8
     */

    public static int longestConsecutive(int[] nums) {

        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count;
        for (int num : nums) {
            count = 1;
            if (set.contains(num - 1)) {
                continue;
            }

            while (true) {
                if (set.contains(num + 1)) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    break;
                }
                num = num+1;

            }
        }

        return max;
    }

    private static void test(int[] arr, int expected) {

        int actual = longestConsecutive(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{100,4,200,1,3,2}, 4);

        test(new int[]{0,3,7,2,5,8,4,6,0,1}, 9);

        test(new int[]{1,2,0,1}, 3);

        test(new int[]{9}, 1);

        test(new int[]{}, 0);
    }
}