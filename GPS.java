public class GPS extends OptionsDecorator {
    private int inUse;

    void GPS(int randNumGPS) {
        this.inUse = randNumGPS;
    }

    int cost(Car car) {
        if (car instanceof EconomyCar) {
            return this.inUse * 10;
        }
        else if (car instanceof LuxuryCar) {
            return this.inUse * 40;
        }
        else if (car instanceof SUVCar) {
            return this.inUse * 30;
        }
        else if (car instanceof StandardCar) {
            return this.inUse * 20;
        }
        else if (car instanceof MinivanCar) {
            return this.inUse * 20;
        }
        else {
            return -1;
        }
    }
    String toString(Car car) {
        String carInfo = car.toString();
        if (inUse) {
            return carInfo + "GPS";  
        }
        else {
            return carInfo + "None";   
        }
    }
}
