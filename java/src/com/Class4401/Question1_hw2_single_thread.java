package com.Class4401;

/**
 * @author datnh0710
 * @created 26/03/2022 - 10:30 AM
 * @packege com.Class4401
 * @project java
 */
public class Question1_hw2_single_thread {
    public static void main(String[] args) {
        long number = 69881631850817231L;
        // start time
        long startTime = System.currentTimeMillis();

        System.out.printf("%s is%sa prime number. \nThis took: %s ms.", number, single_thread_Prime_Check(number) ? " " : " not ", System.currentTimeMillis() - startTime);
        //end time

    }

    private static boolean single_thread_Prime_Check(long number){
        /* Returns true if number is prime */
        if (number % 2 == 0)
            return false;
        for (long i = 3; i <= Math.sqrt(number); i = i+2)
            if (number % i == 0)
                return false;
        return true;
    }
}
