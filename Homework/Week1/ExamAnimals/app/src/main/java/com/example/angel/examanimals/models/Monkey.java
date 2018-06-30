package com.example.angel.examanimals.models;

import com.example.angel.examanimals.utils.Food;

import java.util.Random;

public class Monkey extends AnimalBase implements Animal {
    public Monkey() {
        super();
    }

    @Override
    public String MakeSound() {
        if(_energy >= 4){
            _beforeEnergy = _energy;
            _energy -=4;


            //Sometimes Monkeys will just do its regular sound (Costs 4 energy)
            //Also there is another sound to call the other monkeys to play which means all of them will use 8 Energy (this what I understood)
            int random = new Random().nextInt(2);
            if(random == 0){
                return this.GetPreparedAnimalId() + " is making sounds. " + "Energy going from: " + _beforeEnergy+" to "+_energy;
            }else{
                return this.GetPreparedAnimalId() + " is calling other monkeys to play <Oooo Oooo Oooo>. " + "Energy going from: " + _beforeEnergy+" to "+_energy;
            }
        }
        else{
            return this.GetPreparedAnimalId() + " does not have enough energy to perform a sound. Current Energy: " + _energy;
        }
    }

    @Override
    public String Eat(int foodId) {
        _beforeEnergy = _energy;
        _energy += 2;

        return this.GetPreparedAnimalId() + " is eating (+2) " + Food.FOOD.GetFoodNameById(foodId) + ". " + "Energy going from: " + _beforeEnergy+" to "+_energy;
    }

    @Override
    public String Sleep() {
        _beforeEnergy = _energy;
        _energy += 10;

        return this.GetPreparedAnimalId() + " is sleeping. (+10) " + "Energy going from: " + _beforeEnergy+" to "+_energy;
    }

    public String Play(){
        if(_energy >= 8){
            _beforeEnergy = _energy;
            _energy -= 8;

            return this.GetPreparedAnimalId() + " is playing. (-8) " + "Energy going from: " + _beforeEnergy+" to "+_energy;
        }
        else{
            return this.GetPreparedAnimalId() + " does not have enough energy to play with the other monkeys. Current Energy: " + _energy;
        }
    }
}
