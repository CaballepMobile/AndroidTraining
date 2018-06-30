package com.example.angel.examanimals.utils;

public class Food {
    public static class FOOD{
        public static int Meat = 0;
        public static int Fish = 1;
        public static int Grains = 2;
        public static int Bugs = 3;

        public static String GetFoodNameById(int foodId){
            String foodName = "";
            switch (foodId){
                case 0:
                    foodName = "Meat";
                    break;
                case 1:
                    foodName = "Fish";
                    break;
                case 2:
                    foodName = "Grains";
                    break;
                case 3:
                    foodName = "Bugs";
                    break;
            }
            return foodName;
        }
    }
}
