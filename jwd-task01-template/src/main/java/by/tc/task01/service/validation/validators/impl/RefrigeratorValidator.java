package by.tc.task01.service.validation.validators.impl;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class RefrigeratorValidator implements CommandValidator<SearchCriteria.Refrigerator> {

    public boolean validate(Criteria<SearchCriteria.Refrigerator> criteria) {
        for (SearchCriteria.Refrigerator key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("WEIGHT".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FREEZER_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("OVERALL_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("HEIGHT".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("WIDTH".equalsIgnoreCase(key.toString())) {
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
