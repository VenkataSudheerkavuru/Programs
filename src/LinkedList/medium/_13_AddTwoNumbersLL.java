package LinkedList.medium;

import java.util.*;

class _13_AddTwoNumbersLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Add Two Numbers Represented by Linked Lists
     *
     * Each linked list represents a number.
     * Each node contains one digit.
     *
     * Add the two numbers and return the result as a linked list.
     *
     * Example 1:
     *
     * Input:
     * 2 -> 4 -> 3
     * 5 -> 6 -> 4
     *
     * Output:
     * 7 -> 0 -> 8
     *
     * Explanation:
     * 243 + 564 = 807
     *
     * Example 2:
     *
     * Input:
     * 9 -> 9 -> 9
     * 1
     *
     * Output:
     * 1 -> 0 -> 0 -> 0
     *
     * Explanation:
     * 999 + 1 = 1000
     *
     * Example 3:
     *
     * Input:
     * 1 -> 2 -> 3
     * 4 -> 5
     *
     * Output:
     * 1 -> 6 -> 8
     *
     * Explanation:
     * 123 + 45 = 168
     *
     * Example 4:
     *
     * Input:
     * 0
     * 0
     *
     * Output:
     * 0
     *
     * Target:
     * Time  : O(max(n, m))
     * Space : O(max(n, m)) for the result
     *
     * Think carefully about:
     * - Different list lengths
     * - Carry
     * - Carry remaining after both lists end
     */

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        list1 = reverseList(list1);
        list2 = reverseList(list2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while (list1 != null || list2 != null) {

            int sum = carry;

            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            carry = sum / 10;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return reverseList(dummy.next);
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
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


    static void test(
            int[] input1,
            int[] input2,
            int[] expected) {

        ListNode list1 = createList(input1);
        ListNode list2 = createList(input2);

        ListNode result = addTwoNumbers(list1, list2);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Input 1: " + Arrays.toString(input1));
            System.out.println("Input 2: " + Arrays.toString(input2));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(toArray(result)));
        }
    }


    public static void main(String[] args) {

        // Normal addition
        test(
            new int[]{2, 4, 3},
            new int[]{5, 6, 4},
            new int[]{8, 0, 7}
        );

        // Different lengths + final carry
        test(
            new int[]{9, 9, 9},
            new int[]{1},
            new int[]{1, 0, 0, 0}
        );

        // Different lengths
        test(
            new int[]{1, 2, 3},
            new int[]{4, 5},
            new int[]{1, 6, 8}
        );

        // Zero
        test(
            new int[]{0},
            new int[]{0},
            new int[]{0}
        );

        // Carry in middle
        test(
            new int[]{9, 9},
            new int[]{1},
            new int[]{1, 0, 0}
        );

        // One list longer
        test(
                new int[]{9, 8, 7, 6},
                new int[]{5, 4},
                new int[]{9, 9, 3, 0}
        );
    }
}