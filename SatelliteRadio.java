public class SatelliteRadio extends OptionsDecorator {
    public Car selected;

    void SatelliteRadio(Car theCar) {
        this.selected = theCar;
    }

    // Adds the correct cost of the option to the car subtype
    int cost() {
        if (this.selected instanceof EconomyCar) {
            return this.selected.getCost() + 8;
        }
        else if (this.selected instanceof LuxuryCar) {
            return this.selected.getCost() + 40;
        }
        else if (this.selected instanceof SUVCar) {
            return this.selected.getCost() + 20;
        }
        else if (this.selected instanceof StandardCar) {
            return this.selected.getCost() + 15;
        }
        else if (this.selected instanceof MinivanCar) {
            return this.selected.getCost() + 15;
        }
        else {
            return -1;
        }
    }
    String toString() {
        return this.selected.toString() + "Satellite radio";    
    }
}
