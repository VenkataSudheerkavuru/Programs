package LinkedList.medium;

import java.util.*;

class _10_SortLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Sort a Linked List
     *
     * Given the head of a singly linked list, sort the list
     * in ascending order.
     *
     * Example 1:
     *
     * Input:
     * 4 -> 2 -> 1 -> 3
     *
     * Output:
     * 1 -> 2 -> 3 -> 4
     *
     * Example 2:
     *
     * Input:
     * -1 -> 5 -> 3 -> 4 -> 0
     *
     * Output:
     * -1 -> 0 -> 3 -> 4 -> 5
     *
     * Example 3:
     *
     * Input:
     * 1
     *
     * Output:
     * 1
     *
     * Example 4:
     *
     * Input:
     * 3 -> 3 -> 1 -> 2
     *
     * Output:
     * 1 -> 2 -> 3 -> 3
     *
     * Target:
     * Time  : O(n log n)
     * Space : O(log n) due to recursion
     *
     * Try to solve using Merge Sort.
     */

    public static ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        // Create a dummy ListNode
        ListNode dummyListNode = new ListNode(-1);

        // Temp pointer to build merged list
        ListNode temp = dummyListNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller ListNode
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining ListNodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyListNode.next;
    }

    // Function to find middle of linked list
    public static ListNode findMiddle(ListNode head) {
        // If list empty or single ListNode
        if (head == null || head.next == null) {
            return head;
        }

        // Slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return middle ListNode
        return slow;
    }

    // Function to perform merge sort
    public static ListNode sortList(ListNode head) {
        // Base case: empty or single ListNode
        if (head == null || head.next == null) {
            return head;
        }
        // Find middle node
        ListNode middle = findMiddle(head);

        // Split into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge sorted halves
        return mergeTwoSortedLinkedLists(left, right);
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

        ListNode result = sortList(head);

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

        test(
            new int[]{4, 2, 1, 3},
            new int[]{1, 2, 3, 4}
        );

        test(
            new int[]{-1, 5, 3, 4, 0},
            new int[]{-1, 0, 3, 4, 5}
        );

        test(
            new int[]{1},
            new int[]{1}
        );

        test(
            new int[]{3, 3, 1, 2},
            new int[]{1, 2, 3, 3}
        );

        test(
            new int[]{5, 4, 3, 2, 1},
            new int[]{1, 2, 3, 4, 5}
        );

        test(
            new int[]{},
            new int[]{}
        );
    }
}