package com.example.angel.weeklytest;

import java.util.Stack;

public class TestMainMethodHere {
    public static void main(String[] args){
        //My Queue
        MyQueue q = new MyQueue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        q.enQueue(q, 1);
        q.enQueue(q, 2);
        q.enQueue(q, 3);

        /* Dequeue items */
        System.out.print(q.deQueue(q) + " ");
        System.out.print(q.deQueue(q) + " ");
        System.out.println(q.deQueue(q) + " ");
    }
}
