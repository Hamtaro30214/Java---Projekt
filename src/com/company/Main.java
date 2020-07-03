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
        Random rand = new Random();
        int randIndex = rand.nextInt(DefaultLists.producers.size());
        String randomProducer = DefaultLists.producers.get(randIndex);
        randIndex = rand.nextInt(DefaultLists.colors.size());
        String randomColor = DefaultLists.colors.get(randIndex);
        randIndex = rand.nextInt(DefaultLists.classifications.size());
        String randomClassification = DefaultLists.classifications.get(randIndex);
        int rand1to5 = ThreadLocalRandom.current().nextInt(1, 6);
        Boolean part1=true;
        Boolean part2=true;
        Boolean part3=true;
        Boolean part4=true;
        Boolean part5=true;
        switch(rand1to5)
        {
            case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
            case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
            case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
            case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
            case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;
        }



        Player taxes = new Player(1000000);
        Player player1 = new Player(1000);
        int randCars = ThreadLocalRandom.current().nextInt(5, 11);
        Car[] startingCars = new Car[randCars];
        //public List<Car> newCars = new List<Car>();
        //GENERATING RANDOM CARS----------------------------------------------------------------------------------------
        int i=0;
        while (i<startingCars.length) {
            randMoney = ThreadLocalRandom.current().nextInt(500, 3000);
            randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
            randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
            randIndex = rand.nextInt(DefaultLists.producers.size());
            randomProducer = DefaultLists.producers.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.colors.size());
            randomColor = DefaultLists.colors.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.classifications.size());
            randomClassification = DefaultLists.classifications.get(randIndex);
            rand1to5 = ThreadLocalRandom.current().nextInt(1, 6);

            switch(rand1to5)
            {
                case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
                case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
                case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
                case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
                case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;
            }
            var newCar = new Car(i+1,randMoney,randomProducer,randMileage,randomColor,randomClassification,part1,part2,part3,part4,part5,randLoadingSpace,rand1to5);
            startingCars[i] = newCar;
            //System.out.println(startingCars[i]);
            i++;
        }
        //CLIENTS-------------------------------------------------------------------------------------------------------
        List<Client> clients = new ArrayList<Client>();
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
        //TEST CODE-----------------------------------------------------------------------------------------------------



        //MENU
        Integer menuChose = 0;
        Integer choseAfterStart=0;
        /*Integer playerMoney=1000;*/
        Integer carID = 0;
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
                        System.out.println("Wybierz 4 aby wyjsc.");
                        ammountOfCars=(startingCars.length);
                        scan = new Scanner(System.in);
                        choseAfterStart=scan.nextInt();
                        switch (choseAfterStart)
                        {
                            case 1:
                                i=0;
                                for (Car moreCars:startingCars
                                ) {

                                    System.out.println(startingCars[i].showBasicInfo());
                                    i++;
                                }
                                break;
                            case 2:
                                i=0;
                                for (Car moreCars:startingCars)
                                {
                                    System.out.println(startingCars[i]);
                                    i++;
                                }
                                break;
                            case 3:
                                System.out.println("Podaj identyfikator pojazdu ktory chcesz kupic.");
                                scan = new Scanner(System.in);
                                carID=scan.nextInt();
                                //player1.setCar(startingCars[i]);
                                //startingCars[1].price*2/100
                                break;
                            case 4:break;
                            default:
                                System.out.println("Podano bledna wartosc, sprobuj ponownie");
                                break;
                        }

                    }while (2000>player1.getMoney());
                    /*while (2000>playerMoney);*/
                    break;
                case 2:
                    System.out.println("Celem gry jest podwojenie poczatkowej gotowki  w jak najmniejszej ilczbie ruchow.Jeden ruch to zakup auta/sprzedaz auta/naprawienie jednego elementu/dodanie jednej reklamy. Przeglądanie stanu konta, historii transakcji, baz klientow, posiadanych pojazdow i pojazdow dostępnych do kupienia nie oznacza wykorzystania ruchu.");
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
         .*/

    }
}

