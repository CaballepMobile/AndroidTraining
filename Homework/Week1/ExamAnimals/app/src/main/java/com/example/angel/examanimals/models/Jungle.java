package com.example.angel.examanimals.models;

import com.example.angel.examanimals.utils.Food;

import java.util.List;
import java.util.Random;

public class Jungle {

    private List<Tiger> _tigers;
    private List<Monkey> _monkeys;
    private List<Snake> _snakes;

    public Jungle(List<Monkey> monkeys, List<Tiger> tigers, List<Snake> snakes) {
        _tigers = tigers;
        _monkeys = monkeys;
        _snakes = snakes;
    }

    public void StartJungle(int iterations) throws InterruptedException {
        while (iterations > 0) {
            LaunchRandomEvent();
            iterations--;
            Thread.sleep(250);
        }
    }

    private void LaunchRandomEvent() {
        int event = GetRandomValue(1, 3);
        switch (event) {
            case 1:
                MakeAnimalEat(GetRandomAnimal(_tigers, _monkeys, _snakes));
                break;
            case 2:
                MakeAnimalMakeASound(GetRandomAnimal(_tigers, _monkeys, _snakes));
                break;
            case 3:
                MakeAnimalSleep(GetRandomAnimal(_tigers, _monkeys, _snakes));
                break;
        }

    }

    private void MakeAnimalEat(Animal animal) {
        System.out.println(animal.Eat(GetRandomFood()));
    }

    private void MakeAnimalSleep(Animal animal) {
        System.out.println(animal.Sleep());
    }

    private void MakeAnimalMakeASound(Animal animal) {
        String sound = animal.MakeSound();
        if(animal.getClass().getName().equals(Monkey.class.getName()) && IsMonkeyCallingToPlay(sound)){
            System.out.println(animal.MakeSound());
            System.out.println("[!] Monkeys are joining the game:");
            for (Monkey monkey : _monkeys) {
                System.out.println(monkey.Play());
            }
            System.out.println("[!] Monkeys finished the game.");
        } else {
            System.out.println(animal.MakeSound());
        }

    }

    private Animal GetRandomAnimal(List<Tiger> tigers, List<Monkey> monkeys, List<Snake> snakes) {
        int random = GetRandomValue(0, 3);
        if (random == 0) {
            return GetRandomTiger(tigers);
        } else if (random == 1) {
            return GetRandomMonkey(monkeys);
        } else {
            return GetRandomSnake(snakes);
        }
    }

    private Tiger GetRandomTiger(List<Tiger> tigers) {
        Tiger tigersArray[] = tigers.toArray(new Tiger[tigers.size()]);
        return tigersArray[GetRandomValue(0, tigers.size())];
    }

    private Monkey GetRandomMonkey(List<Monkey> monkeys) {
        Monkey monkeysArray[] = monkeys.toArray(new Monkey[monkeys.size()]);
        return monkeysArray[GetRandomValue(0, monkeys.size())];
    }

    private Snake GetRandomSnake(List<Snake> snakes) {
        Snake snakesArray[] = snakes.toArray(new Snake[snakes.size()]);
        return snakesArray[GetRandomValue(0, snakes.size())];
    }

    private int GetRandomFood() {
        return GetRandomValue(0, 3);
    }

    private int GetRandomValue(int min, int max) {
        return new Random().nextInt(max) + min;
    }

    private boolean IsMonkeyCallingToPlay(String call){
        for(int i = 0; i < call.length(); i++){
            char value = call.charAt(i);
            if(call.charAt(i) == 60){

                    return true;

            }
        }
        return false;
    }
}

