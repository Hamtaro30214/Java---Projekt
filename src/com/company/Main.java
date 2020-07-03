package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        //LISTS FOR CARS------------------------------------------------------------------------------------------------
        List<String> producers = new ArrayList<String>();
        producers.add("Ford");
        producers.add("Opel");
        producers.add("Volkswagen");
        producers.add("Audi");
        producers.add("Mercedes");
        List<String> colors = new ArrayList<String>();
        colors.add("Bialy");
        colors.add("Niebieski");
        colors.add("Czerwony");
        colors.add("Czarny");
        colors.add("Zolty");
        List<String> classifications = new ArrayList<String>();
        classifications.add("Budget");
        classifications.add("Standard");
        classifications.add("Premium");
        //RANDOM CARS ATTRIBUTES----------------------------------------------------------------------------------------
        int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);
        int randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
        int randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
        Random rand = new Random();
        int randIndex = rand.nextInt(producers.size());
        String randomProducer = producers.get(randIndex);
        randIndex = rand.nextInt(colors.size());
        String randomColor = colors.get(randIndex);
        randIndex = rand.nextInt(classifications.size());
        String randomClassification = classifications.get(randIndex);
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



        Player availableCars = new Player(0,1000000);
        Player player1 = new Player(1,1000);
        int randCars = ThreadLocalRandom.current().nextInt(5, 11);
        Car[] startingCars = new Car[randCars];
        //public List<Car> newCars = new List<Car>();
        //GENERATING RANDOM CARS----------------------------------------------------------------------------------------
        int i=0;
        while (i<startingCars.length) {
            randMoney = ThreadLocalRandom.current().nextInt(500, 3000);
            randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
            randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
            randIndex = rand.nextInt(producers.size());
            randomProducer = producers.get(randIndex);
            randIndex = rand.nextInt(colors.size());
            randomColor = colors.get(randIndex);
            randIndex = rand.nextInt(classifications.size());
            randomClassification = classifications.get(randIndex);
            rand1to5 = ThreadLocalRandom.current().nextInt(1, 6);

            switch(rand1to5)
            {
                case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
                case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
                case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
                case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
                case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;
            }
            var newCar = new Car(randMoney,randomProducer,randMileage,randomColor,randomClassification,part1,part2,part3,part4,part5,randLoadingSpace);
            startingCars[i] = newCar;
            System.out.println(startingCars[i]);
            i++;
        }
        //TEST CODE-----------------------------------------------------------------------------------------------------
        //MENU
        Integer menuChose = 0;
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
        3. Same things alway break, no space between them.*/


    }
}


