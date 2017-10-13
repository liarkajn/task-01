package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class VacuumCleanerValidator implements CommandValidator<VacuumCleaner> {

    public boolean validate(Criteria<VacuumCleaner> criteria) {
        for (VacuumCleaner key :criteria.getCriteria().keySet()) {
            if ("POWER_CONSUMPTION".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
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
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("CLEANING_WIDTH".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

}
