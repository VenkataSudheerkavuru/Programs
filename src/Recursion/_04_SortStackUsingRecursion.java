package Recursion;/*
    Sort a Stack using Recursion

    Given a stack, sort it in ascending order using recursion.

    You are allowed to use only recursion.
    Do not use any sorting algorithm or another stack.

    Example:

    Input:
    [3, 1, 4, 2]

    Output:
    [1, 2, 3, 4]

    Important:
    Think about what happens when we remove the top element.

    Example:

    Stack:
        2  <- top
        4
        1
        3

    If we remove 2, we first recursively sort:

        4
        1
        3

    Then we need to put 2 back in the correct position.

    Hint:
    You will likely need TWO recursive functions:

    1. sortStack()
       → recursively removes elements until the stack is empty

    2. insertSorted()
       → inserts one element into an already sorted stack

    Think about the base cases carefully.
*/

import java.util.*;

class _04_SortStackUsingRecursion {

    static void sortStack(Stack<Integer> stack) {

        // Write your code here

    }

    static void insertSorted(Stack<Integer> stack, int value) {

        // Write your code here

    }

    static void test(Stack<Integer> input, Stack<Integer> expected) {

        Stack<Integer> actual = new Stack<>();
        actual.addAll(input);

        sortStack(actual);

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
                push(3);
                push(1);
                push(4);
                push(2);
            }},
            new Stack<Integer>() {{
                push(1);
                push(2);
                push(3);
                push(4);
            }}
        );

        test(
            new Stack<Integer>() {{
                push(5);
                push(2);
                push(8);
                push(1);
                push(3);
            }},
            new Stack<Integer>() {{
                push(1);
                push(2);
                push(3);
                push(5);
                push(8);
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
                push(3);
                push(3);
                push(1);
                push(2);
                push(2);
            }},
            new Stack<Integer>() {{
                push(1);
                push(2);
                push(2);
                push(3);
                push(3);
            }}
        );
    }
}