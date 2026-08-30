package LinkedList.medium;

public class _06_PalindromeLinkedList {

    /*
     * Problem: Check if a Linked List is Palindrome
     *
     * Given the head of a singly linked list, determine whether
     * the linked list reads the same forwards and backwards.
     *
     * Return true if it is a palindrome, otherwise return false.
     *
     * Example 1:
     *
     * Input:
     * 1 -> 2 -> 2 -> 1 -> null
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
     * 1 -> 2 -> 3 -> 2 -> 1 -> null
     *
     * Output:
     * true
     *
     * Example 4:
     *
     * Input:
     * 1 -> null
     *
     * Output:
     * true
     *
     * Approach:
     * Try to solve this with O(n) time and O(1) extra space.
     *
     * Hint:
     * You already know how to:
     *   1. Find the middle using slow/fast pointers.
     *   2. Reverse a linked list.
     *
     * Think about how these two techniques can be combined.
     */

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        
        Node temp = head;

        // Write your code here
        Node middle = findMiddle(head);
        middle = reverseList(middle);
        while(middle!=null){
            if(temp.data != middle.data){
                return false;
            }
            temp = temp.next;
            middle = middle.next;
        }
        

        return true;
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

    static void test(int[] input, boolean expected) {

        Node head = createList(input);

        boolean result = isPalindrome(head);

        if (result == expected) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + result);
        }
    }

    public static void main(String[] args) {

        // Odd number of nodes - palindrome
        test(
            new int[]{1, 2, 3, 2, 1},
            true
        );

        // Even number of nodes - palindrome
        test(
            new int[]{1, 2, 2, 1},
            true
        );

        // Not a palindrome
        test(
            new int[]{1, 2, 3},
            false
        );

        // Single node
        test(
            new int[]{10},
            true
        );

        // Two equal nodes
        test(
            new int[]{5, 5},
            true
        );

        // Two different nodes
        test(
            new int[]{5, 6},
            false
        );

        // Empty list
        test(
            new int[]{},
            true
        );

        // More complex palindrome
        test(
            new int[]{1, 2, 3, 4, 3, 2, 1},
            true
        );
    }
}