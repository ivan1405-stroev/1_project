package org.example;

import java.util.HashMap;

public class MonthData {
    private static final int DAYS_IN_MONTH = 30;

    int[] stepsPerDay = new int[DAYS_IN_MONTH];


    public void addStepsToDay(int day, int steps) {
        stepsPerDay[day] = steps;
    }

    public void printDays() {
        for (int i = 0; i < stepsPerDay.length; i++) {
            System.out.println(i + " день: " + stepsPerDay[i]);
        }
    }

    public int[] getStepsPerDay() {
        return stepsPerDay;
    }
}
