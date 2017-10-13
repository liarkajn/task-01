package by.tc.task01.service.validation.validators.impl;

class DoubleValidator {

    static boolean validateDouble(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!Number.class.isInstance(obj)) {
            return false;
        }
        double powerConsumption = Double.valueOf(obj.toString());
        if (powerConsumption < 0) {
            return false;
        }
        return true;
    }

}
