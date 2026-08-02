package Arrays.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _06_CountSubarraysWithXorK {

    /*
     * Problem:
     * Given an array of integers nums and an integer k,
     * return the number of subarrays whose XOR is equal to k.
     *
     * Example:
     * Input :
     * nums = [4,2,2,6,4]
     * k = 6
     *
     * Output:
     * 4
     *
     * Explanation:
     * Subarrays:
     * [4,2]
     * [2,2,6]
     * [6]
     * [4,2,2,6,4]
     *
     * /*
     * Brute Force:
     * 1. Generate all possible subarrays.
     * 2. Compute XOR of each subarray.
     * 3. If XOR == k, increment the count.
     *
     * Time  : O(n²)
     * Space : O(1)
     *
     *
     * Optimal:
     * 1. Maintain a running prefix XOR.
     * 2. Store the frequency of each prefix XOR in a HashMap.
     * 3. Let current prefix XOR = xor.
     * 4. We need a previous prefix XOR such that:
     *
     *      previousXor ^ xor = k
     *
     *    Rearranging:
     *
     *      previousXor = xor ^ k
     *
     * 5. If (xor ^ k) exists in the map,
     *    add its frequency to the answer.
     * 6. Store/update the frequency of the current prefix XOR.
     *
     * Time  : O(n)
     * Space : O(n)
     */

    public static int subarraysWithXorK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int xor = 0;
        int count = 0;

        for (int num : nums) {

            xor ^= num;

            int required = xor ^ k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    private static void test(int[] nums, int k, int expected) {

        int result = subarraysWithXorK(nums, k);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Count Subarrays With XOR K =====");

        test(new int[]{4,2,2,6,4}, 6, 4);

        test(new int[]{5,6,7,8,9}, 5, 2);

        test(new int[]{1,1,1,1}, 0, 4);

        test(new int[]{3,3,3}, 3, 4);
    }
}