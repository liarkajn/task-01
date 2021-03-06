package by.tc.task01.dao.handler.impl;

import by.tc.task01.dao.handler.Handler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabletPCHandler extends Handler<SearchCriteria.TabletPC> {


    public TabletPCHandler(Map<SearchCriteria.TabletPC, Object> criteria) {
        super(criteria);
    }

    public boolean checkString(String str) {
        if (!str.contains("TabletPC :")) {
            return false;
        }
        for (SearchCriteria.TabletPC key : getCriteria().keySet()) {
            String searchString = (key + "=" + getCriteria().get(key).toString().toLowerCase());
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;
    }

    public Appliance execute(String string) {
        TabletPC tabletPC = new TabletPC();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String equality = matcher.group();
            String[] values = equality.split("=");
            fullField(tabletPC, values[0], values[1]);
        }
        return tabletPC;
    }

    private TabletPC fullField(TabletPC tabletPC, String field, String value) {
        if ("BATTERY_CAPACITY".equalsIgnoreCase(field)) {
            tabletPC.setBatteryCapacity(Double.valueOf(value));
        } else if ("DISPLAY_INCHES".equalsIgnoreCase(field)) {
            tabletPC.setDisplayInches(Double.valueOf(value));
        } else if ("MEMORY_ROM".equalsIgnoreCase(field)) {
            tabletPC.setMemoryROM(Double.valueOf(value));
        } else if ("FLASH_MEMORY_CAPACITY".equalsIgnoreCase(field)) {
            tabletPC.setFlashMemoryCapacity(Double.valueOf(value));
        } else if ("COLOR".equalsIgnoreCase(field)) {
            tabletPC.setColor(value);
        }
        return tabletPC;
    }

}
