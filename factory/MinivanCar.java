package factory;

// concrete minivan
public class MinivanCar extends Car {
    MinivanCar() {
    	// assign type and cost
        super(CarType.MINIVAN, 60);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building minivan");
    }
}
