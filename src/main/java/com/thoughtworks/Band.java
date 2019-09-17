package com.thoughtworks;

public class Band {

    private int digit;
    private int multiplier;
    private String tolerance;

    public Band(int digit, int multiplier, String tolerance) {
        this.digit = digit;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
    }

    public int getDigit() {
        return digit;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getTolerance() {
        return tolerance;
    }
}
