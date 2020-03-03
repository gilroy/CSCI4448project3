package CSCI4448project3;

import java.io.FileNotFoundException;
import java.io.PrintStream;
public class Main{
    public static void main(String [] args){
        //  intialize store and store observer
        Store store = new Store();
        StoreObserver daily_update = new StoreObserver(store);
        
        //  instantiate 12 customers
        store.addCustomer( new Customer("Adam"));
        store.addCustomer( new Customer("Bevis"));
        store.addCustomer( new Customer("Charly"));
        store.addCustomer( new Customer("Dereck"));
        store.addCustomer( new Customer("Eve"));
        store.addCustomer( new Customer("Farah"));
        store.addCustomer( new Customer("Grace"));
        store.addCustomer( new Customer("Henry"));
        store.addCustomer( new Customer("Ignus"));
        store.addCustomer( new Customer("Jackie"));
        store.addCustomer( new Customer("Kate"));
        store.addCustomer( new Customer("Lucy"));

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

        
        
    }
}