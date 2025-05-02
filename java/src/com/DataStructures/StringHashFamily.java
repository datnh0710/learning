package com.DataStructures;

import java.util.Random;

public class StringHashFamily implements HashFamily<String> {
    private final int[] MULTIPLIERS;
    private final Random r = new Random();

    public StringHashFamily(int d) {
        MULTIPLIERS = new int[d];
        generateNewFunction();
    }

    @Override
    public int hash(String x, int which) {
        final int multiplier = MULTIPLIERS[which];
        int hashVal = 0;
        for (int i = 0; i < MULTIPLIERS.length; i++) {
            hashVal = multiplier * hashVal + x.charAt(i);
        }
        return hashVal;
    }

    @Override
    public int getNumberOfFunction() {
        return MULTIPLIERS.length;
    }

    @Override
    public void generateNewFunction() {
        for (int i = 0; i < MULTIPLIERS.length; i++) {
            MULTIPLIERS[i] = r.nextInt();
        }
    }
}
