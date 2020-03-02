package factory;

public class CarFactory {
    public static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
        case STANDARD:
            car = new StandardCar();
            break;
        case SUV:
            car = new SUVCar();
            break;
        case LUXURY:
            car = new LuxuryCar();
            break;
        case ECONOMY:
            car = new EconomyCar();
            break;
        case MINIVAN:
            car = new MinivanCar();
            break;  
        default:
            break;
        }
        return car;
    }
}
