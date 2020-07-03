package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultLists {
    //DEFAULT VALUES/VARIABLES------------------------------------------------------------------------------------------
    int loopWhileVariable=0;
    int randPrice = ThreadLocalRandom.current().nextInt(500, 3500),
            randMileage =ThreadLocalRandom.current().nextInt(20000, 300000),
            randLoadingSpace =ThreadLocalRandom.current().nextInt(15, 100);
    //LISTS FOR CARS----------------------------------------------------------------------------------------------------
    public static ArrayList<String> producers = new ArrayList<String>();
    static {
        producers.add("Ford");
        producers.add("Opel");
        producers.add("Volkswagen");
        producers.add("Audi");
        producers.add("Mercedes");
    }
    public static ArrayList<String> colors = new ArrayList<String>();
    static {
        colors.add("Bialy");
        colors.add("Niebieski");
        colors.add("Czerwony");
        colors.add("Czarny");
        colors.add("Zolty");
    }
    public static ArrayList<String> classifications = new ArrayList<String>();
    static {
        classifications.add("Budget");
        classifications.add("Standard");
        classifications.add("Premium");
    }






}
