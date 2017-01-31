package com.restaurant;

import java.io.BufferedReader;
import java.io.FileReader;

/**This class used to read the file and calculate the maximum satisfaction for the given menu items
 * 
 * @author rajapandi
 *
 */
public class RestaurantSatisfaction {
	
	
	public void readFileAndCalculateSatisfaction(){
	    BufferedReader br=null;
		try{
		    br = new BufferedReader(new FileReader("src/main/resources/restaurant_menu_time.txt"));
			 String text = br.readLine();
			 System.out.println(text);
			 System.out.println("========================");
			 String[] timeAndmenuItems = text.split(" ");
			 Integer totalAmountOfTime = Integer.valueOf(timeAndmenuItems[1]);
		     Integer totalMenuItems= Integer.valueOf(timeAndmenuItems[0]); 
		     Integer avarageTimeForAllDishes = totalAmountOfTime/totalMenuItems;
		     Integer dishSatisfaction = null;
		     Integer timeToEatForDish= null; 
		     Integer maximumSatisfaction = 0;
			System.out.println("totalAmountOfTime["+totalAmountOfTime+"]totalMenuItems["+totalMenuItems+"]");
			   int i=1;
			    for(String line; (line = br.readLine()) != null; ) {
			        // process the line.
			    	System.out.println(line);
			    	String[] dishAndTimeTaken = line.split(" ");
			    	dishSatisfaction = Integer.valueOf(dishAndTimeTaken[1]);
			    	timeToEatForDish = Integer.valueOf(dishAndTimeTaken[0]);
			    	System.out.println("dishSatisfaction["+dishSatisfaction+"] -- timeToEatForDish"+i++ +"["+timeToEatForDish+"]");
			    	if(timeToEatForDish <= avarageTimeForAllDishes){
			    	   maximumSatisfaction += dishSatisfaction;
			    	}else{
			    		maximumSatisfaction += dishSatisfaction;
			    	}
			    }
			    System.out.println("maximumSatisfaction["+maximumSatisfaction+"]");
			    br.close();
			}
		
		catch(Exception exception){
		    System.out.println(exception.getMessage());
		}
		
	}

}


