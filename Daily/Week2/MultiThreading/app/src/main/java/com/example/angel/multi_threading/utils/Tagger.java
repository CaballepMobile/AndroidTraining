package com.example.angel.multi_threading.utils;

public class Tagger {
    public static String get(Object object){
        return object.getClass().getSimpleName() + "_TAG";
    }
}