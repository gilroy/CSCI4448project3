package rentalshop.carfactory;

//concrete suv
public class SUVCar extends Car {
    SUVCar() {
    	// assign type and cost
        super(CarType.SUV, 75);
        construct();
    }
 
    protected void construct() {
        System.out.println("Building SUV");
    }
}

