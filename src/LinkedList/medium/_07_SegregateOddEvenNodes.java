package LinkedList.medium;

import java.util.*;

class _07_SegregateOddEvenNodes {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem:
     * Rearrange the Linked List so that all nodes at odd positions
     * come first, followed by all nodes at even positions.
     *
     * Odd/even refers to POSITION, not node value.
     *
     * Example:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * Output:
     * 1 -> 3 -> 5 -> 2 -> 4
     *
     * Example:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4
     *
     * Output:
     * 1 -> 3 -> 2 -> 4
     *
     * Time: O(n)
     * Space: O(1)
     */

    public static ListNode oddEvenList(ListNode head) {

        // Write your code here
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }


    // Create Linked List from array
    static ListNode createList(int[] input) {

        if (input.length == 0) {
            return null;
        }

        ListNode head = new ListNode(input[0]);
        ListNode temp = head;

        for (int i = 1; i < input.length; i++) {
            temp.next = new ListNode(input[i]);
            temp = temp.next;
        }

        return head;
    }


    // Compare Linked List with expected array
    static boolean isEqual(ListNode head, int[] expected) {

        int i = 0;

        while (head != null && i < expected.length) {

            if (head.val != expected[i]) {
                return false;
            }

            head = head.next;
            i++;
        }

        return head == null && i == expected.length;
    }


    // Convert Linked List to array for printing
    static int[] toArray(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }


    // Test method
    static void test(int[] input, int[] expected) {

        ListNode head = createList(input);

        ListNode result = oddEvenList(head);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(toArray(result)));
        }
    }


    public static void main(String[] args) {

        test(
                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 3, 5, 2, 4}
        );

        test(
                new int[]{1, 2, 3, 4},
                new int[]{1, 3, 2, 4}
        );

        test(
                new int[]{1, 2},
                new int[]{1, 2}
        );

        test(
                new int[]{1},
                new int[]{1}
        );

        test(
                new int[]{1, 2, 3},
                new int[]{1, 3, 2}
        );

        test(
                new int[]{10, 20, 30, 40, 50, 60},
                new int[]{10, 30, 50, 20, 40, 60}
        );
    }
}