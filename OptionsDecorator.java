public abstract class OptionsDecorator extends Car {
    /*
        The cost function is overridden by each option class, since they don't have the same prices.
        
        toString() allows the option to be output along with the car's information during runtime
        
        selected stores the car that the option is attached to
    */
    abstract int cost();
    abstract String toString();
    Car selected;
}
