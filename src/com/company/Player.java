package com.company;

import java.security.PublicKey;

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

    public String toString()
    {
        return " Gotowka: " + money;
    }



    public void startGame()
    {
        label1:
        System.out.println("Wybierz 1 aby zobaczyc samochody do kupna z podstawowymi informacjami.");
        System.out.println("Wybierz 2 aby szczegolowe informacje o samochodach do kupna.");
    }
}

