package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

	public <E> Appliance find(Criteria<E> criteria) {
		if (criteria.getCriteria().size() == 0 || !Validator.criteriaValidator(criteria)) {
			System.out.println("empty or criteria");
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		return applianceDAO.find(criteria);
	}

}
