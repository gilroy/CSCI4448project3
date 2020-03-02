package factory;

//concrete economy car
public class EconomyCar extends Car { 
    EconomyCar() {
    	// assign type and cost
        super(CarType.ECONOMY, 50);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building economy car");
    }
}