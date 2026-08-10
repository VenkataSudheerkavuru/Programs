package BinarySerach.on_arrays_1d;

public class _13_FindPeakElement {

    /*
     * Problem:
     * A peak element is greater than its neighbours.
     *
     * Return the index of any one peak.
     *
     * nums = [1,2,3,1]
     *
     * Output:
     * 2
     *
     * nums = [1,2,1,3,5,6,4]
     *
     * Output:
     * 1 or 5
     */

    public static int findPeakElement(int[] nums) {

        // Write your code here

        int n = nums.length;
        if(n==1)return 0;

        // first element
        if(nums[0]>nums[1]) return 0;
        // last element
        if(nums[n-1]>nums[n-2]) return n-1;

        int low = 1, high = nums.length - 2;

        // Binary search loop
        while (low <= high) {
            // Find mid point
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid-1]) {
                return mid;
            } else if(nums[mid] > nums[mid+1]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        // Return peak index
        return -1;
    }

    private static void test(int[] nums, int expected1, int expected2) {

        int result = findPeakElement(nums);

        if (result == expected1 || result == expected2) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actual : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Peak Element =====");

        test(new int[]{1,2,3,1}, 2, 2);

        test(new int[]{1,2,1,3,5,6,4}, 1, 5);

        test(new int[]{1}, 0, 0);

        test(new int[]{1,2}, 1, 1);

        test(new int[]{2,1}, 0, 0);
    }
}