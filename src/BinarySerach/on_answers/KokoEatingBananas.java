package BinarySerach.on_answers;

public class KokoEatingBananas {

    /*
     * Problem:
     *
     * Koko has several piles of bananas and has h hours
     * to finish eating all of them.
     *
     * She chooses an eating speed k bananas/hour.
     * In each hour, she eats from only one pile.
     *
     * Find the minimum value of k such that
     * Koko can finish all piles within h hours.
     *
     * Example:
     *
     * piles = [3,6,7,11], h = 8
     * Output = 4
     *
     * At speed 4:
     * 3  -> 1 hour
     * 6  -> 2 hours
     * 7  -> 2 hours
     * 11 -> 3 hours
     *
     * Total = 8 hours
     *
     * Constraints:
     * - piles contains positive integers
     * - h is positive
     */

    public static int minEatingSpeed(int[] piles, int h) {

        // Write your code here
        int high = 0;
        int ans = high;
        for(int i: piles){
            if(i > high){
                high = i;
            }
        }
        int low = 1;
        while(low<= high){
            int mid = low + (high-low)/2;
            int sum = 0;
            for(int i:piles){
                sum += (i + mid - 1) / mid;
//                same as :
//                int hours = i / mid;
//                if (i % mid != 0) {
//                    hours++;
//                }
//                sum += hours;
            }
            if (sum <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static void test(int[] piles, int h, int expected) {

        int result = minEatingSpeed(piles, h);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Koko Eating Bananas =====");

        test(new int[]{3,6,7,11}, 8, 4);

        test(new int[]{30,11,23,4,20}, 5, 30);

        test(new int[]{30,11,23,4,20}, 6, 23);

        test(new int[]{1,1,1,1}, 4, 1);

        test(new int[]{10}, 3, 4);
    }
}