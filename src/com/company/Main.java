package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static com.company.DefaultLists.*;

public class Main {

    public static void main(String[] args) {
        DefaultLists startGame = new DefaultLists();
        startGame.generateStartingLists();
        Player player1 = new Player(1000);
        //MECHANICS-----------------------------------------------------------------------------------------------------
        Mechanic janusz = new Mechanic(1,50,100,250,80,70);
        Mechanic marian = new Mechanic(2,40,90,220,70,60);
        Mechanic adrian = new Mechanic(3,25,70,130,50,45);
        ArrayList<Mechanic> mechanics = new ArrayList<>();
        mechanics.add(janusz);
        mechanics.add(marian);
        mechanics.add(adrian);

        int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);
        Scanner scan;
        Integer startingMenu=0, gameMenu=0, scan1=0, scan2=0, scan3=0, priceOfCar, tax, fullPrice, lastCarSoldID=0, moves=0,
                numberOfCarsInGarage=0, randNewspaper=0, repairCost;
        Boolean playerTurn=true,endOfgame=false, chanceForBrake1,chanceForBrake2,chanceForBrake3;
        Car localCar,carNotToSell,carNotToBuy;
        //MENU----------------------------------------------------------------------------------------------------------
        while (startingMenu!=3) {
            System.out.println("Witaj w grze AutoHandel.");
            System.out.println("Wybierz 1 aby rozpocząć grę.");
            System.out.println("wybierz 2 aby zapoznac sie z zasadami gry.");
            System.out.println("Wybierz 3 aby wyjść.");
            scan = new Scanner(System.in);
            startingMenu = scan.nextInt();
            switch (startingMenu) {
                case 1: while (gameMenu != 13 && endOfgame!=true) {
                    System.out.println("Wybierz 1 aby zobaczyć samochody do kupienia.");
                    System.out.println("Wybierz 2 aby kupić jedno auto.");
                    System.out.println("Wybierz 3 aby zobaczyć posiadane pojazdy.");
                    System.out.println("Wybierz 4 aby naprawić samochód.");
                    System.out.println("Wybierz 5 aby zobaczyć potencjalnych klientów.");
                    System.out.println("Wybierz 6 aby sprzedać auto klientowi.");
                    System.out.println("wybierz 7 aby kupić reklame.");
                    System.out.println("Wybierz 8 aby zobaczyć stan konta.");
                    System.out.println("Wybierz 12 aby zakończyć turę.");
                    System.out.println("Wybierz 13 aby wyjść.");
                    scan = new Scanner(System.in);
                    gameMenu = scan.nextInt();
                    switch (gameMenu) {
                        case 1: carsToBuy.forEach(System.out::println);
                            break;
                        case 2: if(!playerTurn) System.out.println("Opcja niedostępna w tej turze.");
                        else {
                            System.out.println("Podaj identyfikator pojazdu który chcesz kupić:");
                            scan = new Scanner(System.in);
                            scan1 = scan.nextInt();
                            priceOfCar=carsToBuy.get(scan1-1).getPrice();
                            tax=priceOfCar*2/100;//using method getPrice again might be more secure<ASK>
                            fullPrice=priceOfCar+tax;
                            if(fullPrice>player1.getMoney()) {
                                System.out.println("Próbujesz kupić auto na którę cię nie stać.");
                                break;
                            }
                            localCar=carsToBuy.get(scan1-1);
                            localCar.carID=lastCarSoldID;
                            lastCarSoldID++;
                            player1.setCar(localCar);
                            numberOfCarsInGarage++;
                            player1.setMoney(player1.getMoney()-fullPrice);
                            System.out.println("Kupiono auto za:"+fullPrice+"$");
                            carNotToBuy = new Car(scan1-1,1000000,null,null,null,null,null,null, null,null,null,100,null);
                            carsToBuy.set(scan1-1,carNotToBuy);
                            moves++;
                            playerTurn=false;
                        }
                            break;
                        case 3: if(numberOfCarsInGarage.equals(0)) System.out.println("Nie posiadasz pojazdów w garażu.");
                        else for(int i=0;i<numberOfCarsInGarage;i++) System.out.println(player1.getCar(i));
                            break;
                        case 4: if(!playerTurn) System.out.println("Opcja niedostępna w tej turze.");
                        else if(numberOfCarsInGarage.equals(0)) System.out.println("Nie posiadasz pojazdów w garażu.");
                        else {
                            for(int i=0;i<numberOfCarsInGarage;i++) {
                                System.out.println(player1.getCar(i));
                            }
                            System.out.println("Wybierz pojazd do naprawy:");
                            scan = new Scanner(System.in);
                            scan1 = scan.nextInt();
                            localCar=player1.getCar(scan1);
                            fullPrice=localCar.getPrice();
                            System.out.println("Wybierz jednego z poniższych mechaników.");
                            System.out.println("1. Janusz - ma najdrozsze ceny ale 100% gwarancji.");
                            System.out.println("2. Marian - bierze zdecydowanie mniej niz Janusz, ale masz 10% szans, ze nie uda mu sie naprawic samochodu i konieczna będzie interwencja Janusza.");
                            System.out.println("3. Adrian - jest najtanszy, ale masz 20% szans, ze nie uda mu się naprawic i 2% szans, ze zepsuje cos innego podczas naprawy.");
                            scan = new Scanner(System.in);
                            scan2 = scan.nextInt();
                            System.out.println("Wybierz część do naprawy: 1.Hamulce, 2.Zawieszenie, 3.Silnik, 4.Karoseria, 5.Skrzynia biegów.");
                            scan = new Scanner(System.in);
                            scan3 = scan.nextInt();
                            var percent = Math.random();
                            chanceForBrake1 = !(percent < 0.90);
                            percent = Math.random();
                            chanceForBrake2 = !(percent < 0.9);
                            percent = Math.random();
                            chanceForBrake3 = !(percent < 0.98);
                            if(scan2==2){
                                if(chanceForBrake1==true){
                                    System.out.println("Marian nie naprawił częsci.");
                                    break;
                                }
                            }
                            if (scan3 == 3) {
                                if(chanceForBrake2==true){
                                    System.out.println("Adrian nie naprawił częsci.");
                                    if(localCar.amountOfDestroyedParts!=5){
                                        if(chanceForBrake3==true){
                                            if(localCar.suspensionStatus!=true){
                                                if(localCar.engineStatus!=true){
                                                    if(localCar.engineStatus!=true){
                                                        localCar.gearboxStatus=false;
                                                    }
                                                }
                                                else localCar.engineStatus=false;
                                            }
                                            else localCar.suspensionStatus=false;
                                        }
                                        player1.setCar(localCar);
                                    }
                                    break;
                                }
                            }
                            switch (scan3) {
                                case 1:if(localCar.brakesStatus==true){
                                    System.out.println("Hamulce nie wymagają naprawy.");
                                    break;
                                }
                                    if(chanceForBrake1==true){
                                        System.out.println("Marian nie naprawił częsci.");
                                        break;
                                    }
                                    if(localCar.producer.equals("Opel") || localCar.producer.equals("Volkswagen")) {
                                        repairCost=mechanics.get(scan2).brakesCost+100;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.brakesStatus=true;
                                        fullPrice=fullPrice+fullPrice*10/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    if(localCar.producer.equals("Ford")) {
                                        repairCost=mechanics.get(scan2).brakesCost+150;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.brakesStatus=true;
                                        fullPrice=fullPrice+fullPrice*10/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    if (localCar.producer.equals("Audi") || localCar.producer.equals("Mercedes")) {
                                        repairCost=mechanics.get(scan2).brakesCost+250;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.brakesStatus=true;
                                        fullPrice=fullPrice+fullPrice*10/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    break;
                                case 2:if(localCar.suspensionStatus==true){
                                    System.out.println("Zawieszenie nie wymaga naprawy.");
                                    break;
                                }
                                    if(localCar.producer.equals("Opel") || localCar.producer.equals("Volkswagen")) {
                                        repairCost=mechanics.get(scan2).suspensionCost+100;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.suspensionStatus=true;
                                        fullPrice=fullPrice+fullPrice*20/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    if(localCar.producer.equals("Ford")) {
                                        repairCost=mechanics.get(scan2).suspensionCost+150;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.suspensionStatus=true;
                                        fullPrice=fullPrice+fullPrice*20/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    if (localCar.producer.equals("Audi") || localCar.producer.equals("Mercedes")) {
                                        repairCost=mechanics.get(scan2).suspensionCost+250;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.suspensionStatus=true;
                                        fullPrice=fullPrice+fullPrice*20/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś zawieszenie za:"+repairCost);
                                    }
                                    break;
                                case 3:if(localCar.engineStatus==true){
                                    System.out.println("Silnik nie wymaga naprawy.");
                                    break;
                                }
                                    if(localCar.producer.equals("Opel") || localCar.producer.equals("Volkswagen")) {
                                        repairCost=mechanics.get(scan2).engineCost+100;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.engineStatus=true;
                                        fullPrice=fullPrice+fullPrice;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś silnik za:"+repairCost);
                                    }
                                    if(localCar.producer.equals("Ford")) {
                                        repairCost=mechanics.get(scan2).engineCost+150;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.engineStatus=true;
                                        fullPrice=fullPrice+fullPrice;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś silnik za:"+repairCost);
                                    }
                                    if (localCar.producer.equals("Audi") || localCar.producer.equals("Mercedes")) {
                                        repairCost=mechanics.get(scan2).engineCost+250;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.engineStatus=true;
                                        fullPrice=fullPrice+fullPrice;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś silnik za:"+repairCost);
                                    }
                                    break;
                                case 4:if(localCar.bodyStatus==true){
                                    System.out.println("Karoseria nie wymaga naprawy.");
                                    break;
                                }
                                    if(localCar.producer.equals("Opel") || localCar.producer.equals("Volkswagen")) {
                                        repairCost=mechanics.get(scan2).bodyCost+100;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.bodyStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    if(localCar.producer.equals("Ford")) {
                                        repairCost=mechanics.get(scan2).bodyCost+150;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.bodyStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    if (localCar.producer.equals("Audi") || localCar.producer.equals("Mercedes")) {
                                        repairCost=mechanics.get(scan2).bodyCost+250;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.bodyStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    break;
                                case 5:if(localCar.gearboxStatus==true) {
                                    System.out.println("Skrzynia biegów nie wymaga naprawy.");
                                    break;
                                }
                                    if(localCar.producer.equals("Opel") || localCar.producer.equals("Volkswagen")) {
                                        repairCost=mechanics.get(scan2).gearboxCost+100;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.gearboxStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    if(localCar.producer.equals("Ford")) {
                                        repairCost=mechanics.get(scan2).gearboxCost+150;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.gearboxStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    if (localCar.producer.equals("Audi") || localCar.producer.equals("Mercedes")) {
                                        repairCost=mechanics.get(scan2).gearboxCost+250;
                                        player1.setMoney(player1.getMoney()-repairCost);
                                        localCar.gearboxStatus=true;
                                        fullPrice=fullPrice+fullPrice*50/100;
                                        localCar.setPrice(fullPrice);
                                        player1.setCar(localCar);
                                        System.out.println("Naprawiłeś karoseria za:"+repairCost);
                                    }
                                    break;
                                default:
                                    System.out.println("Podano błedną wartość.");
                                    break;
                            }
                            moves++;
                            playerTurn = false;
                        }
                            break;
                        case 5: clients.forEach(System.out::println);
                            break;
                        case 6: if(!playerTurn) System.out.println("Opcja niedostępna w tej turze.");
                        else if(numberOfCarsInGarage.equals(0)) System.out.println("Nie posiadasz pojazdów w garażu.");
                        else {
                            for(int i=0;i<numberOfCarsInGarage;i++){
                                System.out.println(player1.getCar(i).showBasicInfo());
                            }
                            System.out.println("Podaj ID auta które chcesz sprzedać:");
                            scan = new Scanner(System.in);
                            scan1 = scan.nextInt();
                            clients.forEach(System.out::println);
                            System.out.println("Podaj ID klienta któremu chcesz sprzedać auto:");
                            scan = new Scanner(System.in);
                            scan2 = scan.nextInt();
                            priceOfCar=player1.getCar((scan1-1)).getPrice();
                            tax=priceOfCar*2/100;
                            fullPrice=priceOfCar+tax;
                            if(fullPrice>clients.get(scan2-1).getMoney()) {
                                System.out.println("Klienta nie stac na to auto.");
                            }
                            else if(clients.get(scan2-1).producer1!=player1.getCar(scan1-1).producer
                                    &&clients.get(scan2-1).producer2!=player1.getCar(scan1-1).producer){
                                System.out.println("Klient nie kupi pojazdu tej marki.");
                            }
                            else {
                                String type;
                                if(player1.getCar(scan1-1).loadingSpace>60) type="Dostawczak";
                                else type="Osobówka";
                                if(clients.get(scan2-1).typeOfCar!=type){
                                    System.out.println("Klient nie kupi tego typu pojazdu.");
                                    break;
                                }
                                if(clients.get(scan2-1).destroyedSuspension==true){
                                    if(player1.getCar(scan2-1).suspensionStatus!=true) {
                                        System.out.println("Klient nie kupi auta z niesprawnym zawieszeniem.");
                                    }
                                    else {
                                        if(!playerTurn) break;
                                        clients.get(scan2-1).setCar(player1.getCar(scan1-1));
                                        carNotToSell=new Car(scan1-1,null,null,null,null,null,null,null, null, null, null, 100, null);
                                        player1.changeCar(scan1-1,carNotToSell);
                                        player1.setMoney(player1.getMoney()+(priceOfCar-tax));
                                        clients.get(scan2-1).setMoney(clients.get(scan2-1).getMoney()-fullPrice);
                                        System.out.println("Sprzedałeś auto za:"+priceOfCar);
                                        playerTurn=true;
                                        moves++;
                                    }
                                }
                                else if(clients.get(scan2-1).destroyedCar==true){
                                    if(player1.getCar(scan1-1).amountOfDestroyedParts<1) {
                                        System.out.println("Klient nie kupi tak mocno niesprawnego auta.");
                                    }
                                    else {
                                        if(!playerTurn) break;
                                        clients.get(scan2-1).setCar(player1.getCar(scan1-1));
                                        carNotToSell=new Car(scan1-1,null,null,null,null,null,null,null, null, null, null, 100, null);
                                        player1.changeCar(scan1-1,carNotToSell);
                                        player1.setMoney(player1.getMoney()+(priceOfCar-tax));
                                        clients.get(scan2-1).setMoney(clients.get(scan2-1).getMoney()-fullPrice);
                                        System.out.println("Sprzedałeś auto za:"+priceOfCar);
                                        playerTurn=true;
                                        moves++;
                                    }
                                }
                                else if(clients.get(scan2-1).destroyedCar==false){
                                    if(player1.getCar(scan1-1).amountOfDestroyedParts>1){
                                        System.out.println("Klient nie kupi uszkodzonego auta.");
                                    }
                                    else {
                                        if(!playerTurn) break;
                                        clients.get(scan2-1).setCar(player1.getCar(scan1-1));
                                        carNotToSell=new Car(scan1-1,null,null,null,null,null,null,null, null, null, null, 100, null);
                                        player1.changeCar(scan1-1,carNotToSell);
                                        player1.setMoney(player1.getMoney()+(priceOfCar-tax));
                                        clients.get(scan2-1).setMoney(clients.get(scan2-1).getMoney()-fullPrice);
                                        System.out.println("Sprzedałeś auto za:"+priceOfCar);
                                        playerTurn=true;
                                        moves++;
                                    }
                                }
                            }
                        }
                            break;
                        case 7: if(!playerTurn) System.out.println("Opcja niedostępna w tej turze.");
                        else {
                            System.out.println("Wybierz 1 aby kupić kampanie marketingową za 250$(+2 klientów)");
                            System.out.println("Wybierz 2 aby kupić ogłoszenie w lokalnej gaziecie za 200$(+(1-3)klientów");
                            System.out.println("Wybierz 3 aby kupić remklamę w internecie za 150$(+1 klient)");
                            scan = new Scanner(System.in);
                            scan1 = scan.nextInt();
                            switch (scan1) {
                                case 1:
                                    if (player1.getMoney() < 250) {
                                        System.out.println("Nie stać cię.");
                                    } else {
                                        player1.setMoney(player1.getMoney() - 250);
                                        startGame.generateCars(2);
                                        System.out.println("Zyskałeś 2 klientów.");
                                    }
                                    break;
                                case 2:
                                    if (player1.getMoney() < 200) {
                                        System.out.println("Nie stać cię.");
                                    } else {
                                        player1.setMoney(player1.getMoney() - 200);
                                        randNewspaper = ThreadLocalRandom.current().nextInt(1, 4);
                                        startGame.generateCars(randNewspaper);
                                        System.out.println("Zyskałeś " + randNewspaper + " klienta/klientów.");
                                    }
                                    break;
                                case 3:
                                    if (player1.getMoney() < 150) {
                                        System.out.println("Nie stać cię.");
                                    } else {
                                        player1.setMoney(player1.getMoney() - 150);
                                        startGame.generateCars(1);
                                        System.out.println("Zyskałeś 1 klienta.");
                                    }
                                    break;
                            }
                        }
                            break;
                        case 8: System.out.println("Posiadasz:"+player1.getMoney()+"$");
                            break;
                        case 12: System.out.println("Następna tura.");
                            startGame.generateCars(2);
                            playerTurn=true;
                            break;
                        case 13: System.out.println("Może kontynuować grę jeśli rozpoczniesz ją ponownie.");
                            break;
                        default: System.out.println("Podano błedną wartość, sprobuj ponownie.");
                            break;
                    }
                    if(endOfgame) System.out.println("Gratulację wygrałeś w "+moves+" i zdobyłeś "+player1.getMoney()+"$");
                }
                    break;
                case 2:System.out.println("Celem gry jest podwojenie początkowej gotówki w jak najmniejszej ilczbie ruchów.Jeden ruch to zakup auta/sprzedaż auta/naprawienie jednego elementu/dodanie jednej reklamy. Przeglądanie stanu konta, historii transakcji, baz klientów, posiadanych pojazdów i pojazdów dostępnych do kupienia nie oznacza wykorzystania ruchu.");
                    break;
                case 3: break;
                default:
                    System.out.println("Podano błedną wartość, sprobuj ponownie.");
                    break;
            }
        }
         /*Now issues:
        1. There is chance that player won't have enought money for any car.
        3. Same things always break, no space between them.
        5. Not using Double in variables.
        6. No washing for cars.
        7. Player can't sell cars that are destroyed.
        8. Car after buy isn't removed from list, just change for a car that can't be bought or sold.
        10. Variables aren't private or protected.
        11. Game progress can't be reset by menu, but it's now possible.
         .*/
    }
}

