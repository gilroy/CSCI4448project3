

public class CarSeat extends OptionsDecorator {
    private int inUse;

    void CarSeat(int randNumbSeats) {
        this.inUse = randNumbSeats;
    }

    int cost(Car car) {
        if (car instanceof EconomyCar) {
            return this.inUse * 5;
        }
        else if (car instanceof LuxuryCar) {
            return this.inUse * 20;
        }
        else if (car instanceof SUVCar) {
            return this.inUse * 15;
        }
        else if (car instanceof StandardCar) {
            return this.inUse * 10;
        }
        else if (car instanceof MinivanCar) {
            return this.inUse * 10;
        }
        else {
            return -1;
        }
    }
    String toString() {
        if (inUse == 1) {
            return "child car seat";
        }
        else if (inUse > 1) {
            return inUse + "child car seats";
        }
        else {
            return "";
        }
    }
}
