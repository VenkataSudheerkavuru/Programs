package LinkedList.medium;

public class _01_MiddleOfLinkedList {

    /*
     * Problem: Middle of a Linked List
     *
     * Given the head of a singly linked list, find and return
     * the middle node of the linked list.
     *
     * If the linked list has two middle nodes, return the
     * SECOND middle node.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *
     * Output:
     * 3
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
     *
     * Output:
     * 4
     *
     * Explanation:
     * For an even-sized list, 3 and 4 are the two middle nodes.
     * We return the second middle node, which is 4.
     *
     * Approach to try:
     * Use the Tortoise and Hare (slow and fast pointer) method.
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node findMiddle(Node head) {

        if(head == null || head.next ==null) return head;
        // Initialize the slow pointer to the head.
        Node slow = head;

        // Initialize the fast pointer to the head.
        Node fast = head;

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null) {
            // Move fast two steps.
            fast = fast.next.next;
            // Move slow one step.
            slow = slow.next;
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;
    }

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

    static void test(int[] input, int expected) {

        Node head = createList(input);

        Node result = findMiddle(head);

        if (result != null && result.data == expected) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");

            System.out.println("Expected: " + expected);

            if (result == null) {
                System.out.println("Actual: null");
            } else {
                System.out.println("Actual: " + result.data);
            }
        }
    }

    public static void main(String[] args) {

        // Odd number of nodes
        test(new int[]{1, 2, 3, 4, 5}, 3);

        // Even number of nodes
        // Two middle nodes: 3 and 4
        // Expected: second middle = 4
        test(new int[]{1, 2, 3, 4, 5, 6}, 4);

        // Two nodes
        test(new int[]{1, 2}, 2);

        // Single node
        test(new int[]{10}, 10);
    }
}