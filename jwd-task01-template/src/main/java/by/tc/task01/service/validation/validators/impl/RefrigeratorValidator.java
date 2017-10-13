package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class RefrigeratorValidator implements CommandValidator<Refrigerator> {

    public boolean validate(Criteria<Refrigerator> criteria) {
        for (Refrigerator key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("WEIGHT".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FREEZER_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("OVERALL_CAPACITY".equalsIgnoreCase(key.toString())) {
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
