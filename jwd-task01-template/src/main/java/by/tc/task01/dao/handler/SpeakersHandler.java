package by.tc.task01.dao.handler;

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

    public boolean handle(String str) {

        if (!str.contains("Speakers :")) {
            return false;
        }
        for (SearchCriteria.Speakers key : criteria.keySet()) {
            String searchString = key + "=" + criteria.get(key);
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
            String str = matcher.group();
            String[] values = str.split("=");
            findField(speakers, values[0], values[1]);
        }
        return speakers;
    }

    private Speakers findField(Speakers speakers, String field, String value) {

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