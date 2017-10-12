package by.tc.task01.service.validation.validators;

import by.tc.task01.service.validation.validators.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ValidatorDirector {

    private Map<String, CommandValidator> map = new HashMap<String, CommandValidator>();

    public ValidatorDirector() {
        map.put("Laptop", new LaptopValidator());
        map.put("Oven", new OvenValidator());
        map.put("Refrigerator", new RefrigeratorValidator());
        map.put("Speakers", new SpeakersValidator());
        map.put("TabletPC", new TabletPCValidator());
        map.put("VacuumCleaner", new VacuumCleanerValidator());
    }

    public CommandValidator getCommand(String typeName) {
        CommandValidator command;
        command = map.get(typeName);
        return command;
    }

}
