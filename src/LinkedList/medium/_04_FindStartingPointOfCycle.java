package LinkedList.medium;

public class _04_FindStartingPointOfCycle {

    /*
     * Problem: Find the Starting Point of a Cycle in a Linked List
     *
     * Given the head of a singly linked list, determine whether
     * the linked list contains a cycle.
     *
     * If a cycle exists, return the node where the cycle begins.
     * If there is no cycle, return null.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5
     *           ↑         |
     *           |_________|
     *
     * Output:
     * 3
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 3 -> null
     *
     * Output:
     * null
     *
     * Example 3:
     *
     * Input:
     * 1 -> 2
     *      ↑ |
     *      |_|
     *
     * Output:
     * 2
     *
     * Approach:
     * Use Floyd's Tortoise and Hare algorithm.
     *
     * First, detect whether slow and fast meet.
     * If they meet, think about what you should do with
     * the slow pointer and the head pointer to find the
     * START of the cycle.
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node findCycleStart(Node head) {

        if (head == null) {
            return null;
        }
        if(head == head.next) return head;

        Node temp = head;
        Node temp2 = head;

        while (temp2 != null && temp2.next != null) {

            temp = temp.next;
            temp2 = temp2.next.next;

            if (temp == temp2) {

                temp = head;

                while (temp != temp2) {
                    temp = temp.next;
                    temp2 = temp2.next;
                }

                return temp;
            }
        }

        return null;
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

        // Handle last node as cycle starting point
        if (index == cycleIndex) {
            cycleNode = temp;
        }

        temp.next = cycleNode;

        return head;
    }

    static void test(Node head, Integer expected) {

        Node result = findCycleStart(head);

        if ((result == null && expected == null) ||
            (result != null && result.data == expected)) {

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

        // Cycle starts at 3
        test(
            createListWithCycle(new int[]{1, 2, 3, 4, 5}, 2),
            3
        );

        // Cycle starts at head
        test(
            createListWithCycle(new int[]{1, 2, 3, 4}, 0),
            1
        );

        // Cycle starts at last node
        test(
            createListWithCycle(new int[]{1, 2, 3}, 2),
            3
        );

        // Single node pointing to itself
        test(
            createListWithCycle(new int[]{10}, 0),
            10
        );

        // No cycle
        test(
            createList(new int[]{1, 2, 3, 4}),
            null
        );

        // Empty list
        test(
            createList(new int[]{ }),
            null
        );
    }
}