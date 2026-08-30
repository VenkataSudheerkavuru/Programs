package LinkedList.medium;

public class _02_ReverseLinkedList {

    /*
     * Problem: Reverse a Linked List - Iterative
     *
     * Given the head of a singly linked list, reverse the
     * linked list and return the new head.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *
     * Output:
     * 5 -> 4 -> 3 -> 2 -> 1 -> null
     *
     * Example 2:
     *
     * Input:
     * 1 -> 2 -> null
     *
     * Output:
     * 2 -> 1 -> null
     *
     * Example 3:
     *
     * Input:
     * 10 -> null
     *
     * Output:
     * 10 -> null
     *
     * Approach:
     * Reverse the links iteratively using pointers.
     *
     * Think carefully about how to preserve the next node
     * before changing current.next.
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseList(Node head) {

        // Write your code here
        Node prev = null;
        while(head!=null){
            Node curr = head.next;
            head.next = prev;

            prev = head;

            head = curr;
        }


        return prev;
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

    static boolean isEqual(Node head, int[] expected) {

        int index = 0;

        while (head != null && index < expected.length) {
            if (head.data != expected[index]) {
                return false;
            }

            head = head.next;
            index++;
        }

        return head == null && index == expected.length;
    }

    static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    static void test(int[] input, int[] expected) {

        Node head = createList(input);

        Node result = reverseList(head);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");

            System.out.print("Expected: ");
            printList(createList(expected));

            System.out.print("Actual:   ");
            printList(result);
        }
    }

    public static void main(String[] args) {

        // Normal case
        test(
            new int[]{1, 2, 3, 4, 5},
            new int[]{5, 4, 3, 2, 1}
        );

        // Two nodes
        test(
            new int[]{1, 2},
            new int[]{2, 1}
        );

        // Single node
        test(
            new int[]{10},
            new int[]{10}
        );

        // Empty list
        test(
            new int[]{},
            new int[]{}
        );

        // Duplicate values
        test(
            new int[]{1, 2, 2, 3},
            new int[]{3, 2, 2, 1}
        );
    }
}