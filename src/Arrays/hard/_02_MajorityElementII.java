package Arrays.hard;

import java.util.*;

public class _02_MajorityElementII {

    /*
     * Problem:
     * Given an integer array of size n,
     * return all elements that appear more than ⌊n/3⌋ times.
     *
     * Example:
     * Input : [3,2,3]
     * Output: [3]
     *
     * Input : [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     */
    public static List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {

            // Already a candidate
            if (num == candidate1) {
                count1++;
            }

            // Already second candidate
            else if (num == candidate2) {
                count2++;
            }

            // First slot is free
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            // Second slot is free
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            // Three different numbers cancel each other
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static List<Integer> majorityElement_Better(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    private static void test(int[] nums, List<Integer> expected) {

        List<Integer> result = majorityElement(nums);

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Majority Element II =====");

        test(new int[]{3, 2, 3}, Arrays.asList(3));
        test(new int[]{1, 1, 1, 3, 3, 2, 2, 2}, Arrays.asList(1, 2));
        test(new int[]{1}, Arrays.asList(1));
        test(new int[]{1, 2}, Arrays.asList(1, 2));
        test(new int[]{2, 2}, Arrays.asList(2));

    }
}