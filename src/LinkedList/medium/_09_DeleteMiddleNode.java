package LinkedList.medium;

import java.util.*;

class _09_DeleteMiddleNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Delete the Middle Node of a Linked List
     *
     * Given the head of a singly linked list, delete the middle
     * node and return the head of the modified list.
     *
     * For an even-length list, delete the SECOND middle node.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * Output:
     * 1 -> 2 -> 4 -> 5
     *
     * Explanation:
     * 3 is the middle node, so it is deleted.
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4
     *
     * Output:
     * 1 -> 2 -> 4
     *
     * Explanation:
     * The middle nodes are 2 and 3.
     * Delete the SECOND middle node, 3.
     *
     * Example 3:
     *
     * Input:
     * 1 -> 2 -> 3
     *
     * Output:
     * 1 -> 2
     *
     * Example 4:
     *
     * Input:
     * 1
     *
     * Output:
     * Empty list
     *
     * Target:
     * Time  : O(n)
     * Space : O(1)
     *
     * Try to solve this using slow and fast pointers.
     */

    public static ListNode deleteMiddle(ListNode head) {

        // Write your code here
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
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


    static void test(int[] input, int[] expected) {

        ListNode head = createList(input);

        ListNode result = deleteMiddle(head);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(toArray(result)));
        }
    }


    public static void main(String[] args) {

        // Odd length
        test(
            new int[]{1, 2, 3, 4, 5},
            new int[]{1, 2, 4, 5}
        );

        // Even length - delete second middle
        test(
            new int[]{1, 2, 3, 4},
            new int[]{1, 2, 4}
        );

        // Three nodes
        test(
            new int[]{1, 2, 3},
            new int[]{1, 3}
        );

        // Two nodes - delete second middle
        test(
            new int[]{1, 2},
            new int[]{1}
        );

        // Single node
        test(
            new int[]{1},
            new int[]{}
        );
    }
}