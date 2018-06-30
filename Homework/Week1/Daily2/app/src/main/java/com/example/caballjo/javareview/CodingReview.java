package com.example.caballjo.javareview;

//The proof I did try so many things is all the packages I ended not using:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CodingReview {

    public static void main(String[] args){

        String newline = System.getProperty("line.separator");

        //////////////////////////////////////////////////////////////////
        System.out.println(newline + "First Problem: " + newline);

        List<String> names = new ArrayList<>();
        names.add("Object1");
        names.add("Object1");
        names.add("Object1");
        names.add("Object2");
        names.add("Object2");
        names.add("Object3");
        names.add("Object4");
        names.add("Object5");
        names.add("Object5");

        FindDuplicates(names);

        //////////////////////////////////////////////////////////////////
        System.out.println(newline + "Second Problem" + newline);

        String possiblePalindrome1 = "ABCDEEDCBA"; //Pair palindrome
        String possiblePalindrome2 = "ABCDEDCBA"; //Unpair palindrome
        String possiblePalindrome3 = "ABCDECBA"; //Not a palindrome

        IsAPalindrome(possiblePalindrome1);
        IsAPalindrome(possiblePalindrome2);
        IsAPalindrome(possiblePalindrome3);

        //////////////////////////////////////////////////////////////////
        System.out.println(newline + "Third Problem" + newline);

        DivisibleHelper(18); //fizz
        DivisibleHelper(50); //buzz
        DivisibleHelper(15); //fizz(both)
        DivisibleHelper(17); //print value

        //////////////////////////////////////////////////////////////////
        System.out.println(newline + "Fourth Problem" + newline);

        String word1A = "ABCD", word1B = "BCDA";
        String word2A = "ABCD", word2B = "BCHA";

        AreAnagrams(word1A, word1B);
        AreAnagrams(word2A, word2B);

        //////////////////////////////////////////////////////////////////
        System.out.println(newline + "Fifth Problem" + newline);

        MultiplicationTable();
    }

    //Problem 1
    private static void FindDuplicates(List<String> items){

        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (String value : items)
        {
            if (!set.add(value))
            {
                result.add(value);
            }
        }
        System.out.println(result);
    }

    //Problem 2
    private static void IsAPalindrome(String word){
        int rightCharPos = word.length()-1;
        for(int leftCharPos = 0; leftCharPos < word.length(); leftCharPos++){

            if(rightCharPos >= leftCharPos){
                if(word.charAt(leftCharPos) == word.charAt(rightCharPos)){
                    rightCharPos--;
                }else{
                    System.out.println("It is not a Palindrome");
                    break;
                }
            }else{
                System.out.println("It is a Palindrome");
                break;
            }
        }
    }

    //Problem 3
    private static void DivisibleHelper(int value){

        if(value%3==0 && value%5==0){
            System.out.println("fizz (both)");
        }
        else if(value%3==0){
            System.out.println("fizz");
        }
        else if(value%5==0){
            System.out.println("buzz");
        }
        else{
            System.out.println(value);
        }
    }

    //Problem 4
    private static void AreAnagrams(String word1, String word2){

        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();

        Arrays.sort(letters1);
        Arrays.sort(letters2);

        if(Arrays.equals(letters1, letters2)){
            System.out.println("It is an Anagram");
        }else{
            System.out.println("It is not an Anagram");
        }
    }

    //Problem 5
    private static void MultiplicationTable(){
        int X = 10, Y = 10;

        int[][] matrix = new int[X][Y];
        for (int i = 0; i < X; i++){
            for (int e = 0; e < Y; e++){
                matrix[i][e] = (i+1)*(e+1);
            }
        }


        //Printing
        for (int i = 0; i < X; i++){
            String line = "";
            for (int e = 0; e < Y; e++){
                line += matrix[i][e] + ", ";
            }
            System.out.println(line);
        }
    }
}