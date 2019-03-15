package inheritance;

import java.io.Serializable;
import java.util.Date;

public class Car extends Vehicle implements Utils, Serializable {
    private static final long serialVersionUID = 1L;
    private int doorsCount;
    private int wheelsCount;
    private int gearCount;

    public Car(String panelNumber, String color, String modelNumber, Date factoryDate, int doorsCount, int wheelsCount, int gearCount) {
        // explicit call to superclass Vehicle constructor.
        // you must use super in the constructor when you inherit a class with no-args constructor.
        super(panelNumber, color, modelNumber, factoryDate);
        this.doorsCount = doorsCount;
        this.wheelsCount = wheelsCount;
        this.gearCount = gearCount;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    @Override
    public String getColor() {
        return "Car color is: " + this.color ;
    }

    @Override
    public void accelerate() {
        super.accelerate(); // will using super method first.
        System.out.println("Accelerate Car");
    }

    @Override
    public void brakePedal() {
        System.out.println("Stop Car");
        super.brakePedal(); // will using super method second.
    }

    @Override
    public String toString() {
        return "Color:\t" + getColor() + ",\tModel Number:\t" + getModelNumber();
    }

    @Override
    public void fillFuel() {
        // imp
        System.out.println("Car fuel is full");
    }

    public void method1() {
        System.out.println("test");
    }
}
