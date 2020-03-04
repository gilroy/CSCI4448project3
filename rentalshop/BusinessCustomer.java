package rentalshop;

public class BusinessCustomer extends Customer{
    
    public BusinessCustomer(String name){
        super(name);        
    }

    /*  Always rents for 7 nights   */
    public int getRentalDuration(){
        return 7;
    }
    /*  Alwayas rents 3 cars    */
    public int getNumberCarsToRent(){
        return 3;
    }
}