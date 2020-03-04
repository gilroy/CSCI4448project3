package rentalshop.carfactory;

public class Factory {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.STANDARD));
        System.out.println(CarFactory.buildCar(CarType.SUV));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
        System.out.println(CarFactory.buildCar(CarType.ECONOMY));
        System.out.println(CarFactory.buildCar(CarType.MINIVAN));
    }
}