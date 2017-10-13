package by.tc.task01.entity;

import java.io.Serializable;

public class Speakers extends Appliance implements Serializable {

    private double powerConsumption;
    private double numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(double numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    private boolean compareFields(Speakers speakers) {
        if (powerConsumption != speakers.powerConsumption ||
                numberOfSpeakers != speakers.numberOfSpeakers ||
                !frequencyRange.equals(speakers.frequencyRange) ||
                cordLength != speakers.cordLength) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(powerConsumption).hashCode() +
                Double.valueOf(numberOfSpeakers).hashCode() +
                frequencyRange.hashCode() +
                Double.valueOf(cordLength).hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Speakers speakers = (Speakers) obj;
        if (!super.equals(speakers)) {
            return false;
        }
        return compareFields(speakers);
    }

    @Override
    public String toString() {
        return "Speakers : " +
                "\npower consumption = " + powerConsumption +
                "\nnumber of speakers = " + numberOfSpeakers +
                "\nfrequency range = " + frequencyRange +
                "\ncord length = " + cordLength;
    }

}
