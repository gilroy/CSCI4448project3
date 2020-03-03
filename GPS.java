public class GPS extends OptionsDecorator {
    public selected;

    void GPS(Car theCar) {
        this.selected = theCar;
    }

    int cost(Car car) {
        if (car instanceof EconomyCar) {
            return this.selected.getPrice() + 10;
        }
        else if (car instanceof LuxuryCar) {
            return this.selected.getCost() + 40;
        }
        else if (car instanceof SUVCar) {
            return this.selected.getCost() + 30;
        }
        else if (car instanceof StandardCar) {
            return this.selected.getCost() + 20;
        }
        else if (car instanceof MinivanCar) {
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
        if (inUse) {
            return this.selected.toString() + "GPS";  
        }
        else {
            return this.selected.toString() + "";   
        }
    }
}
