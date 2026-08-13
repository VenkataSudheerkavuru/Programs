package BinarySerach.on_answers;

import java.util.Arrays;

public class _06_AggressiveCows {

    /*
     * Problem:
     *
     * You are given positions of stalls on a straight line.
     *
     * You need to place k cows in different stalls.
     *
     * The cows should be placed such that the MINIMUM distance
     * between any two cows is as LARGE as possible.
     *
     * Return the largest possible minimum distance.
     *
     * Example:
     *
     * stalls = [0,3,4,7,9,10]
     * k = 4
     *
     * One possible placement:
     *
     * 0, 3, 7, 10
     *
     * Distances:
     * 3, 4, 3
     *
     * Minimum distance = 3
     *
     * We cannot place 4 cows with minimum distance 4.
     *
     * Therefore answer = 3.
     *
     * Important:
     *
     * The stalls are not necessarily given in sorted order.
     * You may sort them first.
     */

    public static int aggressiveCows(int[] stalls, int k) {

        // Write your code here
        Arrays.sort(stalls);
        int min = 1;
        int max = stalls[stalls.length-1]-stalls[0];
        int ans = -1;
        while(min<=max){
            int mid = min + (max -  min)/2;
            int temp = 1;
            int prev = stalls[0];
            for(int i=1;i<stalls.length;i++){
                if(stalls[i] - prev >= mid){
                    prev = stalls[i];
                    temp++;
                }
            }
            if(temp >= k){
                ans = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        return ans;
    }

    private static void test(int[] stalls, int k, int expected) {

        int result = aggressiveCows(stalls, k);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Aggressive Cows =====");

        test(new int[]{0,3,4,7,9,10}, 4, 3);

        test(new int[]{1,2,4,8,9}, 3, 3);

        test(new int[]{10,1,2,7,5}, 3, 4);

        test(new int[]{1,2,3,4,5}, 2, 4);

        test(new int[]{1,10}, 2, 9);
    }
}