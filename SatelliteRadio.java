public class SatelliteRadio extends OptionsDecorator {
    private int inUse;

    void SatelliteRadio(int randNumRadio) {
        this.inUse = randNumRadio;
    }

    int cost(Car car) {
        if (car instanceof EconomyCar) {
            return this.inUse * 8;
        }
        else if (car instanceof LuxuryCar) {
            return this.inUse * 40;
        }
        else if (car instanceof SUVCar) {
            return this.inUse * 20;
        }
        else if (car instanceof StandardCar) {
            return this.inUse * 15;
        }
        else if (car instanceof MinivanCar) {
            return this.inUse * 15;
        }
        else {
            return -1;
        }
    }
    String toString(Car car) {
        String carInfo = car.toString();
        if (inUse) {
            return carInfo + "Satellite radio";  
        }
        else {
            return carInfo;   
        } 
    }
}
