package factory;
import java.util.Random;

public abstract class Car {
	 
    public Car(CarType model, int cost) {
        this.model = model;
        this.plate = getPlate();
        this.cost = cost;
    }
 
    private String getPlate() {
    	Random random = new Random();
    	final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	final int index = alphabet.length();
    	
    	// generate 3 random letters i.e. ABC
		String plate = "";
		 for (int i = 0; i < 3; i++) {
		        plate = plate + alphabet.charAt(random.nextInt(index));
		    }
		// generate 3 random numbers i.e. 789
		String platenum = Integer.toString(random.nextInt(999));
		// combine them and return
		plate = plate + platenum;
    	return plate;
    }
 
    // Do subclass level processing in this method
    protected abstract void construct();
 
    private CarType model = null;
    private String plate = "";
    private int cost = 0;
    
    public int getCost() {
    	return cost;
    }
    
    public void setModel(int cost) {
        this.cost = cost;
    }
 
    public CarType getModel() {
        return model;
    }
 
    public void setModel(CarType model) {
        this.model = model;
    }
}