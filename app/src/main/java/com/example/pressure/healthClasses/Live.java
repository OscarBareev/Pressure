package com.example.pressure.healthClasses;

public class Live {
   private double weight;
   private int steps;

    public Live(double weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
