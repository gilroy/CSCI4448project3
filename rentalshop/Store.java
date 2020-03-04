package rentalshop;
import rentalshop.carfactory.*;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.*;

/*   Store Object for storing customer lists and organizing Rental Record lists. Checks Viability of Clients, before renting to them   */
public class Store extends Observable{/*  OBSERVER PATTERN: Observable */

    /*  LinkedList for constant time insertions/deletions since lists are constantly changing */
    private LinkedList<Car> available_cars = null; 
    private LinkedList<RentalRecord> active_rentals = null;
    private LinkedList<RentalRecord> finished_rentals = null;
    private LinkedList<RentalRecord> new_rentals = null; //todays rentals: changes every time  oneDay is called
    private LinkedList<Customer> client_list; 
    
    private int profit;
    private int total_profit;    
    
    public Store(){
        this.available_cars = new LinkedList<Car>();
        this.active_rentals = new LinkedList<RentalRecord>();
        this.finished_rentals = new LinkedList<RentalRecord>();
        this.new_rentals = new LinkedList<RentalRecord>();
        this.client_list =  new LinkedList<Customer>();
        total_profit = 0;
    }

    public void addCar(Car car){
        this.available_cars.add(car);
    }

    public void addCustomer(Customer client){
        this.client_list.add(client);
    }

    /*  Handle rental returns by comparing return day on all active_rentals to today    */
    private void returnCars(int today){
        Iterator<RentalRecord> active_rental_iterator = active_rentals.iterator();
        while(active_rental_iterator.hasNext()){
            RentalRecord rental=active_rental_iterator.next();
            if (rental.getReturnDay() == today) {
                this.finished_rentals.add(rental);
                for (Car car: rental.getCars()){
                    this.available_cars.add(car.getBaseCar());
                    rental.getRenter().incrementCarsRented(-1);
                }
                active_rental_iterator.remove();
            } 
        }
    }

    /*  Check that there is enough cars for client type + check that client isn't at rental maximum of 3 */
    private boolean clientIsViable(Customer client){
        if (available_cars.size()<=3 && client instanceof BusinessCustomer){
            return false;
        }  
        else if (available_cars.size()<=0){
            return false;
        }
        int carCount=0;
        for (RentalRecord rental: active_rentals){
            if (rental.getRenter().equals(client)) carCount++;
        }
        if (carCount >=3) return false;
        return true;
    }

    /*  create todays rentals though RentalRecord constructor  */
    public void newRentals(int today){
        this.new_rentals = new LinkedList<RentalRecord>();

        int rentals_today = (int)(Math.random() * (client_list.size() - active_rentals.size()));
        this.profit = 0;
        for (int i = 0; i<rentals_today;i++){
            int client_index = (int)(Math.random() * client_list.size());
            Customer client = this.client_list.get(client_index);
            
            if (!this.clientIsViable(client)){ // if clientnot viable, go to next loop iteration
                continue;
            }

            RentalRecord rental_record = new RentalRecord(this.client_list.get(client_index), this.available_cars, today);
            active_rentals.add(rental_record);
            new_rentals.add(rental_record);
            this.profit+= rental_record.getCost();  
            this.total_profit+=rental_record.getCost();      
        }
    }

    /*  One day of operation: (1)cars returned (2)new rentals created (3)observer notfified */
    public void OneDay(int today){
        
        this.returnCars(today);
        this.newRentals(today);

        /*  OBSERVER PATTERN: Notify Observers */        
        setChanged();
        notifyObservers();
    }

    public List<RentalRecord> getNewRentals(){
        return new_rentals;
    }
    
    public List<RentalRecord> getActiveRentals(){
        return active_rentals;
    }

    public List<RentalRecord> getFinishedRentals(){
        return finished_rentals;
    }

    public List<Car> getAvailableCars(){
        return available_cars;
    }

    public float getProfit(){
        return profit;
    }
    
    public float getTotalProfit(){
        return total_profit;
    }

    /*  Count different customer types by passing customer class */
    private int sumTypeRentals(Class customerType){
        int num_rentals=0;
        for (RentalRecord record: this.active_rentals){
            Customer renter = record.getRenter();
            if (customerType.isInstance(renter)){
                num_rentals+=1;
            }
        }
        for (RentalRecord record: this.finished_rentals){
            Customer renter = record.getRenter();
            if (customerType.isInstance(renter)){
                num_rentals+=1;
            }
        }
        return num_rentals;
    }
    /*  Different methods for getting total number of rental types  */
    public int totalBusinnessRentals(){
        return sumTypeRentals(BusinessCustomer.class);
    }
    public int totalCasualRentals(){
        return sumTypeRentals(CasualCustomer.class);
    }
    public int totalRegularRentals(){
        return sumTypeRentals(RegularCustomer.class);
    }
}