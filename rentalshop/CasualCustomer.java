package rentalshop;

public class CasualCustomer extends Customer{
    
    
    public CasualCustomer(String name){
        super(name);        
    }

    /*  Rental duration 1-3 nights*/
    public int getRentalDuration(){
        return (int)(Math.random() * 2.9) + 1;
    }
    /* Always rents 1 car   */
    public int getNumberCarsToRent(){
        return 1;
    }
}