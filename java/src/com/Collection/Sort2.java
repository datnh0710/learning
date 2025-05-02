package com.Collection;

import com.homework.Timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort2 {
    public static void main(String[] args) {
        List<Timer> timerList = new ArrayList<>();

        timerList.add(new Timer(6,1,33));
        timerList.add(new Timer(7,1,33));
        timerList.add(new Timer(8,1,33));
        timerList.add(new Timer(9,1,33));
        timerList.add(new Timer(19,1,33));
        timerList.add(new Timer(10,1,33));
        timerList.add(new Timer(11,1,33));
        timerList.add(new Timer(6,2,33));
        timerList.add(new Timer(6,1,34));

        System.out.printf("Unsorted array elements:%n%s%n", timerList);

        Collections.sort(timerList,new TimeComparator());
        System.out.printf("Sorted list elements:%n%s%n", timerList);

    }
}
