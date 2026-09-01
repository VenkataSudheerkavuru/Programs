package LinkedList.medium;

import java.util.*;

class _12_AddOneToNumberLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Add One to a Number Represented by Linked List
     *
     * The linked list represents a non-negative integer.
     * Each node contains one digit.
     *
     * Add 1 to the number and return the resulting linked list.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3
     *
     * Output:
     * 1 -> 2 -> 4
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 9
     *
     * Output:
     * 1 -> 3 -> 0
     *
     * Example 3:
     *
     * Input:
     * 9 -> 9 -> 9
     *
     * Output:
     * 1 -> 0 -> 0 -> 0
     *
     * Example 4:
     *
     * Input:
     * 1
     *
     * Output:
     * 2
     *
     * Example 5:
     *
     * Input:
     * 9
     *
     * Output:
     * 1 -> 0
     *
     * Target:
     * Time  : O(n)
     * Space : O(1) preferred
     *
     * Do not convert the entire number into an int/long.
     */

    public static ListNode addOne(ListNode head) {

        // Reverse the list to make least significant digit accessible
        head = reverseList(head);

        ListNode current = head;
        int carry = 1;

        // Traverse the list and add carry
        while (current != null && carry > 0) {
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;

            // If there's no next node and we still have a carry, append a new node
            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                carry = 0;
            }

            current = current.next;
        }

        // Reverse the list back to restore original order
        head = reverseList(head);
        return head;
    }

    public static ListNode reverseList(ListNode head) {

        // Write your code here
        ListNode prev = null;
        while(head!=null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
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

        ListNode result = addOne(head);

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
            new int[]{1, 2, 3},
            new int[]{1, 2, 4}
        );

        test(
            new int[]{1, 2, 9},
            new int[]{1, 3, 0}
        );

        test(
            new int[]{9, 9, 9},
            new int[]{1, 0, 0, 0}
        );

        test(
            new int[]{1},
            new int[]{2}
        );

        test(
            new int[]{9},
            new int[]{1, 0}
        );

        test(
            new int[]{9, 9, 8},
            new int[]{9, 9, 9}
        );

        test(
            new int[]{4, 9, 9, 9},
            new int[]{5, 0, 0, 0}
        );
    }
}