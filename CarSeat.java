

public class CarSeat extends OptionsDecorator {
    private Car selected;

    void CarSeat(Car theCar) {
        this.selected = theCar;
    }

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
    String toString() {
        return this.selected.toString() + "child car seat";
    }
}
