package rentalshop.carfactory;

//concrete economy car
public class EconomyCar extends Car { 
    EconomyCar() {
    	// assign type and cost
        super(CarType.ECONOMY, 50);
        construct();
    }
 
    protected void construct() {
        System.out.println("Building economy car");
    }
}