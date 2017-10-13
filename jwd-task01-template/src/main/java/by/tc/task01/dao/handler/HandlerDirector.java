package by.tc.task01.dao.handler;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.dao.handler.impl.*;
import by.tc.task01.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;

public class HandlerDirector {

    private Map<String, Handler> map = new HashMap<String, Handler>();

    public <E> HandlerDirector(Criteria<E> criteria) {
        map.put("Laptop", new LaptopHandler((Map<Laptop, Object>) criteria.getCriteria()));
        map.put("Oven", new OvenHandler((Map<Oven, Object>) criteria.getCriteria()));
        map.put("Refrigerator", new RefrigeratorHandler((Map<Refrigerator, Object>) criteria.getCriteria()));
        map.put("Speakers", new SpeakersHandler((Map<Speakers, Object>) criteria.getCriteria()));
        map.put("TabletPC", new TabletPCHandler((Map<TabletPC, Object>) criteria.getCriteria()));
        map.put("VacuumCleaner", new VacuumCleanerHandler((Map<VacuumCleaner, Object>) criteria.getCriteria()));
    }

    public Handler getHandler(String typeName) {
        Handler handler;
        handler = map.get(typeName);
        return handler;
    }

}
