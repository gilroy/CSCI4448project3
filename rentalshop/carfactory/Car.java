package rentalshop.carfactory;
import java.util.Random;

public class Car {
	 
    public Car(CarType model, int cost) {
        this.model = model;
        this.plate = generatePlate();
        this.cost = cost;
    }

    public Car(CarType model, int cost, String plate) {
        this(model, cost);
        this.plate = plate;
    }
 
    private String generatePlate() {
    	Random random = new Random();
    	final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	final int index = alphabet.length();
    	
    	// generate 3 random letters i.e. ABC
		String plate = "";
		 for (int i = 0; i < 3; i++) {
		        plate = plate + alphabet.charAt(random.nextInt(index));
		    }
		// generate 3 random numbers i.e. 789
		String platenum = Integer.toString(random.nextInt(899) + 100);
		// combine them and return
		plate = plate + platenum;
    	return plate;
    }
 
    private CarType model = null;
    private String plate = "";
    private int cost = 0;
    
    public int getCost(int rental_length) {
    	return rental_length*cost;
    }
    public int getCost(){
        return cost;
    }
 
    public CarType getModel() {
        return model;
    }

    public String getPlate(){
        return this.plate;
    }

    public String toString(){
        return "plate: " + this.plate + ", model:" + this.model;
    }
    /*  For returning the base car when removing option decorators*/
    public Car getBaseCar(){
        return this;
    }
}
