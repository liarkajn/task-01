package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.handler.*;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO{

    private static final String filename = "./src/main/resources/appliances_db.txt";

    private Handler handler;

	public <E> Appliance find(Criteria<E> criteria) {

        String applianceType = criteria.getApplianceType();
        if ("Laptop".equals(applianceType)) {
            handler = new LaptopHandler((Map<SearchCriteria.Laptop, Object>) criteria.getCriteria());
        } else if ("Oven".equals(applianceType)) {
            handler = new OvenHandler((Map<SearchCriteria.Oven, Object>) criteria.getCriteria());
        } else if ("Refrigerator".equals(applianceType)) {
            handler = new RefrigeratorHandler((Map<SearchCriteria.Refrigerator, Object>) criteria.getCriteria());
        } else if ("Speakers".equals(applianceType)) {
            handler = new SpeakersHandler((Map<SearchCriteria.Speakers, Object>) criteria.getCriteria());
        } else if ("TabletPC".equals(applianceType)) {
            handler = new TabletPCHandler((Map<SearchCriteria.TabletPC, Object>) criteria.getCriteria());
        } else if ("VacuumCleaner".equals(applianceType)) {
            handler = new VacuumCleanerHandler((Map<SearchCriteria.VacuumCleaner, Object>) criteria.getCriteria());
        }

	    return findFile(filename);
	}
	
	private Appliance findFile(String filename) {
        File path = new File(filename);
        String result = readFile(path);
        return result != null ? handler.execute(result) : null;
	}

	private String readFile(File file) {
	    try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                s = s.trim();
                if (s.length() > 0) {
                    if (handler.handle(s)) {
                        return s;
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Problems with file");
        }
        return null;
    }

}