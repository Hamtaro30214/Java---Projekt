package com.company;

import java.util.ArrayList;

public class Player {
    private Integer money;
    private final ArrayList<Car> garage;

    public Player(Integer money) {
        this.money=money;
        this.garage = new ArrayList<Car>();
    }

    public Car getCar(Integer placeInGarage) {return this.garage.get(placeInGarage);}
    public void setCar(Car car) {this.garage.add(car);}
    public void changeCar(Integer placeInGarage, Car car){this.garage.set(placeInGarage,car);}
    public Integer getMoney() {return this.money;}
    public void setMoney(Integer newMoney) {this.money=newMoney;}
}