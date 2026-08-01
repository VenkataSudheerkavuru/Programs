package Arrays.hard;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03_ThreeSum {

    /*
     * Problem:
     * Given an integer array nums,
     * return all the unique triplets [nums[i], nums[j], nums[k]]
     * such that:
     *
     *      i != j
     *      i != k
     *      j != k
     *      nums[i] + nums[j] + nums[k] == 0
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     * Input : [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * Input : [0,1,1]
     * Output: []
     *
     * Input : [0,0,0]
     * Output: [[0,0,0]]
     * /*
     * Brute Force:
     * 1. Use 3 nested loops to generate all possible triplets.
     * 2. If nums[i] + nums[j] + nums[k] == 0,
     *    sort the triplet and store it in a Set to avoid duplicates.
     *
     * Time  : O(n^3)
     * Space : O(no. of unique triplets)
     *
     *
     * Better:
     * 1. Fix the first element (i).
     * 2. For every i, use a HashSet.
     * 3. Traverse j from i+1 to n-1.
     * 4. Calculate third = -(nums[i] + nums[j]).
     * 5. If third is already present in the HashSet,
     *    a valid triplet is found.
     * 6. Sort the triplet and store it in a Set to avoid duplicates.
     * 7. Add nums[j] to the HashSet.
     *
     * Time  : O(n^2)
     * Space : O(n)
     *
     *
     * Optimal:
     * 1. Sort the array.
     * 2. Fix one element (i).
     * 3. Skip duplicate values of i.
     * 4. Use two pointers:
     *      left = i + 1
     *      right = n - 1
     * 5. Calculate sum = nums[i] + nums[left] + nums[right].
     *      - If sum < 0, move left++.
     *      - If sum > 0, move right--.
     *      - If sum == 0,
     *          store the triplet,
     *          move both pointers,
     *          skip duplicate values of left and right.
     * 6. Continue until left >= right.
     *
     * Time  : O(n^2)
     * Space : O(1) (excluding output list)
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {

                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    private static void test(int[] nums, List<List<Integer>> expected) {

        List<List<Integer>> result = threeSum(nums);

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== 3 Sum =====");

        test(
                new int[]{-1, 0, 1, 2, -1, -4},
                Arrays.asList(
                        Arrays.asList(-1, -1, 2),
                        Arrays.asList(-1, 0, 1)
                )
        );

        test(
                new int[]{0, 1, 1},
                Arrays.asList()
        );

        test(
                new int[]{0, 0, 0},
                Arrays.asList(
                        Arrays.asList(0, 0, 0)
                )
        );

        test(
                new int[]{0, 0, 0, 0},
                Arrays.asList(
                        Arrays.asList(0, 0, 0)
                )
        );
    }
}