package com.tiy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jessicatracy on 9/22/16.
 */
@RestController
public class MakeChocolateJSONController {

    @RequestMapping(path = "/getSolution.json", method = RequestMethod.GET)
    public ChocolateSolution getSolutionJson(int numBig, int numSmall, int goal) {
        ChocolateSolver mySampleChocolateSolver = new ChocolateSolver();
        ChocolateSolution mySolution = mySampleChocolateSolver.makeChocolate(numBig, numSmall, goal);
        return mySolution;
    }
}
