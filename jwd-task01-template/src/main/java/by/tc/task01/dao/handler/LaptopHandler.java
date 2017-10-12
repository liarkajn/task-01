package by.tc.task01.dao.handler;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LaptopHandler extends Handler<SearchCriteria.Laptop> {


    public LaptopHandler(Map<SearchCriteria.Laptop, Object> criteria) {
        super(criteria);
    }

    public boolean handle(String str) {

        if (!str.contains("Laptop :")) {
            return false;
        }
        for (SearchCriteria.Laptop key : criteria.keySet()) {
            String searchString = key + "=" + criteria.get(key);
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;

    }

    public Appliance execute(String string) {
        Laptop laptop = new Laptop();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String str = matcher.group();
            String[] values = str.split("=");
            findField(laptop, values[0], values[1]);
        }
        return laptop;
    }

    private Laptop findField(Laptop laptop, String field, String value) {

        if ("BATTERY_CAPACITY".equalsIgnoreCase(field)) {
            laptop.setBatteryCapacity(Double.valueOf(value));
        } else if ("OS".equalsIgnoreCase(field)) {
            laptop.setOS(value);
        } else if ("MEMORY_ROM".equalsIgnoreCase(field)) {
            laptop.setMemoryROM(Double.valueOf(value));
        } else if ("SYSTEM_MEMORY".equalsIgnoreCase(field)) {
            laptop.setSystemMemory(Double.valueOf(value));
        } else if ("CPU".equalsIgnoreCase(field)) {
            laptop.setCPU(Double.valueOf(value));
        } else if ("DISPLAY_INCHS".equalsIgnoreCase(field)) {
            laptop.setDisplayInchs(Double.valueOf(value));
        }

        return laptop;
    }

}
