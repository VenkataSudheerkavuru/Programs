package Arrays.easy;

public class SecondLargestElement {

    public static int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        boolean secondExists = false;

        for (int num : arr) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;

                if (secondLargest != Integer.MIN_VALUE) {
                    secondExists = true;
                }

            } else if (num != largest && num > secondLargest) {
                secondLargest = num;
                secondExists = true;
            }
        }

        return secondExists ? secondLargest : -1;
    }

    public static void main(String[] args) {

        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println(secondLargest(arr1)); // Expected: 34

        int[] arr2 = {10, 10, 10};
        System.out.println(secondLargest(arr2)); // Expected: -1

        int[] arr3 = {5};
        System.out.println(secondLargest(arr3)); // Expected: -1

        int[] arr4 = {5, 2};
        System.out.println(secondLargest(arr4)); // Expected: 2

        int[] arr5 = {2, 5};
        System.out.println(secondLargest(arr5)); // Expected: 2

        int[] arr6 = {-5, -10, -3};
        System.out.println(secondLargest(arr6)); // Expected: -5

        int[] arr7 = {7, 7, 6};
        System.out.println(secondLargest(arr7)); // Expected: 6
    }
}