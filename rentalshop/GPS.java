package rentalshop;
import rentalshop.carfactory.*;
public class GPS extends OptionsDecorator {

    public GPS(Car theCar) {
        super(theCar);
        this.selected = theCar;
    }
    
    // Adds the cost of the option to the respective type of car
    public int getCost(int rental_length) {
        if (this.getModel() == CarType.ECONOMY) {
            return this.selected.getCost(rental_length) + 10;
        }
        else if (this.getModel() == CarType.LUXURY) {
            return this.selected.getCost(rental_length) + 40;
        }
        else if (this.getModel() == CarType.SUV) {
            return this.selected.getCost(rental_length) + 30;
        }
        else if (this.getModel() == CarType.STANDARD) {
            return this.selected.getCost(rental_length) + 20;
        }
        else if (this.getModel() == CarType.MINIVAN) {
            return this.selected.getCost(rental_length) + 20;
        }
        else {
            return -1;
        }
    }
    
    // Appends the GPS string to the car's information
    public String toString() {
        return this.selected.toString() + " +GPS";  
    }
}
