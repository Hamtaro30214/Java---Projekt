package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultLists {
    public DefaultLists() { }

    //DEFAULT VALUES/VARIABLES------------------------------------------------------------------------------------------
    static String randomProducer1, randomProducer2, typeOfCar, randomProducer, randomColor, randomClassification;
    static Integer randMoney=0, randIndex=0, trueOrFalse=0, randMileage=0, randLoadingSpace=0,lastCarID=0,
            numberOfBrokenParts=0;
    static Boolean destroyedCar, part1, part2, part3, part4, part5;
    static Random rand = new Random();
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
    //CLIENTS-----------------------------------------------------------------------------------------------------------
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public void generateClients(Integer numerOfClients){
        for (int i = 0; i < numerOfClients; i++) {
            randMoney = ThreadLocalRandom.current().nextInt(1000, 2000);
            randIndex = rand.nextInt(DefaultLists.producers.size());
            randomProducer1 = producers.get(randIndex);
            do {
                randIndex = rand.nextInt(DefaultLists.producers.size());
                randomProducer2 = producers.get(randIndex);
            } while (randomProducer2.equals(randomProducer1));
            var percent = Math.random();
            destroyedCar = !(percent < 0.9);
            trueOrFalse = ThreadLocalRandom.current().nextInt(0, 2);
            if (trueOrFalse == 0) typeOfCar = "Dostawczak";
            else typeOfCar = "Osobówka";
            Client temporaryClient = new Client(randMoney,i, randomProducer1, randomProducer2, typeOfCar, destroyedCar);
            clients.add(temporaryClient);
            //System.out.println("Klient:" + i + clients.get(i));
        }
    }
    //GENERATING RANDOM CARS--------------------------------------------------------------------------------------------
    public static ArrayList<Car> carsToBuy = new ArrayList<Car>();
    public void generateCars(Integer numberOfCars) {
        int i = 0;
        while (i < numberOfCars) {
            randMoney = ThreadLocalRandom.current().nextInt(200, 2800);
            randMileage = ThreadLocalRandom.current().nextInt(20000, 300000);
            randLoadingSpace = ThreadLocalRandom.current().nextInt(15, 100);
            randIndex = rand.nextInt(DefaultLists.producers.size());
            randomProducer = DefaultLists.producers.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.colors.size());
            randomColor = DefaultLists.colors.get(randIndex);
            randIndex = rand.nextInt(DefaultLists.classifications.size());
            randomClassification = DefaultLists.classifications.get(randIndex);
            numberOfBrokenParts = ThreadLocalRandom.current().nextInt(0, 6);

            switch (numberOfBrokenParts) {//TODO: chose in random selection
                case 0: part1=true;part2=true;part3=true;part4=true;part5=true;break;
                case 1: part1=false;part2=true;part3=true;part4=true;part5=true;break;
                case 2: part1=false;part2=false;part3=true;part4=true;part5=true;break;
                case 3: part1=false;part2=false;part3=false;part4=true;part5=true;break;
                case 4: part1=false;part2=false;part3=false;part4=false;part5=true;break;
                case 5: part1=false;part2=false;part3=false;part4=false;part5=false;break;
            }
            Car temporaryCar = new Car(i + 1, randMoney, randomProducer, randMileage, randomColor, randomClassification, part1, part2, part3, part4, part5, randLoadingSpace, numberOfBrokenParts);
            carsToBuy.add(temporaryCar);
            //System.out.println(carsToBuy.get(i));
            i++;
            lastCarID = i;
        }
    }
    public void generateStartingLists(){
        generateClients(4);
        Integer numberOfStartingCars=ThreadLocalRandom.current().nextInt(5, 11);
        generateCars(numberOfStartingCars);
    }
}