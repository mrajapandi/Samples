package com.restaurant;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;

/**This class used to read the file and calculate the maximum satisfaction for the given menu items
 * 
 * @author rajapandi
 *
 */
public class RestaurantSatisfaction {
	
	public Logger logger = Logger.getLogger(RestaurantSatisfaction.class);
	
	public void readFileAndCalculateSatisfaction(){
	    BufferedReader br=null;
		try{
		    br = new BufferedReader(new FileReader("src/main/resources/restaurant_menu_time.txt"));
			 String text = br.readLine();
			 logger.info(text);
			 logger.info("========================");
			 String[] timeAndmenuItems = text.split(" ");
			 Integer totalAmountOfTime = Integer.valueOf(timeAndmenuItems[0]);
		     Integer totalMenuItems= Integer.valueOf(timeAndmenuItems[1]); 
		     Integer avarageTimeForAllDishes = totalAmountOfTime/totalMenuItems;
		     Integer dishSatisfaction = null;
		     Integer timeToEatForDish= null; 
		     Integer maximumSatisfaction = 0;
			logger.info("totalAmountOfTime["+totalAmountOfTime+"]totalMenuItems["+totalMenuItems+"]");
			   int i=1;
			    for(String line; (line = br.readLine()) != null; ) {
			        // process the line.
			    	logger.info(line);
			    	String[] dishAndTimeTaken = line.split(" ");
			    	dishSatisfaction = Integer.valueOf(dishAndTimeTaken[0]);
			    	timeToEatForDish = Integer.valueOf(dishAndTimeTaken[1]);
			    	logger.info("dishSatisfaction["+dishSatisfaction+"] -- timeToEatForDish"+i++ +"["+timeToEatForDish+"]");
			    	if(timeToEatForDish <= avarageTimeForAllDishes){
			    	   maximumSatisfaction += dishSatisfaction;
			    	}else{
			    		maximumSatisfaction += dishSatisfaction;
			    	}
			    }
			    logger.info("maximumSatisfaction["+maximumSatisfaction+"]");
			    br.close();
			}
		
		catch(Exception exception){
			logger.error(exception.getMessage());
		}
		
	}

}


