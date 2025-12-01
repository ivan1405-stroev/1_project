package org.example;

import java.util.HashMap;

public class MonthData {
    int[] stepsPerDay = new int[30];


    public void addStepsToDay(int day, int steps){
            stepsPerDay[day] = steps;
    }

    public void printDays(){
        for (int i = 0; i < stepsPerDay.length; i++) {
            System.out.println(i + " день: " + stepsPerDay[i]);
        }
    }



}
