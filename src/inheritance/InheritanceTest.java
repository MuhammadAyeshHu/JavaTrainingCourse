package inheritance;

import java.util.Date;

public class InheritanceTest {
    public static void main(String[] args) {

        // Instantiating object of  class Vehicle.
        System.out.println("Vehicle class version");
        Vehicle vehicle = new Vehicle("123-111", "Black", "111-11", new Date());
        vehicle.accelerate(); // vehicle version.
        vehicle.brakePedal(); // vehicle version.

        System.out.println("\nCar class version");
        Car car = new Car("999-999", "Red", "55", new Date(),4, 4, 6);
        car.accelerate();
        car.brakePedal();
    }
}
