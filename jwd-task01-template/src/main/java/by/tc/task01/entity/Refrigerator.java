package by.tc.task01.entity;

public class Refrigerator extends Appliance{

    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private boolean compareFields(Refrigerator refrigerator) {
        if (powerConsumption != refrigerator.powerConsumption || weight != refrigerator.weight ||
                freezerCapacity != refrigerator.freezerCapacity ||
                overallCapacity != refrigerator.overallCapacity ||
                height != refrigerator.height || width != refrigerator.width) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(powerConsumption).hashCode() +
                Double.valueOf(weight).hashCode() +
                Double.valueOf(freezerCapacity).hashCode() +
                Double.valueOf(overallCapacity).hashCode() +
                Double.valueOf(height).hashCode() +
                Double.valueOf(width).hashCode());
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
        Refrigerator refrigerator = (Refrigerator) obj;
        if (!super.equals(refrigerator)) {
            return false;
        }
        return compareFields(refrigerator);
    }

    @Override
    public String toString() {
        return "Refrigerator : " +
                "\npower consumption = " + powerConsumption +
                "\nweight = " + weight +
                "\nfreezer capacity = " + freezerCapacity +
                "\noverall capacity = " + overallCapacity +
                "\nheight = " + height +
                "\nwidth = " + width;
    }

}
