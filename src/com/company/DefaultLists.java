package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultLists {
    //DEFAULT VALUESVARIABLES------------------------------------------------------------------------------------------
    int loopWhileVariable=0;
    int randPrice = ThreadLocalRandom.current().nextInt(500, 3500),
            randMileage =ThreadLocalRandom.current().nextInt(20000, 300000),
            randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
    //LISTS FOR CARS----------------------------------------------------------------------------------------------------
    public static ArrayListString producers = new ArrayListString();
    static {
        producers.add(Ford);
        producers.add(Opel);
        producers.add(Volkswagen);
        producers.add(Audi);
        producers.add(Mercedes);
    }
    public static ArrayListString colors = new ArrayListString();
    static {
        colors.add(Bialy);
        colors.add(Niebieski);
        colors.add(Czerwony);
        colors.add(Czarny);
        colors.add(Zolty);
    }
    public static ArrayListString classifications = new ArrayListString();
    static {
        classifications.add(Budget);
        classifications.add(Standard);
        classifications.add(Premium);
    }
    public static ArrayListCar carsToBuy = new ArrayListCar();

    static
    {
        System.out.println( producers.size());
        System.out.println(producers.get(0));
    }
    //GENERATING RANDOM COMPONENTS FOR CARS----------------------------------------------------------------------------
    Random rand = new Random();
    int randIndex1 = rand.nextInt(DefaultLists.producers.size());
    String randomProducer = DefaultLists.producers.get(randIndex1);
    int randIndex2 = rand.nextInt(DefaultLists.colors.size());
    String randomColor = DefaultLists.colors.get(randIndex2);
    int randIndex3 = rand.nextInt(DefaultLists.classifications.size());
    String randomClassification = DefaultLists.classifications.get(randIndex3);
    int rand1to5 = ThreadLocalRandom.current().nextInt(1, 6);
    Boolean part1=true;
    Boolean part2=true;
    Boolean part3=true;
    Boolean part4=true;
    Boolean part5=true;
    int partSwitch= rand1to5;
        switch(partSwitch)
    {
        case 1 part1=false;part2=true;part3=true;part4=true;part5=true;break;
        case 2 part1=false;part2=false;part3=true;part4=true;part5=true;break;
        case 3 part1=false;part2=false;part3=false;part4=true;part5=true;break;
        case 4 part1=false;part2=false;part3=false;part4=false;part5=true;break;
        case 5 part1=false;part2=false;part3=false;part4=false;part5=false;break;
    }



    Player availableCars = new Player(1000000);
    Player player1 = new Player(1000);
    int randAmountOfCars = ThreadLocalRandom.current().nextInt(5, 11);
    public ListCar newCars = new ListCar();
    GENERATING RANDOM CARS------------------------------------------------------------------------------------
            while(loopWhileVariablestartingCars.length) {
        randPrice = ThreadLocalRandom.current().nextInt(500, 3000);
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
            case 1 part1=false;part2=true;part3=true;part4=true;part5=true;break;
            case 2 part1=false;part2=false;part3=true;part4=true;part5=true;break;
            case 3 part1=false;part2=false;part3=false;part4=true;part5=true;break;
            case 4 part1=false;part2=false;part3=false;part4=false;part5=true;break;
            case 5 part1=false;part2=false;part3=false;part4=false;part5=false;break;
        }
        var newCar = new Car(randPrice,randomProducer,randMileage,randomColor,randomClassification,part1,part2,part3,part4,part5,randLoadingSpace,rand1to5);
        carsToBuy.add(newCar);
        loopWhileVariable++;
    }





}
