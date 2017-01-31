package com.restaurant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is used as a Controller for the REST APIs.
 * 
 * @author Rajapandi
 *
 */
@RestController
public class RestaurantController {

    @RequestMapping("/restaurantSatisfaction")
    public String restaurantSatisfy() {
        RestaurantSatisfaction restaurantSatisfaction = new RestaurantSatisfaction();
        Integer maxSatisfactionValue = restaurantSatisfaction.parseResturantMenu();
        return "Restaurant Maximum satisfaction is :"+maxSatisfactionValue;
    }
}
