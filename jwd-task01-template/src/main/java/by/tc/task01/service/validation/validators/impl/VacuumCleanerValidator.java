package by.tc.task01.service.validation.validators.impl;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class VacuumCleanerValidator implements CommandValidator<SearchCriteria.VacuumCleaner> {

    public boolean validate(Criteria<SearchCriteria.VacuumCleaner> criteria) {
        for (SearchCriteria.VacuumCleaner key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FILTER_TYPE".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("BAG_TYPE".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("WAND_TYPE".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            } else if ("MOTOR_SPEED_REGULATION".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("CLEANING_WIDTH".equalsIgnoreCase(key.toString())) {
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
