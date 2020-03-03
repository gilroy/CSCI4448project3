

public class CarSeat extends OptionsDecorator {
    private Car selected;

    void CarSeat(Car theCar) {
        this.selected = theCar;
    }

    int cost(Car car) {
        if (car instanceof EconomyCar) {
            return this.selected.getCost() + 5;
        }
        else if (car instanceof LuxuryCar) {
            return this.selected.getCost() + 20;
        }
        else if (car instanceof SUVCar) {
            return this.selected.getCost() + 15;
        }
        else if (car instanceof StandardCar) {
            return this.selected.getCost() + 10;
        }
        else if (car instanceof MinivanCar) {
            return this.selected.getCost() + 10;
        }
        else {
            return -1;
        }
    }
    String toString() {
        if (inUse == 1) {
            return this.selected.toString() + "child car seat";
        }
        else {
            return this.selected.toString() + "";
        }
    }
}
