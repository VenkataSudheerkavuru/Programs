package BinarySerach.on_answers;

public class _07_BookAllocation {

    /*
     * Problem:
     *
     * You are given an array where pages[i] represents the
     * number of pages in the i-th book.
     *
     * You have m students.
     *
     * Allocate all books among the students such that:
     *
     * - Every student gets at least one book.
     * - Books must be allocated in contiguous order.
     * - A book cannot be split between students.
     *
     * Your goal is to MINIMIZE the maximum number of pages
     * assigned to any one student.
     *
     * Example:
     *
     * pages = [12,34,67,90]
     * students = 2
     *
     * Possible allocation:
     *
     * Student 1 → [12,34,67] = 113
     * Student 2 → [90]       = 90
     *
     * Maximum = 113
     *
     * Another allocation:
     *
     * Student 1 → [12,34] = 46
     * Student 2 → [67,90] = 157
     *
     * Maximum = 157
     *
     * So the answer is 113.
     *
     * If the number of books is less than the number of
     * students, return -1.
     */

    public static int findPages(int[] pages, int students) {

        // Write your code here
        int min = 0;
        int max = 0;
        int ans = 0;
        if(students > pages.length) return -1;
        for(int i : pages){
            min = Math.max(i,min);
            max += i;
        }
        while(min <= max){
            int mid = min + (max-min)/2;
            int temp = 1;
            int sum = 0;
            for(int i : pages){
                sum += i;
                if(sum > mid){
                    temp++;
                    sum = i;
                }
            }
            if(temp <= students){
                ans = mid;
                max = mid-1;
            }else {
                min =mid+1;
            }
        }

        return ans;
    }

    private static void test(int[] pages, int students, int expected) {

        int result = findPages(pages, students);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Book Allocation =====");

        test(new int[]{12,34,67,90}, 2, 113);

        test(new int[]{10,20,30,40}, 2, 60);

        test(new int[]{25,46,28,49,24}, 4, 71);

        test(new int[]{10,20,30}, 4, -1);

        test(new int[]{100}, 1, 100);
    }
}