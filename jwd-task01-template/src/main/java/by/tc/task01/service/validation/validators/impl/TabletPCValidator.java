package by.tc.task01.service.validation.validators.impl;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CommandValidator;

public class TabletPCValidator implements CommandValidator<SearchCriteria.TabletPC> {

    public boolean validate(Criteria<SearchCriteria.TabletPC> criteria) {
        for (SearchCriteria.TabletPC key :criteria.getCriteria().keySet()) {
            if ("BATTERY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("DISPLAY_INCHES".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("MEMORY_ROM".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
                    return false;
                }
            } else if ("FLASH_MEMORY_CAPACITY".equalsIgnoreCase(key.toString())) {
                if (!validateDouble(criteria.getCriteria().get(key))) {
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

    private boolean validateDouble(Object obj) {
        if (null == obj) {
            return false;
        }
        if (Number.class.isInstance(obj.getClass())) {
            return false;
        }
        double powerConsumption = Double.valueOf(obj.toString());
        if (powerConsumption < 0) {
            return false;
        }
        return true;
    }

}
