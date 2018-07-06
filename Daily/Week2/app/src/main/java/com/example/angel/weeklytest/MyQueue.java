package com.example.angel.weeklytest;

import java.util.Stack;

public class MyQueue {

    protected Stack<Integer> stack1;
    protected Stack<Integer> stack2;

    /* Function to push an item to stack*/
    private static void push(Stack<Integer> top_ref, int new_data) {
        //Push the data onto the stack
        top_ref.push(new_data);
    }

    /* Function to pop an item from stack*/
    private static int pop(Stack<Integer> top_ref) {
        /*If stack is empty then error */
        if (top_ref.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        //pop the data from the stack
        return top_ref.pop();
    }

    //Function to enqueue an item to the queue
    public static void pushQueue(MyQueue q, int x) {
        push(q.stack1, x);
    }

    //Function to dequeue an item from queue
    public static int pull(MyQueue q) {
        int x;

        if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }

        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
        if (q.stack2.isEmpty()) {
            while (!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);

            }
        }
        x = pop(q.stack2);
        return x;
    }
}