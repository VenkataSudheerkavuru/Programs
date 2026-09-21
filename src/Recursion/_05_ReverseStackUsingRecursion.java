package Recursion;/*
    Reverse a Stack using Recursion

    Given a stack, reverse it using recursion.

    You are NOT allowed to use another stack.

    Example:

    Input:
        [1, 2, 3, 4]
        4 is the top

    Output:
        [4, 3, 2, 1]
        1 is the top

    Hint:

    1. Pop the top element.
    2. Recursively reverse the remaining stack.
    3. Insert the popped element at the BOTTOM of the stack.

    You will need a helper method:

        insertAtBottom(stack, value)

    Example:

        Stack = [1, 2, 3]
        top = 3

        After reversing [1, 2]:
        [2, 1]

        Now insert 3 at the bottom:
        [3, 2, 1]
*/

import java.util.*;

class _05_ReverseStackUsingRecursion {

    static void reverseStack(Stack<Integer> st) {

        if (st.isEmpty()) return;

        // hold the top element and remove it
        int top = st.pop();

        // reverse the remaining stack
        reverseStack(st);

        // insert the held element at the bottom
        insertAtBottom(st, top);

    }

    static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // hold the top element and remove it
        int top = st.pop();

        // recursively call to reach the bottom
        insertAtBottom(st, x);

        st.push(top);
    }


    static void test(Stack<Integer> input, Stack<Integer> expected) {

        Stack<Integer> actual = new Stack<>();
        actual.addAll(input);

        reverseStack(actual);

        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + input);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    public static void main(String[] args) {

        test(
            new Stack<Integer>() {{
                push(1);
                push(2);
                push(3);
                push(4);
            }},
            new Stack<Integer>() {{
                push(4);
                push(3);
                push(2);
                push(1);
            }}
        );

        test(
            new Stack<Integer>() {{
                push(1);
                push(2);
                push(3);
            }},
            new Stack<Integer>() {{
                push(3);
                push(2);
                push(1);
            }}
        );

        test(
            new Stack<Integer>() {{
                push(1);
            }},
            new Stack<Integer>() {{
                push(1);
            }}
        );

        test(
            new Stack<Integer>(),
            new Stack<Integer>()
        );

        test(
            new Stack<Integer>() {{
                push(1);
                push(1);
                push(2);
                push(2);
            }},
            new Stack<Integer>() {{
                push(2);
                push(2);
                push(1);
                push(1);
            }}
        );
    }
}