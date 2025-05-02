package com.Collection;

import com.homework.Timer;

import java.util.Comparator;

public class TimeComparator implements Comparator<Timer> {

    @Override
    public int compare(Timer timer, Timer t1) {
        int hourDifference = timer.getHour() - t1.getHour();
        if (hourDifference != 0) {
            return hourDifference;
        }
        int minuteDifference = timer.getMinute() - t1.getMinute();
        if (minuteDifference != 0) {
            return minuteDifference;
        }
        int secondDifference = timer.getSecond() - t1.getSecond();
        return secondDifference;

    }
}
