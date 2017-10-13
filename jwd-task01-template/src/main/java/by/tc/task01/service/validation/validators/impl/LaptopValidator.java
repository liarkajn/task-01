package by.tc.task01.service.validation.validators.impl;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class LaptopValidator implements CommandValidator<SearchCriteria.Laptop> {

    public boolean validate(Criteria<SearchCriteria.Laptop> criteria) {
        for (SearchCriteria.Laptop key :criteria.getCriteria().keySet()) {
            if ("BATTERY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("OS".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("MEMORY_ROM".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("SYSTEM_MEMORY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("CPU".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("DISPLAY_INCHS".equalsIgnoreCase(key.toString())) {
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
