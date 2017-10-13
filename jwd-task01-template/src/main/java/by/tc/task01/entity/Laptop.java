package by.tc.task01.entity;

import java.io.Serializable;

public class Laptop extends Appliance implements Serializable {

    private double batteryCapacity;
    private String os;
    private double memoryROM;
    private double systemMemory;
    private double cpu;
    private double displayInchs;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOS() {
        return os;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCPU() {
        return cpu;
    }

    public void setCPU(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    private boolean compareFields(Laptop laptop) {
        if (batteryCapacity != laptop.batteryCapacity || !os.equals(laptop.os) ||
                memoryROM != laptop.memoryROM || systemMemory != laptop.systemMemory ||
                cpu != laptop.cpu || displayInchs != laptop.displayInchs) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(batteryCapacity).hashCode() + os.hashCode() +
                Double.valueOf(memoryROM).hashCode() +
                Double.valueOf(systemMemory).hashCode() +
                Double.valueOf(cpu).hashCode() +
                Double.valueOf(displayInchs).hashCode());
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
        Laptop laptop = (Laptop) obj;
        if (!super.equals(laptop)) {
            return false;
        }
        return compareFields(laptop);
    }

    @Override
    public String toString() {
        return "Laptop : " +
                "\nbattery capacity = " + batteryCapacity +
                "\nOS = " + os +
                "\nmemory ROM = " + memoryROM +
                "\nsystem memory = " + systemMemory +
                "\nCPU = " + cpu +
                "\ndisplay inchs = " + displayInchs;
    }

}
