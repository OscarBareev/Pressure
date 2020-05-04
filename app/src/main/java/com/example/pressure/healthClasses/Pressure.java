package com.example.pressure.healthClasses;

import java.util.Date;

public class Pressure {

    private int topPressure;
    private int lowPressure;
    private int puls;
    private boolean tachycardia;
    private String date;

    public Pressure(int topPressure, int lowPressure, int puls, boolean tachycardia, String date) {
        this.topPressure = topPressure;
        this.lowPressure = lowPressure;
        this.puls = puls;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    public int getTopPressure() {
        return topPressure;
    }

    public void setTopPressure(int topPressure) {
        this.topPressure = topPressure;
    }

    public int getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(int lowPressure) {
        this.lowPressure = lowPressure;
    }

    public int getPuls() {
        return puls;
    }

    public void setPuls(int puls) {
        this.puls = puls;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public void setTachycardia(boolean tachycardia) {
        this.tachycardia = tachycardia;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
