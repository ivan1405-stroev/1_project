package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();
    Converter converter = new Converter();

    int target = 10000;

    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void addStepsToDays() {
        System.out.println("Введите номер месяца (0-январь ... 11 - декабрь): ");
        int month = scanner.nextInt();
        if (month < 0 || month > 12) {
            System.out.println("Введен некорректный номер месяца");
            return;
        }
        System.out.println("Введите номер дня: ");
        int day = scanner.nextInt();
        if (day < 0 || day > 30) {
            System.out.println("Введен некорректный номер дня");
            return;
        }
        System.out.println("Введите количество шагов: ");
        int numOfSteps = scanner.nextInt();
        if (numOfSteps < 0) {
            System.out.println("Количество шагов не может быть меньше нуля");
            return;
        }
        monthData = monthToData.get(month);
        monthData.addStepsToDay(day, numOfSteps);
    }

    public void printSteps() {
        System.out.println("Введите номер месяца (0-январь ... 11 - декабрь): ");
        int month = scanner.nextInt();
        if (month < 0 || month > 12) {
            System.out.println("Введен некорректный номер месяца");
            return;
        }
        monthData = monthToData.get(month);
        monthData.printDays();
    }

    public void printTotalSteps(int month) {
        monthData = monthToData.get(month);
        int sumSteps = 0;
        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            sumSteps += monthData.stepsPerDay[i];
        }
        System.out.println("Общее количество шагов за месяц = " + sumSteps);
    }

    public void printMaxStepsDay(int month) {
        monthData = monthToData.get(month);
        int maxStepsDay = 0;
        int day = 0;
        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            if (monthData.stepsPerDay[i] > maxStepsDay) {
                maxStepsDay = monthData.stepsPerDay[i];
                day = i;
            }
        }
        System.out.println(day + " день: количество шагов = " + maxStepsDay);
    }

    private void printMedianAmountSteps(int month) {
        monthData = monthToData.get(month);
        int sumSteps = 0;
        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            sumSteps += monthData.stepsPerDay[i];
        }

        System.out.println("Среднее количество шагов: " + sumSteps / monthData.stepsPerDay.length);
    }

    private void printDistanceForAMonth(int month){
        int steps = 0;
        monthData = monthToData.get(month);
        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            steps += monthData.stepsPerDay[i];
        }
        System.out.println("Пройденная дистанция: " + converter.stepToDistance(steps));
    }

    private void printKilocalories(int month){
        int steps = 0;
        monthData = monthToData.get(month);
        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            steps += monthData.stepsPerDay[i];
        }
        System.out.println("Количество сожженных килокалорий: " + converter.stepToKilocalories(steps));
    }

    private void printBestEpisode(int month){
        ArrayList<Integer> assist = new ArrayList<>();
        int sumBestDays = 0;
        monthData = monthToData.get(month);

        for (int i = 0; i < monthData.stepsPerDay.length; i++) {
            if (monthData.stepsPerDay[i] > target){
                sumBestDays++;
            }
            if (monthData.stepsPerDay[i] < target){
                assist.add(sumBestDays);
                sumBestDays = 0;
            }
        }

        int helper = 0;
        for (Integer integer : assist) {
            if (integer > helper) {
                helper = integer;
            }
        }

        System.out.println("Лучшая серия: " + helper + " дней!");

    }

    public void changeTargetValue(){
        System.out.println("Введите новую цель по шагам в день (текущее значение = " + target +"): ");
        int newTarget = scanner.nextInt();
        if (newTarget < 0){
            System.out.println("Значение не может быть отрицательным!");
            return;
        }
        target = newTarget;
        System.out.println("Значение успешно изменено!");
    }

    public void statistic() {
        System.out.println("Введите номер месяца (0-январь ... 11 - декабрь): ");
        int month = scanner.nextInt();
        if (month < 0 || month > 12) {
            System.out.println("Введен некорректный номер месяца");
            return;
        }
        printTotalSteps(month);
        printMaxStepsDay(month);
        printMedianAmountSteps(month);
        printDistanceForAMonth(month);
        printKilocalories(month);
        printBestEpisode(month);
    }
}
