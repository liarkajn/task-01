package by.tc.task01.service.validation.validators.impl;

import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class TabletPCValidator implements CommandValidator<TabletPC> {

    public boolean validate(Criteria<TabletPC> criteria) {
        for (TabletPC key :criteria.getCriteria().keySet()) {
            if ("BATTERY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("DISPLAY_INCHES".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("MEMORY_ROM".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FLASH_MEMORY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!DoubleValidator.validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("COLOR".equalsIgnoreCase(key.toString())) {
                if (criteria.getCriteria().get(key) == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
