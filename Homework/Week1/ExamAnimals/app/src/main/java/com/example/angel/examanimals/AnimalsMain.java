package com.example.angel.examanimals;

import com.example.angel.examanimals.models.Jungle;
import com.example.angel.examanimals.models.Monkey;
import com.example.angel.examanimals.models.Snake;
import com.example.angel.examanimals.models.Tiger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalsMain {
    public static void main(String args[]) throws InterruptedException {

        System.out.println("Starting");
        List<Monkey> monkeys = new ArrayList<>();
        List<Snake> snakes = new ArrayList<>();
        List<Tiger> tigers = new ArrayList<>();

        //Filling randomly
        for (int i = 0; i < new Random().nextInt(5)+3; i++){
            monkeys.add(new Monkey());
        }

        for (int i = 0; i < new Random().nextInt(8)+3; i++){
            snakes.add(new Snake());
        }

        for (int i = 0; i < new Random().nextInt(6)+3; i++){
            tigers.add(new Tiger());
        }

        Jungle jungle = new Jungle(monkeys, tigers, snakes);

        //This is to set how much random things are going to happen inside the jungle
        jungle.StartJungle(25);
    }
}
