package inheritance;

import java.util.Date;

public class Truck extends Vehicle {

    public Truck(String panelNumber, String color, String modelNumber, Date factoryDate) {
        super(panelNumber, color, modelNumber, factoryDate);
    }

    @Override
    public String getColor() {
        return "Truck color is : " + this.color;
    }


}