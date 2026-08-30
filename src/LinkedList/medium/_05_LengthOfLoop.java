package LinkedList.medium;

public class _05_LengthOfLoop {

    /*
     * Problem: Length of Loop in a Linked List
     *
     * Given the head of a singly linked list, find the length
     * of the cycle (loop) if one exists.
     *
     * If there is no cycle, return 0.
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
     * Explanation:
     * The loop is:
     * 3 -> 4 -> 5 -> 3
     *
     * Therefore, loop length = 3.
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> 3 -> null
     *
     * Output:
     * 0
     *
     * Example 3:
     *
     * Input:
     * 1 -> 2
     *      ↑ |
     *      |_|
     *
     * Output:
     * 1
     *
     * Approach:
     * Use slow and fast pointers to detect the cycle.
     *
     * Once slow and fast meet, keep one pointer at the meeting
     * point and move it around the cycle until it reaches the
     * same node again.
     *
     * Count how many steps it takes.
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static int lengthOfLoop(Node head) {

        // Write your code here
        if (head == null) {
            return 0;
        }
        if(head == head.next) return 1;

        Node temp = head;
        Node temp2 = head;
        int n = 0;

        while (temp2 != null && temp2.next != null) {

            temp = temp.next;
            temp2 = temp2.next.next;

            if (temp == temp2) {

                n = 1;
                temp2 = temp2.next;

                while (temp != temp2) {
                    temp2 = temp2.next;
                    n++;
                }

                return n;
            }
        }

        return 0;
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

        if (index == cycleIndex) {
            cycleNode = temp;
        }

        temp.next = cycleNode;

        return head;
    }

    static void test(Node head, int expected) {

        int result = lengthOfLoop(head);

        if (result == expected) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + result);
        }
    }

    public static void main(String[] args) {

        // Loop: 3 -> 4 -> 5 -> 3
        // Length = 3
        test(
            createListWithCycle(new int[]{1, 2, 3, 4, 5}, 2),
            3
        );

        // Loop starts at head
        // 1 -> 2 -> 3 -> 1
        // Length = 3
        test(
            createListWithCycle(new int[]{1, 2, 3}, 0),
            3
        );

        // Single node pointing to itself
        // Length = 1
        test(
            createListWithCycle(new int[]{10}, 0),
            1
        );

        // No cycle
        test(
            createList(new int[]{1, 2, 3, 4}),
            0
        );

        // Empty list
        test(
            createList(new int[]{}),
            0
        );
    }
}