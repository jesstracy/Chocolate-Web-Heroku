package com.tiy;

/**
 * Created by jessicatracy on 9/22/16.
 */
public class ChocolateSolver {

    public ChocolateSolution makeChocolate(int big, int small, int goal) {

        ChocolateSolution solution = new ChocolateSolution();
        int maxGoal = small + (big * 5);

        if (goal > maxGoal) {
            System.out.println("Not enough chocolate");
            solution.setNoSolution();
            return solution;
        }

        int smallsRequired = 0;
        int bigsRequired = 0;

        if (big == 0) {
            smallsRequired = goal;
        } else {
            smallsRequired = goal % 5;
            bigsRequired = goal / 5;
        }

        if (smallsRequired > small) {
            System.out.println("Not enough smalls");
            solution.setNoSolution();
            return solution;
        }

        if (bigsRequired > big) {
            smallsRequired += 5 * (bigsRequired - big);
            bigsRequired = big;
            if (smallsRequired > small) {
                System.out.println("Not enough bigs");
                solution.setNoSolution();
                return solution;
            }
        }

        solution.setSolution(smallsRequired, bigsRequired);

        return solution;
    }
}
