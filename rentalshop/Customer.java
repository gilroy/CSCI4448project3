package rentalshop;
import java.lang.Math;

/*  Customer class that has a name and current cars rented    */
public abstract class Customer{
    protected String name;
    protected int cars_rented;

    public Customer(String name){
        this.name = name;
        this.cars_rented=0;
    }

    public String getName(){
        return this.name;
    }

    public int getCarsRented(){
        return this.cars_rented;
    }

    /*  Manipulate the current amount of rented cars (for checking against having more than 3)*/ 
    public void incrementCarsRented(int num){
        this.cars_rented+=num;
    }

    public void setName(String name){
        this.name = name;
    }
    
    /*  Return Customers "decision" to add options" */
    public boolean getGPS(){
        return (Math.random()>0.5);
    }
    public boolean getSatRadio(){
        return (Math.random()>0.5);
    }
    public int getCarSeats(){
        return (int)(Math.random()*4.9);
    }

    /*  Abstract methods because concrete customer classes have different duration + car number requirements    */
    abstract public int getRentalDuration();
    abstract public int getNumberCarsToRent();
}