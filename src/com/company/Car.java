package com.company;

public class Car {
    private Integer price;
    public Integer carID;
    public String producer;
    public Integer mileage;
    public String color;
    public String classification;
    public Boolean brakesStatus;
    public Boolean suspensionStatus;
    public Boolean engineStatus;
    public Boolean bodyStatus;
    public Boolean gearboxStatus;
    public Integer loadingSpace;
    public Integer amountOfDestroyedParts;
    public Integer IDOfSoldCar;

    public Car(Integer carID, Integer price, String producer, Integer mileage, String color, String classification,
               Boolean brakesStatus, Boolean suspensionStatus, Boolean engineStatus, Boolean bodyStatus,
               Boolean gearboxStatus, Integer loadingSpace, Integer amountOfDestroyedParts) {
        this.carID = carID;
        this.price = price;
        this.producer = producer;
        this.mileage = mileage;
        this.color = color;
        this.classification = classification;
        this.brakesStatus = brakesStatus;
        this.suspensionStatus = suspensionStatus;
        this.engineStatus = engineStatus;
        this.bodyStatus = bodyStatus;
        this.gearboxStatus = gearboxStatus;
        this.loadingSpace = loadingSpace;
        this.amountOfDestroyedParts = amountOfDestroyedParts;
    }

    public Integer getPrice() {return this.price;}
    public void setPrice(Integer cost) {this.price=cost;}
    public String toString() {
        String space;
        if (loadingSpace > 60) space = ", Dostawczak";
        else  space = ", Osobówka";
        return carID + ". Cena:" + price + "$, Producent:" + producer + ", Przebieg:" + mileage + "km, Kolor:" + color +
                ", Segment:" + classification + space+", Status hamulców:" + brakesStatus +", Status zawieszenia:" +
                suspensionStatus + ", Status silnika:" + engineStatus + ", Status koreserii:" + bodyStatus +
                ", Status skrzyni biegów:" + gearboxStatus;
    }
    public String showBasicInfo() {
        return carID + ". Cena:" + price + "$, Producent:" + producer + ", Segment:" + classification +
                ", Zepsute części:" + amountOfDestroyedParts;
    }
    public String playersCarsBasic() {
        return (IDOfSoldCar+1)+". Cena:"+price +"$, Producent:"+producer+", Segment:"+classification+
                ", Zepsute czesci:"+amountOfDestroyedParts;
    }
}