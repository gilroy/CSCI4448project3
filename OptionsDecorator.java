public abstract class OptionsDecorator extends Car {
    /*
        inUse: the number of options in use on the car
        (1 or 0 for GPS and Satellite Radio, 0 to 4 for car seat)
        
        The cost function is overridden by each option class, since they don't have the same prices.
    */
    abstract int cost(Car car);
    int inUse;
}
