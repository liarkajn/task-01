package by.tc.task01.entity;

public class Oven extends Appliance{

    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
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

    private boolean compareFields(Oven oven) {
        if (powerConsumption != oven.powerConsumption || weight != oven.weight ||
                capacity != oven.capacity || depth != oven.depth ||
                height != oven.height || width != oven.width) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(powerConsumption).hashCode() +
                Double.valueOf(weight).hashCode() +
                Double.valueOf(capacity).hashCode() +
                Double.valueOf(depth).hashCode() +
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
        Oven oven = (Oven) obj;
        if (!super.equals(oven)) {
            return false;
        }
        return compareFields(oven);
    }

    @Override
    public String toString() {
        return "Oven : " +
                "\npower consumption = " + powerConsumption +
                "\nweight = " + weight +
                "\ncapacity = " + capacity +
                "\ndepth = " + depth +
                "\nheight = " + height +
                "\nwidth = " + width;
    }

}
