package carDealership;

import java.util.*;
import java.lang.Math;

import CSCI4448project3.BusinessCustomer;
import CSCI4448project3.CasualCustomer;
import CSCI4448project3.RegularCustomer;
import factory.Car;

public class RentalRecord{

    private Customer renter;
    private float price;
    private int return_day;
    private int rental_length;
    private List<Car> cars=null;

    public RentalRecord(Customer renter, List<Car> available_cars, int today){
        this.renter=renter;
        if (renter instanceof BusinessCustomer){
            cars.add(available_cars.get(0));
            cars.add(available_cars.get(1));
            cars.add(available_cars.get(2));
            available_cars.removeRange(0,2);  
            this.rental_length=7;
            this.return_day=today+this.rental_length;          
        }
        else if (renter instanceof CasualCustomer){
            cars.add(available_cars.get(0));
            available_cars.removeFirst();
            this.rental_length= (int)(Math.random() * 2.9) + 1;
            this.return_day=today+this.rental_length;
        }
        else if (renter instanceof RegularCustomer){
            int numCars = (int)(Math.random() * 2.9)+1;
            for (int i = 0;i<numCars; i++){
                cars.add(available_cars.get(i));
            }
            available_cars.removeRange(0,i);
            this.rental_length = (int)(Math.random() * 2.9) + 3;
            this.return_day=today + this.rental_length;
        }

        for (Car car: cars){
            float gps = Math.random();
            float sat_radio = Math.random();
            float car_seats = Math.floor(Math.random()*4.9);

            if (gps>0.5) car = new GPS(car);
            if (sat_radio>0.5) car = new SatelliteRadio(car);
            for (int i = 0; i < car_seats;i++){
                car = new CarSeat(car);
            }
        }
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