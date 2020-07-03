package com.company;

import java.security.PublicKey;

public class Player {
    public  Integer playerID;
    private Integer money;
    private Car[] garage;

    public Player(Integer playerID, Integer money)
    {
        this.playerID=playerID;
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
}

