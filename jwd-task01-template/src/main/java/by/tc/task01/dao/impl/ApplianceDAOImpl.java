package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.handler.Handler;
import by.tc.task01.dao.handler.HandlerDirector;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ApplianceDAOImpl implements ApplianceDAO{

    private static final String filename = "./src/main/resources/appliances_db.txt";
    private Handler handler;

	public <E> Appliance find(Criteria<E> criteria) {
        HandlerDirector handlerDirector = new HandlerDirector(criteria);
        handler = handlerDirector.getHandler(criteria.getApplianceType());
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
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    if (handler.checkString(line)) {
                        return line;
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