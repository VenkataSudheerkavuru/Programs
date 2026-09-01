package LinkedList.medium;

import java.util.*;

class _11_IntersectionPointOfYLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * Problem: Find the Intersection Point of Two Linked Lists
     *
     * Two singly linked lists form a Y shape. They may share some
     * nodes from a certain point onward.
     *
     * Return the node where the two linked lists intersect.
     * If they do not intersect, return null.
     *
     * IMPORTANT:
     * Intersection means the SAME NODE (same reference),
     * not two nodes having the same value.
     *
     * Example 1:
     *
     * List A:
     * 1 -> 2 \
     *          6 -> 7
     * 3 -> 4 /
     *
     * List B:
     * 3 -> 4 -> 6 -> 7
     *
     * Intersection = node 6
     *
     * Example 2:
     *
     * A: 1 -> 2 -> 3
     * B: 4 -> 5
     *
     * Output:
     * null
     *
     * Example 3:
     *
     * A: 1 -> 2 -> 3
     * B: 9 -> 2 -> 3
     *
     * If the 2 nodes are different objects with the same value,
     * there is NO intersection.
     *
     * Target:
     * Time  : O(n + m)
     * Space : O(1)
     *
     * Try to solve without calculating the lengths first.
     */

    public static ListNode getIntersectionNode(
            ListNode headA,
            ListNode headB) {

        // Write your code here
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }


    static void test(ListNode headA, ListNode headB, ListNode expected) {

        ListNode result = getIntersectionNode(headA, headB);

        if (result == expected) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");

            System.out.println(
                "Expected: " +
                (expected == null ? "null" : expected.val)
            );

            System.out.println(
                "Actual: " +
                (result == null ? "null" : result.val)
            );
        }
    }


    public static void main(String[] args) {

        // Test 1:
        //
        // A: 1 -> 2 \
        //             6 -> 7
        // B: 3 -> 4 /
        //
        // Intersection = 6

        ListNode common1 = new ListNode(6);
        common1.next = new ListNode(7);

        ListNode headA1 = new ListNode(1);
        headA1.next = new ListNode(2);
        headA1.next.next = common1;

        ListNode headB1 = new ListNode(3);
        headB1.next = new ListNode(4);
        headB1.next.next = common1;

        test(headA1, headB1, common1);


        // Test 2:
        //
        // A: 1 -> 2 -> 3
        // B: 4 -> 5
        //
        // No intersection

        ListNode headA2 = new ListNode(1);
        headA2.next = new ListNode(2);
        headA2.next.next = new ListNode(3);

        ListNode headB2 = new ListNode(4);
        headB2.next = new ListNode(5);

        test(headA2, headB2, null);


        // Test 3:
        //
        // Both lists intersect at the first node

        ListNode common3 = new ListNode(10);
        common3.next = new ListNode(20);

        test(common3, common3, common3);


        // Test 4:
        //
        // One list is completely inside the other

        ListNode common4 = new ListNode(30);
        common4.next = new ListNode(40);
        common4.next.next = new ListNode(50);

        ListNode headA4 = new ListNode(10);
        headA4.next = new ListNode(20);
        headA4.next.next = common4;

        test(headA4, common4, common4);


        // Test 5:
        //
        // Same values but different nodes -> NOT intersection

        ListNode headA5 = new ListNode(1);
        headA5.next = new ListNode(2);

        ListNode headB5 = new ListNode(1);
        headB5.next = new ListNode(2);

        test(headA5, headB5, null);
    }
}