package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        //RANDOM CARS ATTRIBUTES----------------------------------------------------------------------------------------
        int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);
        int randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
        int randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
        int lastCarID = 0;
        Random rand = new Random();
        int randIndex = rand.nextInt(DefaultLists.producers.size());
        String randomProducer = DefaultLists.producers.get(randIndex);
        randIndex = rand.nextInt(DefaultLists.colors.size());
        String randomColor = DefaultLists.colors.get(randIndex);
        randIndex = rand.nextInt(DefaultLists.classifications.size());
        String randomClassification = DefaultLists.classifications.get(randIndex);
        int rand0to5 = ThreadLocalRandom.current().nextInt(0, 6);
        Boolean part1=true;
        Boolean part2=true;
        Boolean part3=true;
        Boolean part4=true;
        Boolean part5=true;
        switch(rand0to5)
        {
            case 0: part1=true;part2=true;part3=true;part4=true;part5=true;break;
            case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
            case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
            case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
            case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
            case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;
        }



        Player playerTaxes = new Player(1000000);
        Player player1 = new Player(1000);
        int randNewCars = ThreadLocalRandom.current().nextInt(5, 11);
        ArrayList<Car> startingCars = new ArrayList<Car>();
        //GENERATING RANDOM CARS----------------------------------------------------------------------------------------
        int i=0;
        while (i<randNewCars) {
            randMoney = ThreadLocalRandom.current().nextInt(200, 2800);
            randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
            randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
            randIndex = rand.nextInt(DefaultLists.producers.size());
            randomProducer = DefaultLists.producers.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.colors.size());
            randomColor = DefaultLists.colors.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.classifications.size());
            randomClassification = DefaultLists.classifications.get(randIndex);
            rand0to5 = ThreadLocalRandom.current().nextInt(0, 6);

            switch(rand0to5)
            {
                case 0: part1=true;part2=true;part3=true;part4=true;part5=true;break;
                case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
                case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
                case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
                case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
                case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;

            }
            Car startCar = new Car(i+1,randMoney,randomProducer,randMileage,randomColor,randomClassification,part1,part2,part3,part4,part5,randLoadingSpace,rand0to5);
            startingCars.add(startCar);
            i++;
            lastCarID=i;
        }
        //CLIENTS-------------------------------------------------------------------------------------------------------
        ArrayList<Client> clients = new ArrayList<Client>();
        String randomProducer1="";
        String randomProducer2="";
        Boolean destroyedCar=false;
        String typeOfCar="";
        int trueOrFalse = ThreadLocalRandom.current().nextInt(0, 2);
        for(int x=0;x<3;x++)
        {
            randMoney = ThreadLocalRandom.current().nextInt(1000, 2000);
            randIndex = rand.nextInt(DefaultLists.producers.size());
            randomProducer1 = DefaultLists.producers.get(randIndex);
            do {
                randIndex = rand.nextInt(DefaultLists.producers.size());
                randomProducer2 = DefaultLists.producers.get(randIndex);
            }while (randomProducer2==randomProducer1);
            var percent = Math.random();
            if(percent<0.9) destroyedCar=false;
            else destroyedCar=true;
            trueOrFalse = ThreadLocalRandom.current().nextInt(0, 2);
            if(trueOrFalse==0)  typeOfCar="Dostawczak";
            else typeOfCar="Osobowka";
            Client newStartingClient = new Client(randMoney,randomProducer1,randomProducer2,typeOfCar,destroyedCar);
            clients.add(newStartingClient);
            //System.out.println("Klient:"+x+clients.get(x)) ;
        }
        //MENU


        //startingCars.add(new Car(null,990,null,null,null,null,null,null, null,null,null,null,null));
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
                        ammountOfCars=(startingCars.size());
                        scan = new Scanner(System.in);
                        choseAfterStart=scan.nextInt();
                        tooExpensive:
                        switch (choseAfterStart)
                        {
                            case 1:
                                i=0;
                                System.out.println("Posiadasz:"+player1.getMoney());
                                for (Car moreCars:startingCars
                                ) {

                                    if(startingCars.get(i).price<100000) {
                                        System.out.println(startingCars.get(i).showBasicInfo());
                                    }
                                    i++;
                                }
                                break;
                            case 2:
                                i=0;
                                System.out.println("Posiadasz:"+player1.getMoney());
                                for (Car moreCars:startingCars)
                                {
                                    if(startingCars.get(i).price<100000) {
                                        System.out.println(startingCars.get(i));
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
                                    priceOfCar = startingCars.get(carID - 1).price;
                                    tax = startingCars.get(carID - 1).price * 2 / 100;
                                    if (priceOfCar + tax > player1.getMoney()) {
                                        System.out.println("Probujesz kuic auto na ktore cie nie stac.");
                                        break tooExpensive;
                                    }
                                    //startingCars.get(carID-1).IDOfSoldCar=carsInPlayerGarage;
                                    localcar=startingCars.get(carID-1);
                                    localcar.IDOfSoldCar=carsInPlayerGarage;
                                    //player1.setCar(startingCars.get(carID - 1));//TODO: check if index is available
                                    player1.setCar(localcar);
                                    Car emptyCar=new Car(carID-1,1000000,null,null,null,null,null,null, null,null,null,100,null);
                                    startingCars.set(carID - 1, emptyCar);//W przypadku kupna auta o id 0 w to miejsce umiescilo obiekt wyzej/nizej np.id1(ArrayList)
                                    player1.setMoney(player1.getMoney() - priceOfCar);
                                    playerTaxes.setMoney(playerTaxes.getMoney() + priceOfCar);
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
                                for(int allClients=0;allClients<clients.size();allClients++) {
                                    System.out.println("Klient:" + (allClients+1) + clients.get(allClients));
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
                                    for (loopForSellingCar=0;loopForSellingCar<clients.size();loopForSellingCar++)
                                    {
                                        System.out.println("Klient:" + (loopForSellingCar+1) + clients.get(loopForSellingCar));
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
                                    priceOfCar = player1.getCar(carID - 1).price;
                                    tax = player1.getCar(carID - 1).price * 2 / 100;
                                    localcar = player1.getCar(carID - 1);
                                    if(localcar.loadingSpace>60) smallOrBigCar="Dostawczak";
                                    else smallOrBigCar="Osobowka";
                                    if((priceOfCar+tax)>clients.get(chosenClient-1).money)
                                    {
                                        System.out.println("Klienta nie stać na to auto.");
                                    }
                                    else if(clients.get(chosenClient-1).producer1!=localcar.producer||clients.get(chosenClient-1).producer2!=localcar.producer)
                                    {
                                        System.out.println("Klinet nie kupi pojazdu tej marki.");
                                    }
                                    else if(clients.get(chosenClient-1).destroyedCar==true)
                                    {
                                        System.out.println("Klient nie kupi uszkodzonego auta.");
                                          /*  TODO:make 1% that client will buy destroyed car
                                            TODO:make 10% that client will buy car with destroyed suspension*/
                                    }
                                    else if(clients.get(chosenClient-1).typeOfCar!=smallOrBigCar)
                                    {
                                        System.out.println("Klient nie kupi tego typu auta.");
                                    }
                                    else
                                    {
                                        clients.get(chosenClient - 1).fieldOfCars.add(localcar);
                                        player1.removeCar(localcar);
                                        carsInPlayerGarage--;
                                        clientMoney = clients.get(chosenClient - 1).money;
                                        clientMoney = clientMoney - (priceOfCar + tax);
                                        clients.get(chosenClient - 1).money = clientMoney;
                                        //clients.get(chosenClient-1).money=clients.get(chosenClient-1).money-(priceOfCar-tax);
                                        System.out.println(clients.get(chosenClient - 1).money);
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
                            default:
                                System.out.println("Podano bledna wartosc, sprobuj ponownie");
                                break;
                        }

                    }while (2000>player1.getMoney());

                    while (2000>player1.getMoney());
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

