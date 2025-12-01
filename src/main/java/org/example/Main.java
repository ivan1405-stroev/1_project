package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 4){
            switch (userInput){
                case 1:
                    stepTracker.addStepsToDays();
                    break;
                case 2:
                    stepTracker.statistic();
                    break;
                case 3:
                    stepTracker.changeTargetValue();
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    break;
            }

            printMenu();
            userInput = scanner.nextInt();
        }

    }

    private static void printMenu(){
        System.out.println("""
                Выберите действие:\s
                1. Ввести количество шагов за определенный день\s
                2. Напечатать статистику за определенный месяц\s
                3. Изменить цель по количеству шагов в день\s
                4. Выйти из приложения""");
    }
}