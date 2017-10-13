package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.Speakers;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class SpeakersValidator implements CommandValidator<Speakers> {

    public boolean validate(Criteria<Speakers> criteria) {
        for (Speakers key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("NUMBER_OF_SPEAKERS".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FREQUENCY_RANGE".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("CORD_LENGTH".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

}
