package by.tc.task01.dao.handler;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OvenHandler extends Handler<SearchCriteria.Oven> {


    public OvenHandler(Map<SearchCriteria.Oven, Object> criteria) {
        super(criteria);
    }

    public boolean handle(String str) {

        if (!str.contains("Oven :")) {
            return false;
        }
        for (SearchCriteria.Oven key : criteria.keySet()) {
            String searchString = key + "=" + criteria.get(key);
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;

    }

    public Appliance execute(String string) {
        Oven oven = new Oven();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String str = matcher.group();
            String[] values = str.split("=");
            findField(oven, values[0], values[1]);
        }
        return oven;
    }

    private Oven findField(Oven oven, String field, String value) {

        if ("POWER_CONSUMPTION".equalsIgnoreCase(field)) {
            oven.setPowerConsumption(Double.valueOf(value));
        } else if ("WEIGHT".equalsIgnoreCase(field)) {
            oven.setWeight(Double.valueOf(value));
        } else if ("CAPACITY".equalsIgnoreCase(field)) {
            oven.setCapacity(Double.valueOf(value));
        } else if ("DEPTH".equalsIgnoreCase(field)) {
            oven.setDepth(Double.valueOf(value));
        } else if ("HEIGHT".equalsIgnoreCase(field)) {
            oven.setHeight(Double.valueOf(value));
        } else if ("WIDTH".equalsIgnoreCase(field)) {
            oven.setWidth(Double.valueOf(value));
        }

        return oven;
    }

}
