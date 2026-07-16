package Arrays.medium;

public class _09_StockBuyAndSell {

    /*
     * Problem:
     * You are given an array where arr[i] represents the price of a stock
     * on the ith day.
     *
     * You may buy one stock and sell one stock only once.
     *
     * Return the maximum profit you can achieve.
     *
     * If no profit is possible, return 0.
     *
     * Sample Input:
     * arr = [7,1,5,3,6,4]
     *
     * Sample Output:
     * 5
     *
     * Explanation:
     * Buy at price 1 and sell at price 6.
     * Profit = 5.
     *
     * For every day, the best selling profit depends only on the cheapest buying price seen before that day.
     *  Therefore, while traversing once, maintain the minimum price so far and calculate the profit if we sell today.
     *  Keep the maximum profit among all days.
     */

    public static int maxProfit(int[] arr) {

        // Write your code here
        int maxProfit = 0;
        int minSoFar = arr[0];
        for(int i = 1;i< arr.length;i++){
           if(arr[i] > minSoFar){
               maxProfit = Math.max(maxProfit,arr[i]-minSoFar);
           }else{
               minSoFar = arr[i];
           }
        }
        return maxProfit;
    }

    private static void test(int[] arr, int expected) {

        int actual = maxProfit(arr);

        if (actual == expected) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Got      : " + actual);
        }
    }

    public static void main(String[] args) {

        test(new int[]{7,1,5,3,6,4}, 5);

        test(new int[]{7,6,4,3,1}, 0);

        test(new int[]{2,4,1}, 2);

        test(new int[]{1,2}, 1);

        test(new int[]{2,1}, 0);

        test(new int[]{3,2,6,5,0,3}, 4);
    }
}