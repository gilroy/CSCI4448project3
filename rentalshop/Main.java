package rentalshop;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*; 
import rentalshop.carfactory.*;

public class Main{
    public static void main(String [] args) throws FileNotFoundException{
        //  intialize store 
        Store store = new Store();
        /*  OBSERVER PATTERN */
        StoreObserver daily_update = new StoreObserver(store);
        store.addObserver(daily_update);
        
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

        //FACTORY PATTERN:  Instantiate 24 cars;
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

        PrintStream fileOut = new PrintStream("./35_day_sim.out");
        System.setOut(fileOut);

        //  35 Day main loop
        for (int day = 1; day<=35; day++){
            System.out.println("######### DAY "+day+" #########"); //Day print statment in main loop because day logic controlled here
            store.OneDay(day);
        }
        
        /*  Print out 35 Day total  */
        System.out.println("Total rentals: " + (store.getFinishedRentals().size() + store.getActiveRentals().size()));
        System.out.println("Total Business rentals: " + store.totalBusinnessRentals());
        System.out.println("Total Casual rentals: " + store.totalCasualRentals());
        System.out.println("Total Regular rentals: " + store.totalRegularRentals());
        System.out.println("Total Revenue: " + store.getTotalProfit());
    }
}