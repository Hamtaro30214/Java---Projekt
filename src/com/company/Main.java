package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        //RANDOM CARS ATTRIBUTES----------------------------------------------------------------------------------------
        int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);
        Player player1 = new Player(1000);
        int rand0to5 = ThreadLocalRandom.current().nextInt(0, 6);
        int randNewCars = ThreadLocalRandom.current().nextInt(5, 11);
        /*Car emptyCar=new Car(0,1000000,null,null,null,null,null,null, null,null,null,100,null);
        Car emptyCar1=new Car(1,1000000,null,null,null,null,null,null, null,null,null,100,null);
        player1.setCar(emptyCar);
        DefaultLists.clients.get(0).setCar(emptyCar1);*/
        //MENU
        Integer menuChose = 0;
        Integer choseAfterStart=0;
        Integer playerMoney=1000;
        Integer carID = 0;
        Integer ammountOfCars=0;
        Integer tax=0;
        Integer priceOfCar=0;
        Boolean playerMove=false;
        Integer carsInPlayerGarage=0;
        Integer chosenClient=0;
        Car localcar;
        Integer clientMoney=0;
        Integer moves=0;
        Integer adChose=0;
        Integer randNewspaper=ThreadLocalRandom.current().nextInt(1, 4);;
        Integer i=0;
        String smallOrBigCar;
        do {
            System.out.println();
            System.out.println("Witaj w grze AutoHandel.");
            System.out.println("Wybierz 1 aby rozpoczac gre.");
            System.out.println("wybierz 2 aby zapoznac sie z zasadami gry.");
            System.out.println("Wybierz 3 aby wyjsc.");
            Scanner scan = new Scanner(System.in);
            menuChose = scan.nextInt();
            switch (menuChose) {
                case 1:
                    System.out.println("Start gry");
                    do {
                        System.out.println("Wybierz 1 aby zobaczyc samochody do kupna z podstawowymi informacjami.");
                        System.out.println("Wybierz 2 aby szczegolowe informacje o samochodach do kupna.");
                        System.out.println("Wybierz 3 aby kupic jedno auto.");
                        System.out.println("Wybierz 4 aby zobaczyc posiadane pojazdy.");
                        System.out.println("Wybierz 5 aby zobaczyc stan konta.");
                        System.out.println("Wybierz 6 aby naprawic samochod.");
                        System.out.println("Wybierz 7 aby zobaczyc potencjalnych klientow.");
                        System.out.println("Wybierz 8 aby sprzedac auto klientowi.");
                        System.out.println("wybierz 9 aby kupic reklame.");
                        System.out.println("Wybierz 13 aby zakonczyc ture.");
                        System.out.println("Wybierz 14 aby wyjsc.");
                        ammountOfCars=(DefaultLists.carsToBuy.size());
                        scan = new Scanner(System.in);
                        choseAfterStart=scan.nextInt();
                        tooExpensive:
                        switch (choseAfterStart)
                        {
                            case 1:
                                i=0;
                                System.out.println("Posiadasz:"+player1.getMoney());
                                for (Car moreCars:DefaultLists.carsToBuy
                                ) {

                                    if(DefaultLists.carsToBuy.get(i).getPrice()<100000) {
                                        System.out.println(DefaultLists.carsToBuy.get(i).showBasicInfo());
                                    }
                                    i++;
                                }
                                break;
                            case 2:
                                i=0;
                                System.out.println("Posiadasz:"+player1.getMoney());
                                for (Car moreCars:DefaultLists.carsToBuy)
                                {
                                    if(DefaultLists.carsToBuy.get(i).getPrice()<100000) {
                                        System.out.println(DefaultLists.carsToBuy.get(i));
                                    }
                                    i++;
                                }
                                break;
                            case 3:
                                if(playerMove==true)
                                {
                                    System.out.println("Mozliwosc niemozliwa w tej turze.");
                                }
                                else {
                                    System.out.println("Podaj identyfikator pojazdu ktory chcesz kupic.");
                                    scan = new Scanner(System.in);
                                    carID = scan.nextInt();
                                    priceOfCar = DefaultLists.carsToBuy.get(carID - 1).getPrice();
                                    tax = DefaultLists.carsToBuy.get(carID - 1).getPrice() * 2 / 100;
                                    if (priceOfCar + tax > player1.getMoney()) {
                                        System.out.println("Probujesz kuic auto na ktore cie nie stac.");
                                        break tooExpensive;
                                    }
                                    //startingCars.get(carID-1).IDOfSoldCar=carsInPlayerGarage;
                                    localcar=DefaultLists.carsToBuy.get(carID-1);
                                    localcar.IDOfSoldCar=carsInPlayerGarage;
                                    //player1.setCar(startingCars.get(carID - 1));//TODO: check if index is available
                                    player1.setCar(localcar);
                                    Car emptyCar=new Car(carID-1,1000000,null,null,null,null,null,null, null,null,null,100,null);
                                    DefaultLists.carsToBuy.set(carID - 1, emptyCar);//W przypadku kupna auta o id 0 w to miejsce umiescilo obiekt wyzej/nizej np.id1(ArrayList)
                                    player1.setMoney(player1.getMoney() - priceOfCar);
                                    player1.setMoney(player1.getMoney() - tax);
                                    System.out.println("Kupiono auto za:" + (priceOfCar + tax));
                                    carsInPlayerGarage++;
                                    moves++;
                                    playerMove = true;
                                }
                                break;
                            case 4:
                                if(carsInPlayerGarage==0) {
                                    System.out.println("Nie posiadasz pojazdow.");
                                }
                                else {
                                    for (int allCars = 0; allCars < carsInPlayerGarage; allCars++)
                                        System.out.println(player1.getCar(allCars));//missing override
                                }
                                break;
                            case 5:
                                System.out.println("Posiadasz:"+player1.getMoney());
                                break;
                            case 6:
                                if(playerMove==true)
                                {
                                    System.out.println("Mozliwosc niemozliwa w tej turze.");
                                }
                                else
                                {
                                    System.out.println("Wybierz jednego z ponizszych machanikow.");
                                    System.out.println("1. Janusz - ma najdrozsze ceny ale 100% gwarancj.");
                                    System.out.println("2. Marian - bierze zdecydowanie mniej niz Janusz, ale masz 10% szans, ze nie uda mu sie naprawic samochodu i konieczna będzie interwencja Janusza.");
                                    System.out.println("3. Adrian - jest najtanszy, ale masz 20% szans, ze nie uda mu się naprawic i 2% szans, ze zepsuje cos innego podczas naprawy.");
                                    playerMove=true;
                                    moves++;
                                }
                                break;
                            case 7:
                                for(int allClients=0;allClients<DefaultLists.clients.size();allClients++) {
                                    System.out.println("Klient:" + (allClients+1) + DefaultLists.clients.get(allClients));
                                }
                                break;
                            case 8:
                                if(playerMove==true)
                                {
                                    System.out.println("Nie dostepne w tej turze.");
                                }
                                else if(carsInPlayerGarage==0) {
                                    System.out.println("Nie posiadasz pojazdow.");
                                }
                                else {
                                    System.out.println();
                                    int loopForSellingCar=0;
                                    for (loopForSellingCar=0;loopForSellingCar<DefaultLists.clients.size();loopForSellingCar++)
                                    {
                                        System.out.println("Klient:" + (loopForSellingCar+1) + DefaultLists.clients.get(loopForSellingCar));
                                    }
                                    loopForSellingCar=0;
                                    System.out.println("Podaj ID klienta ktoremu chcesz sprzedac auto.");
                                    scan = new Scanner(System.in);
                                    chosenClient = scan.nextInt();
                                    for (loopForSellingCar = 0; loopForSellingCar < carsInPlayerGarage; loopForSellingCar++)
                                    {
                                        System.out.println(player1.getCar(loopForSellingCar).playersCarsBasic());
                                    }
                                    System.out.println("Podaj ID auta ktore chcesz sprzedac.");
                                    scan = new Scanner(System.in);
                                    carID = scan.nextInt();
                                    priceOfCar = player1.getCar(carID - 1).getPrice();
                                    tax = player1.getCar(carID - 1).getPrice() * 2 / 100;
                                    localcar = player1.getCar(carID - 1);
                                    if(localcar.loadingSpace>60) smallOrBigCar="Dostawczak";
                                    else smallOrBigCar="Osobowka";
                                    if((priceOfCar+tax)>DefaultLists.clients.get(chosenClient-1).getMoney())
                                    {
                                        System.out.println("Klienta nie stać na to auto.");
                                    }
                                    else if(DefaultLists.clients.get(chosenClient-1).producer1!=localcar.producer||DefaultLists.clients.get(chosenClient-1).producer2!=localcar.producer)
                                    {
                                        System.out.println("Klinet nie kupi pojazdu tej marki.");
                                    }
                                    else if(DefaultLists.clients.get(chosenClient-1).destroyedCar==true)
                                    {
                                        System.out.println("Klient nie kupi uszkodzonego auta.");
                                                 /*  TODO:make 1% that client will buy destroyed car
                                                TODO:make 10% that client will buy car with destroyed suspension*/

                                    }
                                    else if(DefaultLists.clients.get(chosenClient-1).typeOfCar!=smallOrBigCar)
                                    {
                                        System.out.println("Klient nie kupi tego typu auta.");
                                    }
                                    else
                                    {
                                        DefaultLists.clients.get(chosenClient - 1).setCar(localcar);
                                        player1.removeCar(localcar);
                                        carsInPlayerGarage--;
                                        clientMoney = DefaultLists.clients.get(chosenClient - 1).getMoney();
                                        clientMoney = clientMoney - (priceOfCar + tax);
                                        //DefaultLists.clients.get(chosenClient - 1).getMoney() = clientMoney;TODO:setMoney
                                        //clients.get(chosenClient-1).money=clients.get(chosenClient-1).money-(priceOfCar-tax);
                                        System.out.println(DefaultLists.clients.get(chosenClient - 1).getMoney());
                                        player1.setMoney(player1.getMoney() + priceOfCar - tax);
                                        System.out.println("Klient kupił auto za:" + priceOfCar);
                                        playerMove = true;
                                        moves++;
                                    }
                                }
                                break;
                            case 9:
                                System.out.println("Wybierz 1 aby kupic kampanie marketingotwa za 250$(+2 klientow)");
                                System.out.println("Wybierz 2 aby kupic ogloszenie w lokalnej gaziecie za 200$(+(1-3)klientow");
                                System.out.println("Wybierz 3 aby kupic remklame w internecie za 150$(+1 klien)");
                                scan = new Scanner(System.in);
                                adChose = scan.nextInt();
                                switch (adChose)
                                {
                                    case 1:
                                        if (player1.getMoney() < 250) {
                                            System.out.println("Nie stac cie.");
                                        } else {
                                            player1.setMoney(player1.getMoney() - 250);
                                            System.out.println("Kupiles kampanie reklamowa i zyskales 2 klientow.");
                                        }
                                        break;
                                    case 2:
                                        if (player1.getMoney() < 200)
                                        {
                                            System.out.println("Nie stac cie.");
                                        }
                                        else {
                                            player1.setMoney(player1.getMoney()-200);
                                            randNewspaper= ThreadLocalRandom.current().nextInt(1, 4);
                                            System.out.println("Kupiles "+randNewspaper+" klienta/klientow.");
                                        }
                                        break;
                                    case 3:
                                        if (player1.getMoney() < 150)
                                        {
                                            System.out.println("Nie stac cie.");
                                        }
                                        else {
                                            player1.setMoney(player1.getMoney() - 150);
                                            System.out.println("Kupiles 1 klienta.");
                                        }
                                        break;
                                    default:
                                        System.out.println("Podano bledna wartosc.");
                                        break;
                                }
                                break;
                            case 13:
                                playerMove=false;
                                System.out.println("Nastepna tura.");
                                //+2 startingCars
                                break;
                            case 14:
                                break;
                            default:
                                System.out.println("Podano bledna wartosc, sprobuj ponownie");
                                break;
                        }
                    }while (2000>player1.getMoney()||choseAfterStart!=14);
                    while (2000>player1.getMoney()||choseAfterStart!=14);
                    break;
                case 2:
                    System.out.println("Celem gry jest podwojenie poczatkowej gotowki w jak najmniejszej ilczbie ruchow.Jeden ruch to zakup auta/sprzedaz auta/naprawienie jednego elementu/dodanie jednej reklamy. Przeglądanie stanu konta, historii transakcji, baz klientow, posiadanych pojazdow i pojazdow dostępnych do kupienia nie oznacza wykorzystania ruchu.");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Podano bledna wartosc, sprobuj ponownie");
                    break;

            }
        }
        while (menuChose!=3) ;

         /*Now issues:
        1. There is chance that player won't have enought money for any car.
        2. Limit of 100 cars in garage for a player.
        3. Same things always break, no space between them.
        4. Too many random variables.
        5. Not using Double in variables.
        6. No washing for cars.
        7. Player can't sell cars that are destroyed.
        8. Car after buy isn't removed from list, just change for a car that can't be bought.
        9. No private variables in class Clients, especially money and list of cars.
        10. Variables aren't private or protected.
         .*/

    }
}

