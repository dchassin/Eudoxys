package com.stanford.slac.eudoxystest.Models;



public class Gridlabd {
    String air_temp;
    String outdoor_temp;
    String heating_setpoint;
    String cooling_setpoint;
    String mode;

    public String getOutdoor_temp() {
        return outdoor_temp;
    }

    public void setOutdoor_temp(String outdoor_temp) {
        this.outdoor_temp = outdoor_temp;
    }

    public String getHeating_setpoint() {
        return heating_setpoint;
    }

    public void setHeating_setpoint(String heating_setpoint) {
        this.heating_setpoint = heating_setpoint;
    }

    public String getCooling_setpoint() {
        return cooling_setpoint;
    }

    public void setCooling_setpoint(String cooling_setpoint) {
        this.cooling_setpoint = cooling_setpoint;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }




    public String getAir_temp() {
        return air_temp;
    }

    public void setAir_temp(String air_temp) {
        this.air_temp = air_temp;
    }
}
