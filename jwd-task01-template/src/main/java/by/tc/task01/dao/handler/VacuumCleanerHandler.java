package by.tc.task01.dao.handler;

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

    public boolean handle(String str) {

        if (!str.contains("VacuumCleaner :")) {
            return false;
        }
        for (SearchCriteria.VacuumCleaner key : criteria.keySet()) {
            String searchString = key + "=" + criteria.get(key);
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
            String str = matcher.group();
            String[] values = str.split("=");
            findField(vacuumCleaner, values[0], values[1]);
        }
        return vacuumCleaner;
    }

    private VacuumCleaner findField(VacuumCleaner vacuumCleaner, String field, String value) {

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