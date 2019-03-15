package inheritance;

import java.util.Date;

public class InheritanceTest {
    public static void main(String[] args) {

//        // Instantiating object of  class Vehicle.
//        System.out.println("Vehicle class version");
//        Vehicle vehicle = new Vehicle("123-111", "Black", "111-11", new Date());
//        vehicle.accelerate(); // vehicle version.
//        vehicle.brakePedal(); // vehicle version.

        System.out.println("\nCar class version");
        Car car = new Car("999-999", "Red", "55", new Date(),4, 4, 6);
        car.accelerate();
        car.brakePedal();

        Truck truck = new Truck("999-999", "Red", "55", new Date());

        System.out.println(car.getColor());
        System.out.println(truck.getColor());

        car.fillFuel();

        Vehicle v = new Car("999-999", "Red", "55", new Date(),4, 4, 6);
        System.out.println(v.getColor());
        System.out.println(v instanceof Car);
        System.out.println(v instanceof Vehicle);
        System.out.println(car instanceof Vehicle );

        if(v instanceof Car) {
            Car newCar = (Car) v;
            newCar.method1();
        }

    }
}
