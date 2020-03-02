package carDealership;
import java.util.*;

public class StoreObserver implements Observer{

    private Store store= null;


    public StoreObserver(Store store){
        this.store = store;
    }
    public void update(Observable obs, Object obj){
        /*  Print todays rentals */
        System.out.println("# of Rentals today: " + store.getNewRentals().size());
        System.out.println("-------------------");
        for (RentalRecord rental: store.getNewRentals()){
            System.out.println(rental.newRecordString());            
        }

        /*  Print all active rentals */
        System.out.println("\n# Total Active Rentals: " + store.getActiveRentals().size());
        System.out.println("-------------------");
        for (RentalRecord rental: store.getActiveRentals()){
            System.out.println(rental);            
        }

        /*  Print all available cars */
        System.out.println("\n# of Cars unrented: " + store.getAvailableCars().size());
        System.out.println("-------------------");
        for (Car car: store.getAvailableCars()){
            System.out.println(car);            
        }

        /*  Print profit */
        System.out.println("$$$ cash money in pocket:" + store.getProfit() + "\n");
    }

}