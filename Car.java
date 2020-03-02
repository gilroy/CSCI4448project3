
package carDealership;

public class Car{

    private String license_plate;

    public Car(String license_plate){
        this.license_plate = license_plate;
    }

    public String getLicensePlate(){
        return this.license_plate;
    }

    public String toString() {
        return "IMPLEMENT";
    }
}