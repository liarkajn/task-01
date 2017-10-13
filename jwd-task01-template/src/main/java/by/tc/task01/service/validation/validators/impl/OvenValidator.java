package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class OvenValidator implements CommandValidator<Oven> {

    public boolean validate(Criteria<Oven> criteria) {
        for (Oven key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("WEIGHT".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("DEPTH".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("HEIGHT".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("WIDTH".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

}
