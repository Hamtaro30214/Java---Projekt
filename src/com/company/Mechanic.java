package com.company;

public class Mechanic {
    public Integer mechanicID;
    public Integer brakesCost;
    public Integer suspensionCost;
    public Integer engineCost;
    public Integer bodyCost;
    public Integer gearboxCost;
    public Mechanic(Integer mechanicID,Integer brakesCost, Integer suspensionCost, Integer engineCost, Integer bodyCost, Integer gearboxCost) {
        this.mechanicID=mechanicID;
        this.brakesCost=brakesCost;
        this.suspensionCost=suspensionCost;
        this.engineCost=engineCost;
        this.bodyCost=bodyCost;
        this.gearboxCost=gearboxCost;
    }
}
