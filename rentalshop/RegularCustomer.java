package rentalshop;

public class RegularCustomer extends Customer{
    
    public RegularCustomer(String name){
        super(name);        
    }

    /*  rental duration 3-5 days    */
    public int getRentalDuration(){
        return (int)(Math.random() * 2.9) + 3;
    }
    /*  1-3 cars    */
    public int getNumberCarsToRent(){
        return (int)(Math.random() * 2.9)+1;
    }
}