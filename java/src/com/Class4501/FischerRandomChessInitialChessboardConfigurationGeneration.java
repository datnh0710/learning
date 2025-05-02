package com.Class4501;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FischerRandomChessInitialChessboardConfigurationGeneration {
    private static List<Character> pieces = Arrays.asList('R', 'B', 'N', 'Q', 'K', 'N', 'B', 'R');
    private static Character pawns = 'P';

    public static List<Character> initialChessboardConfigurationGeneration() {
        do {
            Collections.shuffle(pieces);
        } while (!checkCondition(pieces.toString().replaceAll("[^\\p{Upper}]", "")));
        return pieces;
    }

    private static boolean checkCondition(String rank) {
        if (!rank.matches(".*R.*k.*R.*"))
            return false;
        if (!rank.matches(".*B(..|....|......|)B.*"))
            return false;
        return true;
    }

//    public static void printChessBoard() {
//        System.out.println(initialChessboardConfigurationGeneration());
//
//    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(initialChessboardConfigurationGeneration());
        }
    }

}
