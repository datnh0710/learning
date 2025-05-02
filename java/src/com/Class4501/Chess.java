package com.Class4501;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chess {
    //with the letters King-K Queen-Q Rook-R Bishop-B kNight-N
    private static List<Character> pieces = Arrays.asList('R', 'B', 'N', 'Q', 'K', 'N', 'B', 'R');
    private static List<Character> pawns = Arrays.asList('P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'); // pawns
    private static List<Character> blanks = Arrays.asList('*', '_', '*', '_', '*', '_', '*', '_');


    private static boolean check(String rank) {
        if (!rank.matches(".*R.*K.*R.*")) return false;            //king between rooks
        if (!rank.matches(".*B(..|....|......|)B.*")) return false;    //all possible ways bishops can be placed
        return true;
    }


    public static List<Character> generateRank() {
        do {
            Collections.shuffle(pieces);
        } while (!check(pieces.toString().replaceAll("[^\\p{Upper}]", "")));

        return pieces;
    }


    public static void printChessBoard() {
        List<Character> ini_res = generateRank();
        System.out.println(ini_res);
        System.out.println(pawns);
        for (int i = 2; i <= 5; i++) {
            System.out.println(blanks);
        }
        System.out.println(pawns);
        System.out.println(ini_res);
    }

    public static void main(String[] args) {
        printChessBoard();
    }
}
