package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Client  {

    public Integer money;
    public String producer1;
    public String producer2;
    public String typeOfCar;
    public Boolean destroyedCar;
    public Boolean destroyedSuspension;
    public ArrayList<Car> fieldOfCars;
    public Client(Integer money, String producer1, String producer2,String typeOfCar, Boolean destroyedCar)
    {
        this.money=money;
        this.producer1=producer1;
        this.producer2=producer2;
        this.typeOfCar=typeOfCar;
        this.destroyedCar=destroyedCar;
        this.fieldOfCars=new ArrayList<Car>();
    }
    public String toString()
    {
        return ", Gotowka:" + money+", Lubiana marka:"  + producer1 +", Lubiana marka: "+ producer2 + ", Typ samochodu:"
                + typeOfCar+ ", Uszkodzony:" + destroyedCar;
    }

}
