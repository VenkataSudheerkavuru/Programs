package LinkedList.easy;

public class _01_ReverseDoublyLinkedList {

    /*
     * Problem:
     *
     * Given the head of a Doubly Linked List,
     * reverse the linked list and return the new head.
     *
     * Example:
     *
     * Before:
     * null <- 1 <-> 2 <-> 3 <-> 4 -> null
     *
     * After:
     * null <- 4 <-> 3 <-> 2 <-> 1 -> null
     *
     * Reverse both prev and next pointers.
     */

    public static Node reverseDLL(Node head) {

        if(head == null)return null;

        // Write your code here
        Node originalHead = head;
        while(head.next!=null){
            head = head.next;
        }
        Node temp = head;

        while(true){
            Node prev = temp.prev;
            Node next = temp.next;
            temp.next = prev;
            temp.prev = next;
            if(temp == originalHead){
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    static class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


    // Helper method to create DLL
    static Node createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }

        return head;
    }


    // Helper method to compare result with expected array
    static boolean isEqual(Node head, int[] expected) {

        int index = 0;
        Node temp = head;

        while (temp != null && index < expected.length) {

            if (temp.data != expected[index]) {
                return false;
            }

            temp = temp.next;
            index++;
        }

        return temp == null && index == expected.length;
    }


    // Test method
    static void test(int[] input, int[] expected) {

        Node head = createList(input);

        Node result = reverseDLL(head);

        if (isEqual(result, expected)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");

            System.out.print("Expected: ");
            printArray(expected);

            System.out.print("Actual:   ");
            printList(result);
        }
    }
    static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }


    public static void main(String[] args) {

        System.out.println("===== Reverse Doubly Linked List =====");

        // Normal case
        test(
                new int[]{1, 2, 3, 4},
                new int[]{4, 3, 2, 1}
        );

        // Two nodes
        test(
                new int[]{10, 20},
                new int[]{20, 10}
        );

        // Single node
        test(
                new int[]{5},
                new int[]{5}
        );

        // Empty list
        test(
                new int[]{},
                new int[]{}
        );

        // Multiple nodes
        test(
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{6, 5, 4, 3, 2, 1}
        );
    }
}