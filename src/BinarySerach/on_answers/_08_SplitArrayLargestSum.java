package BinarySerach.on_answers;

public class _08_SplitArrayLargestSum {

    /*
     * Problem:
     *
     * You are given an array of integers nums and an integer k.
     *
     * Split the array into exactly k non-empty subarrays.
     *
     * The elements in each subarray must be contiguous.
     *
     * Find the minimum possible value of the LARGEST sum
     * among all k subarrays.
     *
     * Example:
     *
     * nums = [7,2,5,10,8]
     * k = 2
     *
     * Possible split:
     *
     * [7,2,5] = 14
     * [10,8]  = 18
     *
     * Largest sum = 18
     *
     * Another split:
     *
     * [7,2] = 9
     * [5,10,8] = 23
     *
     * Largest sum = 23
     *
     * We want the minimum possible largest sum.
     *
     * Output = 18
     *
     * Important:
     *
     * - Subarrays must be contiguous.
     * - Every subarray must contain at least one element.
     * - The goal is to MINIMIZE the largest subarray sum.
     */

    public static int splitArray(int[] nums, int k) {

        // Write your code here
        int min = 0;
        int max = 0;
        int ans = 0;
        if(k  > nums.length) return -1;
        for(int i : nums){
            min = Math.max(i,min);
            max += i;
        }
        while(min<=max){
            int mid = min + (max-min)/2;
            int temp =1 ;
            int sum = 0;
            for(int i : nums){
                sum += i;
                if(sum > mid){
                    sum = i;
                    temp++;
                }
            }
            if(temp <= k){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        return ans;
    }

    private static void test(int[] nums, int k, int expected) {

        int result = splitArray(nums, k);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Split Array - Largest Sum =====");

        test(new int[]{7,2,5,10,8}, 2, 18);

        test(new int[]{1,2,3,4,5}, 2, 9);

        test(new int[]{1,4,4}, 3, 4);

        test(new int[]{10}, 1, 10);

        test(new int[]{1,2,3,4,5}, 5, 5);
    }
}