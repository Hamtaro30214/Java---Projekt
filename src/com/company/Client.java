package com.company;

public class Client extends Player  {
    public Integer clientID;
    public String producer1;
    public String producer2;
    public String typeOfCar;
    public Boolean destroyedCar;
    public Boolean destroyedSuspension;

    public Client(Integer money,Integer clientID,String producer1, String producer2,String typeOfCar, Boolean destroyedCar) {
        super(money);
        this.clientID=clientID;
        this.producer1=producer1;
        this.producer2=producer2;
        this.typeOfCar=typeOfCar;
        this.destroyedCar=destroyedCar;
    }

    public void addClients(Integer numberOfClients) {
        System.out.println("Works?");
    }
    public String toString() {
        var percent = Math.random();
        destroyedSuspension = !(percent < 0.7);
        if(destroyedSuspension==true) {
            return "Klient " + (clientID + 1) + ". Gotówka:" + super.getMoney() + ", Lubiane marki:" + producer1 + "," + producer2 + " Typ samochodu:"
                    + typeOfCar + ", Uszkodzone zawieszenie:" + destroyedSuspension;
        }
        else {
            return "Klient " + (clientID + 1) + ". Gotówka:" + super.getMoney() + ", Lubiane marki:" + producer1 + "," + producer2 + " Typ samochodu:"
                    + typeOfCar + ", Uszkodzony:" + destroyedCar;
        }
    }
}