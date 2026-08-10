package BinarySerach.on_arrays_1d;

public class _12_SingleElementInSortedArray {

    /*
     * Problem:
     * Given a sorted array where every element
     * appears exactly twice except one element,
     * find that single element.
     *
     * Time : O(log n)
     * Space: O(1)
     *
     * Example:
     *
     * nums = [1,1,2,3,3,4,4,8,8]
     *
     * Output:
     * 2
     */

    public static int singleNonDuplicate(int[] arr) {

        // Write your code here

        int n = arr.length;

        // Edge case: only one element in the array
        if (n == 1) return arr[0];

        // Edge case: first element is the unique one
        if (arr[0] != arr[1]) return arr[0];

        // Edge case: last element is the unique one
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        // Initialize binary search bounds (exclude first and last index)
        int low = 1, high = n - 2;

        // Perform binary search
        while (low <= high) {
            // Calculate middle index
            int mid = (low + high) / 2;

            // Check if middle element is the unique one
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // If mid is in the left half (pairing is valid)
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                // Move to the right half
                low = mid + 1;
            }
            // If mid is in the right half (pairing broken earlier)
            else {
                // Move to the left half
                high = mid - 1;
            }
        }
        return -1;
    }

    private static void test(int[] nums, int expected) {

        int result = singleNonDuplicate(nums);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Single Element =====");

        test(new int[]{1,1,2,3,3,4,4,8,8}, 2);

        test(new int[]{3,3,7,7,10,11,11}, 10);

        test(new int[]{1}, 1);

        test(new int[]{1,2,2}, 1);

        test(new int[]{1,1,2}, 2);
    }
}