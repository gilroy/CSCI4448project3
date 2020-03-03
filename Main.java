package CSCI4448project3;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import carDealership.RentalRecord;
public class Main{
    public static void main(String [] args){
        //  intialize store and store observer
        Store store = new Store();
        StoreObserver daily_update = new StoreObserver(store);
        
        //  instantiate 12 customers
        store.addCustomer( new BusinessCustomer("Adam"));
        store.addCustomer( new BusinessCustomer("Bevis"));
        store.addCustomer( new BusinessCustomer("Charly"));
        store.addCustomer( new BusinessCustomer("Dereck"));
        store.addCustomer( new RegularCustomer("Eve"));
        store.addCustomer( new RegularCustomer("Farah"));
        store.addCustomer( new RegularCustomer("Grace"));
        store.addCustomer( new RegularCustomer("Henry"));
        store.addCustomer( new CasualCustomer("Ignus"));
        store.addCustomer( new CasualCustomer("Jackie"));
        store.addCustomer( new CasualCustomer("Kate"));
        store.addCustomer( new CasualCustomer("Lucy"));

        //  Instantiate 24 cars;
        store.addCar(CarFactory.buildCar(CarType.STANDARD));
        store.addCar(CarFactory.buildCar(CarType.STANDARD));
        store.addCar(CarFactory.buildCar(CarType.STANDARD));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.SUV));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.LUXURY));
        store.addCar(CarFactory.buildCar(CarType.ECONOMY));
        store.addCar(CarFactory.buildCar(CarType.ECONOMY));
        store.addCar(CarFactory.buildCar(CarType.ECONOMY));
        store.addCar(CarFactory.buildCar(CarType.ECONOMY));
        store.addCar(CarFactory.buildCar(CarType.ECONOMY));
        store.addCar(CarFactory.buildCar(CarType.MINIVAN));
        store.addCar(CarFactory.buildCar(CarType.MINIVAN));
        store.addCar(CarFactory.buildCar(CarType.MINIVAN));
        store.addCar(CarFactory.buildCar(CarType.MINIVAN));

        //  35 Day main loop
        for (int day = 1; day<=35; day++){
            System.out.println("######### DAY "+day+" #########");
            store.OneDay(day);
        }

        int business_rentals=0;
        int casual_rentals=0;
        int regular_rentals=0;

        for (RentalRecord record: store.getFinishedRentals().addall(store.getActiveRentals())){
            Customer renter = record.getRenter();
            if (renter instanceof BusinessCustomer){
                business_rentals+=1;
            }
            else if (renter instanceof CasualCustomer){
                casual_rentals+=1;
            }
            else if (renter instanceof RegularCustomer){
                regular_rentals+=1;
            }
        }
        
        System.out.println("Total Business rentals: " + business_rentals);
        System.out.println("Total Casual rentals: " + casual_rentals);
        System.out.println("Total Regular rentals: " + regular_rentals);
    }
}