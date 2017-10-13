package by.tc.task01.dao.handler.impl;

import by.tc.task01.dao.handler.Handler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefrigeratorHandler extends Handler<SearchCriteria.Refrigerator> {


    public RefrigeratorHandler(Map<SearchCriteria.Refrigerator, Object> criteria) {
        super(criteria);
    }

    public boolean checkString(String str) {
        if (!str.contains("Refrigerator :")) {
            return false;
        }
        for (SearchCriteria.Refrigerator key : getCriteria().keySet()) {
            String searchString = key + "=" + getCriteria().get(key);
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;
    }

    public Appliance execute(String string) {
        Refrigerator refrigerator = new Refrigerator();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String equality = matcher.group();
            String[] values = equality.split("=");
            fullField(refrigerator, values[0], values[1]);
        }
        return refrigerator;
    }

    private Refrigerator fullField(Refrigerator refrigerator, String field, String value) {
        if ("POWER_CONSUMPTION".equalsIgnoreCase(field)) {
            refrigerator.setPowerConsumption(Double.valueOf(value));
        } else if ("WEIGHT".equalsIgnoreCase(field)) {
            refrigerator.setWeight(Double.valueOf(value));
        } else if ("FREEZER_CAPACITY".equalsIgnoreCase(field)) {
            refrigerator.setFreezerCapacity(Double.valueOf(value));
        } else if ("OVERALL_CAPACITY".equalsIgnoreCase(field)) {
            refrigerator.setOverallCapacity(Double.valueOf(value));
        } else if ("HEIGHT".equalsIgnoreCase(field)) {
            refrigerator.setHeight(Double.valueOf(value));
        } else if ("WIDTH".equalsIgnoreCase(field)) {
            refrigerator.setWidth(Double.valueOf(value));
        }
        return refrigerator;
    }

}
