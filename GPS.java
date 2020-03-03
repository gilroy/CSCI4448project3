public class GPS extends OptionsDecorator {
    public Car selected;

    void GPS(Car theCar) {
        this.selected = theCar;
    }

    int cost() {
        if (this.selected instanceof EconomyCar) {
            return this.selected.getPrice() + 10;
        }
        else if (this.selected instanceof LuxuryCar) {
            return this.selected.getCost() + 40;
        }
        else if (this.selected instanceof SUVCar) {
            return this.selected.getCost() + 30;
        }
        else if (this.selected instanceof StandardCar) {
            return this.selected.getCost() + 20;
        }
        else if (this.selected instanceof MinivanCar) {
            return this.selected.getCost() + 20;
        }
        else {
            return -1;
        }
    }
    /*
        Returns the car string along with 
    */
    String toString() {
        return this.selected.toString() + "GPS";  
    }
}
