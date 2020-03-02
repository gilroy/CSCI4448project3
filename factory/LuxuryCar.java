package factory;

// concrete luxury car
public class LuxuryCar extends Car { 
    LuxuryCar() {
    	// assign type and cost
        super(CarType.LUXURY, 150);
        construct();
    }
    @Override
    protected void construct() {
        System.out.println("Building luxury car");
    }
}
