package by.tc.task01.dao.handler;

import by.tc.task01.entity.Appliance;

import java.util.Map;

public abstract class Handler<E> {

    Map<E, Object> criteria;

    Handler(Map<E, Object> criteria) {
        this.criteria = criteria;
    }

    abstract public boolean handle(String str);

    abstract public Appliance execute(String str);

}
