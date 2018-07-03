package com.example.angel.myapplication;

public class TheRoomProblem {

    public static void main (String args[]){
        System.out.println(factorial(5));
    }

    private static long factorial(int n)
    {
        if (n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }
}
