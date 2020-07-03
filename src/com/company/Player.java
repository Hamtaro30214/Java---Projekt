package com.company;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer money;
    private ArrayList<Car> garage;

    public Player(Integer money)
    {
        this.money=money;
        this.garage=new ArrayList<Car>();
    }

    public Car getCar(int placeInGarage)
    {
        return this.garage.get(placeInGarage);
    }
    public void setCar(Car car)
    {
        this.garage.add(car);
    }
    public void removeCar(Car car)
    {
        this.garage.remove(car);
    }
    public Integer getMoney()
    {
        return this.money;
    }
    public void setMoney(Integer newMoney)
    {
        this.money=newMoney;
    }

    public String toString()
    {
        return " Gotowka: " + money;
    }



}
