package by.tc.task01.dao.handler;

import by.tc.task01.entity.Appliance;

import java.util.Map;

public abstract class Handler<E> {

    private Map<E, Object> criteria;

    public Handler(Map<E, Object> criteria) {
        this.criteria = criteria;
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }

    public void setCriteria(Map<E, Object> criteria) {
        this.criteria = criteria;
    }

    abstract public boolean checkString(String str);

    abstract public Appliance execute(String str);

}
