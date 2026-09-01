package LinkedList.medium;

import java.util.*;

class _08_RemoveNthNodeFromBack {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Remove Nth Node From the End of a Linked List
     *
     * Given the head of a singly linked list and an integer n,
     * remove the nth node from the END of the linked list.
     *
     * Return the head of the modified linked list.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5
     * n = 2
     *
     * Output:
     * 1 -> 2 -> 3 -> 5
     *
     * Explanation:
     * The 2nd node from the end is 4.
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2
     * n = 1
     *
     * Output:
     * 1
     *
     * Example 3:
     *
     * Input:
     * 1
     * n = 1
     *
     * Output:
     * empty list
     *
     * Example 4:
     *
     * Input:
     * 1 -> 2 -> 3
     * n = 3
     *
     * Output:
     * 2 -> 3
     *
     * IMPORTANT:
     * Try to solve it in one traversal.
     *
     * Target:
     * Time  : O(n)
     * Space : O(1)
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        ListNode second = dummy;
        while(first!=null){
            first = first.next;
            second =second.next;
        }
        second.next = second.next.next;


        return dummy.next;
    }


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


    static void test(int[] input, int n, int[] expected) {

        ListNode head = createList(input);

        ListNode result = removeNthFromEnd(head, n);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("n: " + n);
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(toArray(result)));
        }
    }


    public static void main(String[] args) {

        // Remove middle node
        test(
            new int[]{1, 2, 3, 4, 5},
            2,
            new int[]{1, 2, 3, 5}
        );

        // Remove last node
        test(
            new int[]{1, 2, 3},
            1,
            new int[]{1, 2}
        );

        // Remove head
        test(
            new int[]{1, 2, 3},
            3,
            new int[]{2, 3}
        );

        // Single node
        test(
            new int[]{1},
            1,
            new int[]{}
        );

        // Two nodes, remove head
        test(
            new int[]{1, 2},
            2,
            new int[]{2}
        );

        // Two nodes, remove last
        test(
            new int[]{1, 2},
            1,
            new int[]{1}
        );

        // Remove middle
        test(
            new int[]{10, 20, 30, 40, 50},
            3,
            new int[]{10, 20, 40, 50}
        );
    }
}