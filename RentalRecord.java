package carDealership;

import java.util.*;

public class RentalRecord{

    private Customer renter;
    private float price;
    private int return_day;
    private int rental_length;
    private List<Car> cars=null;

    public RentalRecord(Customer renter, List<Car> available_cars){
        this.renter=renter;
    }

    public float getPrice(){
        return this.price;
    }

    public float getReturnDay(){
        return this.return_day;
    }

    public Customer getRenter(){
        return this.renter;
    }

    public String newRecordString(){
        String out="";
        out += "renter: " + renter.getName() + ", rental length: " + rental_length + ", price: " + price + "\n";
        for (Car car: cars){
            out+= "car- " + car.toString() + "\n";
        }
        return out;
    }
    
    public String toString(){
        String out="";
        for (Car car: cars){
            out+= "car- " + car.toString() + ", renter: " + renter.getName() + "\n";
        }
        return out;
    }
}