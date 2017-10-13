package by.tc.task01.service.validation.validators.impl;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class SpeakersValidator implements CommandValidator<SearchCriteria.Speakers> {

    public boolean validate(Criteria<SearchCriteria.Speakers> criteria) {
        for (SearchCriteria.Speakers key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("NUMBER_OF_SPEAKERS".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FREQUENCY_RANGE".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("CORD_LENGTH".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateDouble(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!Number.class.isInstance(obj)) {
            return false;
        }
        double powerConsumption = Double.valueOf(obj.toString());
        if (powerConsumption < 0) {
            return false;
        }
        return true;
    }

}
