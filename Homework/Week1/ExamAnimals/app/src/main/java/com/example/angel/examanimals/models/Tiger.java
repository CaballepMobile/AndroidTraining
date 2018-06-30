package com.example.angel.examanimals.models;

import com.example.angel.examanimals.utils.Food;

import java.util.Random;

public class Tiger extends AnimalBase implements Animal{
    public Tiger() {
        super();
    }

    @Override
    public String MakeSound() {
        if(_energy > 3){
            _beforeEnergy = _energy;
            _energy -=3;

            return this.GetPreparedAnimalId() + " is making sounds. (-3) " + "Energy going from: " + _beforeEnergy+" to: "+_energy;
        }
        else{
            return this.GetPreparedAnimalId() + " does not have enough energy to perform a sound. Current Energy: " + _energy;
        }
    }

    @Override
    public String Eat(int foodId) {

        if(foodId == Food.FOOD.Grains){
            return this.GetPreparedAnimalId() + " cannot eat " + Food.FOOD.GetFoodNameById(foodId);
        }else{
            _beforeEnergy = _energy;
            _energy += 5;

            return this.GetPreparedAnimalId() + " is eating " + Food.FOOD.GetFoodNameById(foodId) + ". (+5) " + "Energy going from: " + _beforeEnergy+" to: "+_energy;
        }

    }

    @Override
    public String Sleep() {
        _beforeEnergy = _energy;
        _energy += 5;

        return this.GetPreparedAnimalId() + " is sleeping. (+5) " + "Energy going from: " + _beforeEnergy+" to: "+_energy;
    }
}
