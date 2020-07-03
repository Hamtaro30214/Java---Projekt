package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    int rand5to10 = ThreadLocalRandom.current().nextInt(5, 10);
    Car[] cars = new Car[rand5to10];

    int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);        List<String> producers = new ArrayList<String>();
        producers.add("Ford");
        producers.add("Opel");
        producers.add("Volkswagen");
        producers.add("Audi");
        producers.add("Mercedes");

    int randMileage =ThreadLocalRandom.current().nextInt(20000, 300000);
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
        case 1:
            part1=false;
            part2=true;
            part3=true;
            part4=true;
            part5=true;
            break;
        case 2:
            part1=false;
            part2=false;
            part3=true;
            part4=true;
            part5=true;
            break;
        case 3:
            part1=false;
            part2=false;
            part3=false;
            part4=true;
            part5=true;
            break;
        case 4:
            part1=false;
            part2=false;
            part3=false;
            part4=false;
            part5=true;
            break;
        case 5:
            part1=false;
            part2=false;
            part3=false;
            part4=false;
            part5=false;
            break;
        default:break;
    }


    Car car1 = new Car(randMoney,randomProducer,randMileage,randomColor,randomClassification,part1,part2,part3,part4,part5,randLoadingSpace);
        System.out.println(car1);









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


}
}

