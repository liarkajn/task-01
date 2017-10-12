package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.criteria.Criteria;

public interface CommandValidator<T> {

    boolean validate(Criteria<T> criteria);

}