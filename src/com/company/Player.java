package com.company;

import java.security.PublicKey;
import java.util.ArrayList;

public class Player {
    private Integer money;
    private Car[] garage;

    public Player(Integer money)
    {
        this.money=money;
        this.garage=new Car[100];
    }

    public Car getCar(int placeInGarage)
    {
        return this.garage[placeInGarage];
    }
    public void setCar(Car car, int placeInGarage)
    {
        this.garage[placeInGarage]=car;
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
