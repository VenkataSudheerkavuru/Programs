package Arrays.easy;

public class _02_RemoveDuplicates {

        public static int removeDuplicates(int[] nums) {

            if (nums.length == 0) {
                return 0;
            }

            int prev = nums[0];
            int j = 1;

            for (int i = 1; i < nums.length; i++) {

                if (prev != nums[i]) {
                    prev = nums[i];
                    nums[j++] = prev;
                }
            }

            return j;
        }

//    Input:[1,1,2]
//
//    Output:
//    k = 2
//
//    Array:[1,2,_]
    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2};
        int k1 = removeDuplicates(arr1);
        System.out.println("k = " + k1);
        for (int i = 0; i < k1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(arr2);
        System.out.println("k = " + k2);
        for (int i = 0; i < k2; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int[] arr3 = {1};
        int k3 = removeDuplicates(arr3);
        System.out.println("k = " + k3);
        for (int i = 0; i < k3; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        int[] arr4 = {1, 1, 1, 1};
        int k4 = removeDuplicates(arr4);
        System.out.println("k = " + k4);
        for (int i = 0; i < k4; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();

        int[] arr5 = {1, 2, 3, 4};
        int k5 = removeDuplicates(arr5);
        System.out.println("k = " + k5);
        for (int i = 0; i < k5; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
    }
}