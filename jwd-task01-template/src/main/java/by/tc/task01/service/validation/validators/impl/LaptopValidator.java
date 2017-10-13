package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class LaptopValidator implements CommandValidator<Laptop> {

    public boolean validate(Criteria<Laptop> criteria) {
        for (Laptop key :criteria.getCriteria().keySet()) {
            if ("BATTERY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("OS".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("MEMORY_ROM".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("SYSTEM_MEMORY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("CPU".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("DISPLAY_INCHS".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

}
