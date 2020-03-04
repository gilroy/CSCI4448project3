package rentalshop;
import rentalshop.carfactory.*;

public abstract class OptionsDecorator extends Car{
    /*
        The cost function is overridden by each option class, since they don't have the same prices.
        
        toString() allows the option to be output along with the car's information during runtime
        
        selected stores the car that the option is attached to
    */

    // Passes given car arguments fields to car construtor to create a new copy of the car that is also instance of the decorator
    public OptionsDecorator(Car car){
        super(car.getModel(), car.getCost(), car.getPlate());
    }

    abstract public int getCost(int rental_length);
    abstract public String toString();
    protected Car selected;
    /*  get the original cars CarType */
    public CarType getModel(){
        return this.selected.getModel();
    }

    /*  get the original car when we no longer want the decorators */
    public Car getBaseCar(){
        return this.selected.getBaseCar();
    }
}
