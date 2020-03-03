public class GPS extends OptionsDecorator {
    public Car selected;

    void GPS(Car theCar) {
        this.selected = theCar;
    }
    
    // Adds the cost of the option to the respective type of car
    int cost(int rental_length) {
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
    
    // Appends the GPS string to the car's information
    String toString() {
        return this.selected.toString() + " + GPS";  
    }
}
