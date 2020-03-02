package factory;

//concrete suv
public class SUVCar extends Car {
    SUVCar() {
    	// assign type and cost
        super(CarType.SUV, 75);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building SUV");
    }
}

