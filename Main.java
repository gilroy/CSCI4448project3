package carDealership;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class Main{
    public static void main(String [] args){
        //  intialize store and store observer
        Store store = new Store();
        StoreObserver daily_update = new StoreObserver(store);
        
        //  instantiate 12 customers
        store.addCustomer( new Customer("Adam"));
        store.addCustomer( new Customer("Bevis"));
        store.addCustomer( new Customer("Charly"));
        store.addCustomer( new Customer("Dereck"));
        store.addCustomer( new Customer("Eve"));
        store.addCustomer( new Customer("Farah"));
        store.addCustomer( new Customer("Grace"));
        store.addCustomer( new Customer("Henry"));
        store.addCustomer( new Customer("Ignus"));
        store.addCustomer( new Customer("Jackie"));
        store.addCustomer( new Customer("Kate"));
        store.addCustomer( new Customer("Lucy"));

        //  Instantiate 24 cars;
        store.addCar(new Car("AAAAAA"));
        store.addCar(new Car("BBBBBB"));
        store.addCar(new Car("CCCCCC"));
        store.addCar(new Car("DDDDDD"));
        store.addCar(new Car("EEEEEE"));
        store.addCar(new Car("FFFFFF"));
        store.addCar(new Car("GGGGGG"));
        store.addCar(new Car("HHHHHH"));
        store.addCar(new Car("IIIIII"));
        store.addCar(new Car("JJJJJJ"));
        store.addCar(new Car("KKKKKK"));
        store.addCar(new Car("LLLLLL"));
        store.addCar(new Car("MMMMMM"));
        store.addCar(new Car("NNNNNN"));
        store.addCar(new Car("OOOOOO"));
        store.addCar(new Car("PPPPPP"));
        store.addCar(new Car("QQQQQQ"));
        store.addCar(new Car("RRRRRR"));
        store.addCar(new Car("SSSSSS"));
        store.addCar(new Car("TTTTTT"));
        store.addCar(new Car("UUUUUU"));
        store.addCar(new Car("VVVVVV"));
        store.addCar(new Car("WWWWWW"));
        store.addCar(new Car("XXXXXX"));

        //  35 Day main loop
        for (int day = 1; day<=35; day++){
            System.out.println("######### DAY "+day+" #########");
            store.OneDay(day);
        }


        int business_rentals=0;
        int casual_rentals=0;
        int regular_rentals=0;

        
        
    }
}