package org.example;

public class Converter {
    private static final double STEP_LENGTH_CM = 0.75;
    private static final double KCAL_PER_STEP = 0.05;


    public int stepToDistance(int steps) {
        return (int) (steps * STEP_LENGTH_CM);
    }

    public int stepToKilocalories(int steps) {
        return (int) (steps * KCAL_PER_STEP);
    }
}
