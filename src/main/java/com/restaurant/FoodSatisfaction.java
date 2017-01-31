package com.restaurant;

import java.util.List;

/**
 * @author Rajapandi
 *
 */
public class FoodSatisfaction {

    /**
     * @param satisfaction : List<Integer> satisfaction as Integer List
     * @param times : List<Integer> time taken as Integer List
     * @param totalTime : Total given time
     * @param itemCount : No of items count
     * @return : Return the maximum satisfaction as integer value
     */
    public int findMaxSatisfaction(List<Integer> satisfaction, List<Integer> times, int totalTime,
            int itemCount) {

        // Create a matrix. foods are in rows and time at in columns +1 on each
        // side



        int[][] V = new int[itemCount + 1][totalTime + 1];

        // Set all columns at row 0 to be 0
        for (int col = 0; col <= totalTime; col++) {
            V[0][col] = 0;
           
        }
        // What if there are no foods at restaurant. Fill the first row with 0
        for (int row = 0; row <= itemCount; row++) {
            V[row][0] = 0;
        }
        for (int foodCount = 1; foodCount <= itemCount; foodCount++) {
            // Let's fill the values row by row
            for (int time = 1; time <= totalTime; time++) {
                // Is the current food time taken less than or equal to running
                // time
                if (times.get(foodCount - 1) <= time) {
                    // Given a time, check if the satisfaction of the current food +
                    // time of the food that we could afford with the remaining
                    // time is greater than the satisfaction without the current food itself
                    V[foodCount][time] = Math.max(
                            satisfaction.get(foodCount - 1)
                                    + V[foodCount - 1][time - times.get(foodCount - 1)],
                            V[foodCount - 1][time]);
                } else {
                    // If the current food's time is more than the running
                    // time, just carry forward the value without the current
                    // food
                    V[foodCount][time] = V[foodCount - 1][time];
                }
            }
        }


        return V[itemCount][totalTime];
    }


}
