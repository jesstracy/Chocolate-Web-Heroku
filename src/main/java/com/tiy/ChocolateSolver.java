package com.tiy;

/**
 * Created by jessicatracy on 9/22/16.
 */
public class ChocolateSolver {

    public ChocolateSolution makeChocolate(int small, int big, int goal) {
        ChocolateSolution mySolution = new ChocolateSolution();
        if (small < 0 || big < 0 || goal < 0) {
            mySolution.setNoSolution();
        } else {
            int greatestMultipleOfFiveInGoal = goal - (goal % 5);
            int numBigsNeededToMakeGreatestMultipleOfFiveInGoal = greatestMultipleOfFiveInGoal / 5;
            if (big <= numBigsNeededToMakeGreatestMultipleOfFiveInGoal) {
                int smallsNeeded = goal - (5 * big);
                if (small >= smallsNeeded) {
                    mySolution.setSolution(smallsNeeded, big);
                } else {
                    mySolution.setNoSolution();
                }
            } else {
                int smallsNeeded = goal - (5 * numBigsNeededToMakeGreatestMultipleOfFiveInGoal);
                if (small >= smallsNeeded) {
                    mySolution.setSolution(smallsNeeded, numBigsNeededToMakeGreatestMultipleOfFiveInGoal);
                } else {
                    mySolution.setNoSolution();
                }
            }
        }
        return mySolution;
    }

}
