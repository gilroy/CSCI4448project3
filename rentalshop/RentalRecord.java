package rentalshop;

import java.util.*;
import java.lang.Math;
import rentalshop.carfactory.*;
/*  Store all info about one renta record inculding the customer, cars and length of the record */
public class RentalRecord{

    private Customer renter;
    private float price;
    private int return_day;
    private int rental_length;
    private List<Car> cars=null;

    public RentalRecord(Customer renter, List<Car> available_cars, int today){
        this.renter=renter;
        cars = new LinkedList<>();
        /*  Asl renter how long and number of cars they would like  */
        int num_cars = Math.min(renter.getNumberCarsToRent(), available_cars.size());
        this.rental_length = renter.getRentalDuration();
        for (int i =0; i<num_cars;i++){
            cars.add(available_cars.get(0));
            available_cars.subList(0, 1).clear();
        }
        renter.incrementCarsRented(num_cars);
        this.return_day=today+this.rental_length;
        
        this.price = 0;

        /* DECORATOR PATTERN: Ask renter about options and apply them */
        ListIterator<Car> cars_iterator= cars.listIterator();//List Iterator to make use of .set() function
        while(cars_iterator.hasNext()){
            Car car=cars_iterator.next();
            if (renter.getGPS()) car = new GPS(car); 
            if (renter.getSatRadio()) car = new SatelliteRadio(car);
            int car_seats = renter.getCarSeats();
            for (int i = 0; i < car_seats;i++){
                car = new CarSeat(car);
            }

            cars_iterator.set(car);//.set replaces last value returned by iterator.next()

            price+=car.getCost(rental_length);
        }
    }
    
    public float getCost(){
        return this.price;
    }

    public float getReturnDay(){
        return this.return_day;
    }

    public Customer getRenter(){
        return this.renter;
    }

    public List<Car> getCars(){
        return this.cars;
    }
    /*
        Displays information about every car that is part of this rental
        (Renter name, duration of rental, total price, as well as name and options for each car)
    */
    public String toString(){
        String out="";
        out += "        renter: " + renter.getName() + ", days rented: " + rental_length + ", price: " + price + "\n";
        for (Car car: cars){
            out+= "          car- " + car.toString()+"\n";
        }
        return out.substring(0, out.length());
    }
}
