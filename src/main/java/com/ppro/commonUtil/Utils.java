package com.ppro.commonUtil;

import java.util.Random;

/**
 * Utility Class
 */
public class Utils {

    /**
     * Generate Random number
     * Returns random number int
     */
    public static int getRandomNumber(){

        Random random = new Random();
        return random.ints(100,(9999+1)).findFirst().getAsInt();

    }

}
