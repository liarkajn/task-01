package by.tc.task01.dao.handler.impl;

import by.tc.task01.dao.handler.Handler;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeakersHandler extends Handler<SearchCriteria.Speakers> {


    public SpeakersHandler(Map<SearchCriteria.Speakers, Object> criteria) {
        super(criteria);
    }

    public boolean checkString(String str) {
        if (!str.contains("Speakers :")) {
            return false;
        }
        for (SearchCriteria.Speakers key : getCriteria().keySet()) {
            String searchString = key + "=" + getCriteria().get(key);
            if (!str.contains(searchString + ",") && !str.contains(searchString + ";")) {
                return false;
            }
        }
        return true;
    }

    public Appliance execute(String string) {
        Speakers speakers = new Speakers();
        Pattern pattern = Pattern.compile("[A-Z_]+=[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String equality = matcher.group();
            String[] values = equality.split("=");
            fullField(speakers, values[0], values[1]);
        }
        return speakers;
    }

    private Speakers fullField(Speakers speakers, String field, String value) {
        if ("POWER_CONSUMPTION".equalsIgnoreCase(field)) {
            speakers.setPowerConsumption(Double.valueOf(value));
        } else if ("NUMBER_OF_SPEAKERS".equalsIgnoreCase(field)) {
            speakers.setNumberOfSpeakers(Double.valueOf(value));
        } else if ("FREQUENCY_RANGE".equalsIgnoreCase(field)) {
            speakers.setFrequencyRange(value);
        } else if ("CORD_LENGTH".equalsIgnoreCase(field)) {
            speakers.setCordLength(Double.valueOf(value));
        }
        return speakers;
    }

}