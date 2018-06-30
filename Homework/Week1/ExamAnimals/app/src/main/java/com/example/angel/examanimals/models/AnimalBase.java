package com.example.angel.examanimals.models;

import java.util.Random;

public abstract class AnimalBase {

    protected int _energy;
    protected int _beforeEnergy;
    protected String _id;

    public AnimalBase(){

        //Giving some random energy to animals
        if(this.getClass().getName().equals(Monkey.class.getName())){
            //Monkeys uses a lot of Energy cause one call to play all the others, that's why Im giving them more energy:
            _energy = new Random().nextInt(15)+25;
        }else{
            _energy = new Random().nextInt(5)+10;
        }
        _id = SelfIdGenerator();
    }

    //This is not fancy, very basic
    private String SelfIdGenerator(){
        String newId = "";
        for (int i = 0; i < 5; i++){
            //From A to Z
            newId += (char)(new Random().nextInt(26)+'a');
        }

        return newId;
    }

    protected String GetPreparedAnimalId(){
        String animalNameClass = "";
        if(this.getClass().getName().equals(Monkey.class.getName())){
            animalNameClass = "Monkey";
        }else if(this.getClass().getName().equals(Snake.class.getName())){
            animalNameClass = " Snake";
        }else if(this.getClass().getName().equals(Tiger.class.getName())){
            animalNameClass = " Tiger";
        }
        return animalNameClass + "_" + _id;
    }
}
