package carDealership;

import java.util.*;

public class Store extends Observable{

    private List<Car> available_cars = null; //Linked list for insertions/removals
    private List<RentalRecord> active_rentals = null; //Linked list for insertions/removals into queu
    private List<RentalRecord> finished_rentals = null; //Linked list for insertions/removals into queu
    private List<RentalRecord> new_rentals = null;
    private List<Customer> client_list; //Array b/ does not change
    
    private int profit;
    private int total_profit;    
    
    public Store(){
        this.available_cars = new LinkedList<Car>();
        this.active_rentals = new LinkedList<RentalRecord>();
        this.finished_rentals = new LinkedList<RentalRecord>();
        this.new_rentals = new LinkedList<RentalRecord>();
        this.client_list =  new LinkedList<Customer>();
    }

    public void addCar(Car car){
        this.available_cars.add(car);
    }

    public void addCustomer(Customer client){
        this.client_list.add(client);
    }

    public void OneDay(int today){
        /*  Handle rental returns */
        for (RentalRecord rental: active_rentals){
            if (rental.getReturnDay() == today) {
                this.finished_rentals.add(rental);
                this.active_rentals.remove(rental);
            }            
        }        

        this.new_rentals = new LinkedList<RentalRecord>();

        int rentals_today = (int)(Math.random() * (client_list.size() - active_rentals.size()));
        this.profit = 0;

        for (int i = 0; i<rentals_today;i++){
            int client_index = (int)(Math.random() * client_list.size());
            
            if (available_cars.size()<=3 && this.client_list.get(client_index) instanceof BusinessCustomer){
                continue;
            }  
            else if (available_cars.size()<=0){
                continue;
            }

            RentalRecord rental_record = new RentalRecord(this.client_list.get(client_index), this.available_cars);
            active_rentals.add(rental_record);
            new_rentals.add(rental_record);
            this.profit+= rental_record.getPrice();  
            this.total_profit+=rental_record.getPrice();      
        }  

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
        return profit;
    }

    public int getNumberRentalsByCustomerType(Object customer_type){
        int record_count=0;
        for (RentalRecord record: finished_rentals){
            if (record.getRenter().isInstance(customer_type)) business_records+=1;
        }      
    }
}