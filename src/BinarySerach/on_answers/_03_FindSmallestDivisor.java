package BinarySerach.on_answers;

public class _03_FindSmallestDivisor {

    /*
     * Problem:
     *
     * You are given an integer array nums and an integer threshold.
     *
     * Find the smallest positive integer divisor such that:
     *
     *     sum of ceil(nums[i] / divisor)
     *
     * is less than or equal to threshold.
     *
     * Example:
     *
     * nums = [1,2,5,9]
     * threshold = 6
     *
     * divisor = 5:
     *
     * ceil(1/5) = 1
     * ceil(2/5) = 1
     * ceil(5/5) = 1
     * ceil(9/5) = 2
     *
     * Total = 5
     *
     * 5 <= 6, so divisor 5 is valid.
     *
     * We need the SMALLEST valid divisor.
     *
     * Example:
     *
     * nums = [44,22,33,11,1]
     * threshold = 5
     *
     * Output = 44
     *
     * Constraints:
     * - nums contains positive integers.
     * - divisor must be a positive integer.
     */

    public static int smallestDivisor(int[] nums, int threshold) {

        // Write your code here

        int high = 0;
        int ans = high;
        for(int i: nums){
            if(i > high){
                high = i;
            }
        }
        int low = 1;
        while(low<= high){
            int mid = low + (high-low)/2;
            int sum = 0;
            for(int i:nums){
                sum += (i + mid - 1) / mid;
            }
            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static void test(int[] nums, int threshold, int expected) {

        int result = smallestDivisor(nums, threshold);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Find Smallest Divisor =====");

        test(new int[]{1,2,5,9}, 6, 5);

        test(new int[]{44,22,33,11,1}, 5, 44);

        test(new int[]{1,2,3,4,5}, 8, 3);

        test(new int[]{5,5,5,5}, 4, 5);

        test(new int[]{10}, 3, 4);
    }
}