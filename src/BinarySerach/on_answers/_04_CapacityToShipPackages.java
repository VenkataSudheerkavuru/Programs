package BinarySerach.on_answers;

public class _04_CapacityToShipPackages {

    /*
     * Problem:
     *
     * You have packages that must be shipped in order.
     *
     * weights[i] = weight of the i-th package.
     *
     * The ship has a maximum capacity.
     * You have D days to ship all packages.
     *
     * Rules:
     * - Packages must be shipped in the given order.
     * - You cannot split a package.
     * - Each day's total package weight cannot exceed
     *   the ship's capacity.
     *
     * Find the MINIMUM ship capacity needed to ship
     * all packages within D days.
     *
     * Example:
     *
     * weights = [1,2,3,4,5,6,7,8,9,10]
     * days = 5
     *
     * Output = 15
     *
     * With capacity 15:
     *
     * Day 1 → 1 + 2 + 3 + 4 + 5 = 15
     * Day 2 → 6 + 7 = 13
     * Day 3 → 8
     * Day 4 → 9
     * Day 5 → 10
     *
     * So capacity 15 works.
     *
     * We need the smallest capacity that works.
     */

    public static int shipWithinDays(int[] weights, int days) {

        // Write your code here
        int min = 0;
        int max = 0;
//        Capacity cannot be less than the heaviest package.
//        Capacity equal to the total sum can always ship everything in 1 day.
        for(int i : weights){
            max += i;
            min = Math.max(min,i);
        }
        int ans = -1;
        while (min <= max){
            int mid = min + (max-min)/2;
            int sum = 0;
            int temp = 1;
            for(int i : weights){
                sum += i;
                if(sum > mid){
                    sum = i;
                    temp++;
                }
            }
            if(temp <= days){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid+1;
            }
        }
        return ans;
    }

    private static void test(int[] weights, int days, int expected) {

        int result = shipWithinDays(weights, days);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Capacity to Ship Packages =====");

        test(new int[]{1,2,3,4,5,6,7,8,9,10}, 5, 15);

        test(new int[]{3,2,2,4,1,4}, 3, 6);

        test(new int[]{1,2,3,1,1}, 4, 3);

        test(new int[]{10}, 1, 10);

        test(new int[]{1,2,3,4,5}, 5, 5);
    }
}