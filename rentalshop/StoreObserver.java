package rentalshop;
import java.util.*;
import rentalshop.carfactory.*;

/*   OBSERVER PATTERN: Obervees Store object, printing daily activity   */
public class StoreObserver implements Observer{

    private Store store= null;

    public StoreObserver(Store store){
        this.store = store;
    }
    public void update(Observable obs, Object obj){
        /*  Print todays rentals */
        System.out.println("    Number of New Rentals today: " + store.getNewRentals().size());
        for (RentalRecord rental: store.getNewRentals()){
            System.out.println(rental);            
        }

        /*  Print all active rentals */
        System.out.println("\n    Number of Total Active Rentals: " + store.getActiveRentals().size());
        for (RentalRecord rental: store.getActiveRentals()){
            System.out.println(rental);            
        }

        /*  Print all available cars */
        System.out.println("    Number of Unrented Cars: " + store.getAvailableCars().size());
        for (Car car: store.getAvailableCars()){
            System.out.println("        "+car);            
        }

        /*  Print profit */
        System.out.println("    Todays Revenue:" + store.getProfit() + "\n");
    }

}