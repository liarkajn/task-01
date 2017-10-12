package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CommandValidator;
import by.tc.task01.service.validation.validators.ValidatorDirector;

public class Validator {

    public static ValidatorDirector validatorDirector = new ValidatorDirector();
	
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        CommandValidator validator = validatorDirector.getCommand(criteria.getApplianceType());
		return validator.validate(criteria);
	}

}