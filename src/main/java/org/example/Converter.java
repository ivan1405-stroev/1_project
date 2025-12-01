package org.example;

public class Converter {
    public int stepToDistance(int steps){
        return steps*75/100;
    }

    public int stepToKilocalories(int steps){
        return steps*50/1000;
    }
}
