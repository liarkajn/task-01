package by.tc.task01.entity;

public class VacuumCleaner extends Appliance{

    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    private boolean compareFields(VacuumCleaner vacuumCleaner) {
        if (powerConsumption != vacuumCleaner.powerConsumption ||
                !filterType.equals(vacuumCleaner.filterType) ||
                !bagType.equals(vacuumCleaner.bagType) ||
                !wandType.equals(vacuumCleaner.wandType) ||
                motorSpeedRegulation != vacuumCleaner.motorSpeedRegulation ||
                cleaningWidth != vacuumCleaner.cleaningWidth) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * (Double.valueOf(powerConsumption).hashCode() +
                filterType.hashCode() + bagType.hashCode() + wandType.hashCode() +
                Double.valueOf(motorSpeedRegulation).hashCode() +
                Double.valueOf(cleaningWidth).hashCode());
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
        VacuumCleaner vacuumCleaner = (VacuumCleaner) obj;
        if (!super.equals(vacuumCleaner)) {
            return false;
        }
        return compareFields(vacuumCleaner);
    }

    @Override
    public String toString() {
        return "Vacuum cleaner : " +
                "\npower consumption = " + powerConsumption +
                "\nfilter type = " + filterType +
                "\nbag type = " + bagType +
                "\nwand type = " + wandType +
                "\nmotor speed regulation = " + motorSpeedRegulation +
                "\ncleaning width = " +cleaningWidth;
    }

}
