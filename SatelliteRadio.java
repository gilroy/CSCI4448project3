public class SatelliteRadio extends OptionsDecorator {
    public Car selected;

    void SatelliteRadio(Car theCar) {
        this.selected = theCar;
    }

    // Adds the correct cost of the option to the car subtype
    int cost(int rental_length) {
        if (this.selected instanceof EconomyCar) {
            return this.selected.getCost(rental_length) + 8;
        }
        else if (this.selected instanceof LuxuryCar) {
            return this.selected.getCost(rental_length) + 40;
        }
        else if (this.selected instanceof SUVCar) {
            return this.selected.getCost(rental_length) + 20;
        }
        else if (this.selected instanceof StandardCar) {
            return this.selected.getCost(rental_length) + 15;
        }
        else if (this.selected instanceof MinivanCar) {
            return this.selected.getCost(rental_length) + 15;
        }
        else {
            return -1;
        }
    }
    // Appends the Satellite radio string to the car's information
    String toString() {
        return this.selected.toString() + " + Satellite radio";    
    }
}
