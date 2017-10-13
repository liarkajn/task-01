package by.tc.task01.entity;

import java.io.Serializable;

public class TabletPC extends Appliance implements Serializable {

    private double batteryCapacity;
    private double displayInches;
    private double memoryROM;
    private double flashMemoryCapacity;
    private String color;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private boolean compareFields(TabletPC tabletPC) {
        if (batteryCapacity != tabletPC.batteryCapacity ||
                displayInches != tabletPC.displayInches ||
                memoryROM != tabletPC.memoryROM ||
                flashMemoryCapacity != tabletPC.flashMemoryCapacity ||
                !color.equals(tabletPC.color)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(batteryCapacity).hashCode() +
                Double.valueOf(displayInches).hashCode() +
                Double.valueOf(memoryROM).hashCode() +
                Double.valueOf(flashMemoryCapacity).hashCode() +
                color.hashCode());
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
        TabletPC tabletPC = (TabletPC) obj;
        if (!super.equals(tabletPC)) {
            return false;
        }
        return compareFields(tabletPC);
    }

    @Override
    public String toString() {
        return "Tablet PC : " +
                "\nbattery capacity = " + batteryCapacity +
                "\ndisplay inches = " + displayInches +
                "\nmemory ROM = " + memoryROM +
                "\nflash memory capacity = " + flashMemoryCapacity +
                "\ncolor = " + color;
    }

}
