package rentalshop;
import rentalshop.carfactory.*;
public class SatelliteRadio extends OptionsDecorator {

    public SatelliteRadio(Car theCar) {
        super(theCar);
        this.selected = theCar;
    }
    // Adds the correct cost of the option to the car by subtype
    @Override
    public int getCost(int rental_length) {
        if (this.getModel() == CarType.ECONOMY) {
            return this.selected.getCost(rental_length) + 8;
        }
        else if (this.getModel() == CarType.LUXURY) {
            return this.selected.getCost(rental_length) + 40;
        }
        else if (this.getModel() == CarType.SUV) {
            return this.selected.getCost(rental_length) + 20;
        }
        else if (this.getModel() == CarType.STANDARD) {
            return this.selected.getCost(rental_length) + 20;
        }
        else if (this.getModel() == CarType.MINIVAN) {
            return this.selected.getCost(rental_length) + 15;
        }
        else {
            return -1;
        }
    }

    // Appends the Satellite radio string to the car's information
    @Override
    public String toString() {
        return this.selected.toString() + " +Sat-radio";    
    }
}
