package com.example.angel.examanimals.models;

import com.example.angel.examanimals.utils.Food;

public class Snake extends AnimalBase implements Animal{
    public Snake() {
        super();
    }

    @Override
    public String MakeSound() {
        if(_energy >= 3){
            _beforeEnergy = _energy;
            _energy -=3;

            return this.GetPreparedAnimalId() + " is making sounds. (-3) " + "Energy going from: " + _beforeEnergy+" to "+_energy;
        }
        else{
            return this.GetPreparedAnimalId() + " does not have enough energy to perform a sound. Current Energy: " + _energy;
        }
    }

    @Override
    public String Eat(int foodId) {
        _beforeEnergy = _energy;
        _energy += 5;

        return this.GetPreparedAnimalId() + " is eating (+5) " + Food.FOOD.GetFoodNameById(foodId) + ". " + "Energy going from: " + _beforeEnergy+" to "+_energy;
    }

    @Override
    public String Sleep() {
        _beforeEnergy = _energy;
        _energy += 5;

        return this.GetPreparedAnimalId() + " is sleeping. (+10) " + "Energy going from: " + _beforeEnergy+" to "+_energy;
    }
}