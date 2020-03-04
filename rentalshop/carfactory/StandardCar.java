package rentalshop.carfactory;

//concrete standard car
public class StandardCar extends Car {
    StandardCar() {
    	// assign type and cost
        super(CarType.STANDARD, 55);
        construct();
    }
 
    protected void construct() {
        System.out.println("Building standard car");
    }
}
