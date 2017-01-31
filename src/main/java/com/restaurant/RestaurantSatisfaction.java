package com.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Rajapandi
 *
 */

public class RestaurantSatisfaction {
    
    @Autowired ResourceLoader resourceLoader;
    
    public Integer parseResturantMenu() {
        
        final String INPUT_FILE_PATH = "restaurant_menu_time.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(INPUT_FILE_PATH).getFile());
        List<Food> foodList = new ArrayList<Food>();
        FoodFileParser foodFileParser = new FoodFileParser(file.getPath());
        
        try {
            foodList = foodFileParser.fileToFoodList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(INPUT_FILE_PATH+" File Not Found");
        }
        
        List<Integer> satisfactionList = new ArrayList<Integer>();
        List<Integer> timeList = new ArrayList<Integer>();
        
        for (Food eachFood : foodList) {
            satisfactionList.add(eachFood.getSatisfaction());
            timeList.add(eachFood.getTimeTaken());
        }
        
       
        
        for (int i = 0; i < timeList.size(); i++) {
            System.out.println("dishSatisfaction["+satisfactionList.get(i)+"] -- timeToEatForDish"+i++ +"["+timeList.get(i)+"]");
        }
        
        System.out.println("=================================");
        
        FoodSatisfaction  foodSatisfaction = new FoodSatisfaction();
        int maxValue = foodSatisfaction.findMaxSatisfaction(
                satisfactionList, timeList, foodFileParser.getMaxTime(), foodFileParser.getFoodCount());
        
        System.out.println("Maximum satisfaction is : " + maxValue);
       return maxValue; 
    }
    
    
    
}

