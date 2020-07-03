package com.company;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static com.company.DefaultLists.*;

public class Main {

    public static void main(String[] args) {
        //RANDOM CARS ATTRIBUTES----------------------------------------------------------------------------------------
        int randMoney = ThreadLocalRandom.current().nextInt(500, 3500);
        Player player1 = new Player(1000);
        Scanner scan;
        Integer startingMenu=0, gameMenu=0, scan1=0, scan2=0, priceOfCar, tax, fullPrice, lastCarSoldID=0, moves=0,
                numberOfCarsInGarage=0, randNewspaper=0;
        Boolean playerTurn=true,endOfgame=false;
        Car localCar,carNotToSell,carNotToBuy;
        //MENU
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
                        else {
                            System.out.println("Wybierz jednego z poniższych mechaników.");
                            System.out.println("1. Janusz - ma najdrozsze ceny ale 100% gwarancj.");
                            System.out.println("2. Marian - bierze zdecydowanie mniej niz Janusz, ale masz 10% szans, ze nie uda mu sie naprawic samochodu i konieczna będzie interwencja Janusza.");
                            System.out.println("3. Adrian - jest najtanszy, ale masz 20% szans, ze nie uda mu się naprawic i 2% szans, ze zepsuje cos innego podczas naprawy.");
                            moves++;
                            playerTurn=false;
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
                                        System.out.println("Zyskałeś 2 klientów.");
                                    }
                                    break;
                                case 2:
                                    if (player1.getMoney() < 200) {
                                        System.out.println("Nie stać cię.");
                                    } else {
                                        player1.setMoney(player1.getMoney() - 200);
                                        randNewspaper = ThreadLocalRandom.current().nextInt(1, 4);
                                        System.out.println("Zyskałeś " + randNewspaper + " klienta/klientów.");
                                    }
                                    break;
                                case 3:
                                    if (player1.getMoney() < 150) {
                                        System.out.println("Nie stać cię.");
                                    } else {
                                        player1.setMoney(player1.getMoney() - 150);
                                        System.out.println("Zyskałeś 1 klienta.");
                                    }
                                    break;
                            }
                        }
                            break;
                        case 8: System.out.println("Posiadasz:"+player1.getMoney()+"$");
                            break;
                        case 12: System.out.println("Następna tura.");
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
        Integer menuChose = 0;
        Integer choseAfterStart=0;
        Integer playerMoney=1000;
        Integer ammountOfCars=0;
        Integer carsInPlayerGarage=0;
        Integer chosenClient=0;
        Integer clientMoney=0;
        Integer adChose=0;
        Integer i=0;
        String smallOrBigCar;
         /*Now issues:
        1. There is chance that player won't have enought money for any car.
        3. Same things always break, no space between them.
        5. Not using Double in variables.
        6. No washing for cars.
        7. Player can't sell cars that are destroyed.
        8. Car after buy isn't removed from list, just change for a car that can't be bought or sold.
        10. Variables aren't private or protected.
        11. Game progress can't be reset by menu
         .*/
    }
    public String notAvailable()
    {
        return "Opcja nie dostępna w tej turze.";
    }
}

