package com.company;

import java.security.PublicKey;

public class Player {
    public  Integer playerID;
    private Double money;
    /* private Double money=1500.0;*/
    private Car[] garage;

    /*public Player(Car[] garage) {
        this.garage = garage;
    }*/

    public Player(Integer playerID, Double money)
    {
        this.playerID=playerID;
        this.money=money;
        this.garage=new Car[0];
    }
}

