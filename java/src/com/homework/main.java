package com.homework;

import com.EmunClass.EmunClass;

import java.util.EnumSet;

public class main {
    public static void main(String[] args) {

//        for (EmunClass emun: EmunClass.values()) {
//            System.out.printf("%-10s%-45s%s%n", emun,
//                    emun.getTitle(), emun.getCopyRightYear());
//        }
//
//        for (EmunClass emun: EnumSet.range(EmunClass.CHTP,EmunClass.IW3HTP)) {
//            System.out.printf("%-10s%-45s%s%n", emun,
//                    emun.getTitle(), emun.getCopyRightYear());
//        }
        int size =10;
        for (int i = 1; i < size ; i++) {
            System.out.printf("Index: " + i + " value: " + (i+1)+ "\n");
        }
    }
}
