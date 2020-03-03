public class CarSeat extends OptionsDecorator {
    private Car selected;

    void CarSeat(Car theCar) {
        this.selected = theCar;
    }

    // Adds the correct cost of the option to the car subtype
    int cost() {
        if (this.selected instanceof EconomyCar) {
            return this.selected.getCost() + 5;
        }
        else if (this.selected instanceof LuxuryCar) {
            return this.selected.getCost() + 20;
        }
        else if (this.selected instanceof SUVCar) {
            return this.selected.getCost() + 15;
        }
        else if (this.selected instanceof StandardCar) {
            return this.selected.getCost() + 10;
        }
        else if (this.selected instanceof MinivanCar) {
            return this.selected.getCost() + 10;
        }
        else {
            return -1;
        }
    }
    // Appends the car seat string to the car's info
    String toString() {
        return this.selected.toString() + "child car seat";
    }
}
