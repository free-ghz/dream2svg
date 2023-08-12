package es.sixey.dream2svg.util;

import java.util.Random;

public class Wave {
    private double waveOffsetX = 0;
    private double waveOffsetY = 0;
    private double wavePeriodX = 13;
    private double wavePeriodY = 13;

    public Wave(double offsetX, double offsetY, double periodX, double periodY) {
        this.waveOffsetX = offsetX;
        this.waveOffsetY = offsetY;
        this.wavePeriodX = periodX;
        this.wavePeriodY = periodY;
    }

    public Wave() {
        var random = new Random();
        wavePeriodX = random.nextDouble(8, 40);
        wavePeriodY = random.nextDouble(8, 60);
        waveOffsetX = random.nextDouble(wavePeriodX);
        waveOffsetY = random.nextDouble(wavePeriodY);
        System.out.println(this);
    }

    public double getWave(int x, int y, double min, double max) {
        double xFactor = Math.PI * 2 / wavePeriodX;
        double yFactor = Math.PI * 2 / wavePeriodY;
        double xComponent = (x + waveOffsetX) * xFactor;
        double yComponent = (y + waveOffsetY) * yFactor;
        double value = Math.sin(xComponent + yComponent);
        return (((value + 1.0) / 2.0) * (max - min)) + min;
    }

    @Override
    public String toString() {
        return "Wave<" + Math.round(wavePeriodX*10)/10.0 + ", " + Math.round(wavePeriodY*10)/10.0 + ">";
    }
}
