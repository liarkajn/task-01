package by.tc.task01.dao.handler.impl;

import by.tc.task01.dao.handler.Handler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VacuumCleanerHandler extends Handler<SearchCriteria.VacuumCleaner> {


    public VacuumCleanerHandler(Map<SearchCriteria.VacuumCleaner, Object> criteria) {
        super(criteria);
    }

    public boolean checkString(String str) {
        if (!str.contains("VacuumCleaner :")) {
            return false;
        }
        for (SearchCriteria.VacuumCleaner key : getCriteria().keySet()) {
            String searchString = key + "=" + getCriteria().get(key);
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;
    }

    public Appliance execute(String string) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String equality = matcher.group();
            String[] values = equality.split("=");
            fullField(vacuumCleaner, values[0], values[1]);
        }
        return vacuumCleaner;
    }

    private VacuumCleaner fullField(VacuumCleaner vacuumCleaner, String field, String value) {
        if ("POWER_CONSUMPTION".equalsIgnoreCase(field)) {
            vacuumCleaner.setPowerConsumption(Double.valueOf(value));
        } else if ("FILTER_TYPE".equalsIgnoreCase(field)) {
            vacuumCleaner.setFilterType(value);
        } else if ("BAG_TYPE".equalsIgnoreCase(field)) {
            vacuumCleaner.setBagType(value);
        } else if ("WAND_TYPE".equalsIgnoreCase(field)) {
            vacuumCleaner.setWandType(value);
        } else if ("MOTOR_SPEED_REGULATION".equalsIgnoreCase(field)) {
            vacuumCleaner.setMotorSpeedRegulation(Double.valueOf(value));
        } else if ("CLEANING_WIDTH".equalsIgnoreCase(field)) {
            vacuumCleaner.setCleaningWidth(Double.valueOf(value));
        }
        return vacuumCleaner;
    }

}