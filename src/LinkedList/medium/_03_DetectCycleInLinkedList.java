package LinkedList.medium;

import LinkedList.easy._01_ReverseDoublyLinkedList;

public class _03_DetectCycleInLinkedList {

    /*
     * Problem: Detect a Cycle in a Linked List
     *
     * Given the head of a singly linked list, determine whether
     * the linked list contains a cycle (loop).
     *
     * A cycle exists when a node's next pointer points back to
     * a previous node instead of becoming null.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4
     *           ↑    |
     *           |____|
     *
     * Output:
     * true
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 3 -> null
     *
     * Output:
     * false
     *
     * Example 3:
     *
     * Input:
     * 1 -> null
     *
     * Output:
     * false
     *
     * Approach:
     * Try to solve this using the Tortoise and Hare method
     * (slow and fast pointers).
     *
     * Think about what happens if there is a cycle:
     * will slow and fast pointers eventually meet?
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }
        if(head == head.next) return true;

        Node temp = head;
        Node temp2 = head;

        while (temp2 != null && temp2.next != null) {

            temp = temp.next;
            temp2 = temp2.next.next;

            if (temp == temp2) {
                return true;
            }
        }

        return false;
    }

    // Creates a normal linked list.
    static Node createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    /*
     * Creates a cycle by connecting the last node to the node
     * at cycleIndex.
     *
     * Example:
     *
     * [1, 2, 3, 4], cycleIndex = 1
     *
     * 1 -> 2 -> 3 -> 4
     *      ↑         |
     *      |_________|
     */
    static Node createListWithCycle(int[] arr, int cycleIndex) {

        Node head = createList(arr);

        if (head == null || cycleIndex < 0) {
            return head;
        }

        Node cycleNode = null;
        Node temp = head;

        int index = 0;

        while (temp.next != null) {

            if (index == cycleIndex) {
                cycleNode = temp;
            }

            temp = temp.next;
            index++;
        }

        // Handle the last node as a possible cycle node
        if (index == cycleIndex) {
            cycleNode = temp;
        }

        temp.next = cycleNode;

        return head;
    }

    static void test(Node head, boolean expected) {

        boolean result = hasCycle(head);

        if (result == expected) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + result);
        }
    }

    public static void main(String[] args) {

        // No cycle
        test(
            createList(new int[]{1, 2, 3, 4}),
            false
        );

        // Cycle starts at node 2
        test(
            createListWithCycle(new int[]{1, 2, 3, 4}, 1),
            true
        );

        // Cycle starts at head
        test(
            createListWithCycle(new int[]{1, 2, 3, 4}, 0),
            true
        );

        // Single node without cycle
        test(
            createList(new int[]{10}),
            false
        );

        // Single node pointing to itself
        test(
            createListWithCycle(new int[]{10}, 0),
            true
        );

        // Empty list
        test(
            createList(new int[]{}),
            false
        );
    }
}