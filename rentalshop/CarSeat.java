package rentalshop;
import rentalshop.carfactory.*;
public class CarSeat extends OptionsDecorator {

    public CarSeat(Car theCar) {
        super(theCar);
        this.selected = theCar;
    }

    // Adds the correct cost of the option to the car subtype
    public int getCost(int rental_length) {
        if (this.getModel() == CarType.ECONOMY) {
            return this.selected.getCost(rental_length) + 5;
        }
        else if (this.getModel() == CarType.LUXURY) {
            return this.selected.getCost(rental_length) + 20;
        }
        else if (this.getModel() == CarType.SUV) {
            return this.selected.getCost(rental_length) + 15;
        }
        else if (this.getModel() == CarType.STANDARD) {
            return this.selected.getCost(rental_length) + 10;
        }
        else if (this.getModel() == CarType.MINIVAN) {
            return this.selected.getCost(rental_length) + 10;
        }
        else {
            return -1;
        }
    }
    // Appends the car seat string to the car's info
    public String toString() {
        return this.selected.toString() + " +child-seat";
    }
}
