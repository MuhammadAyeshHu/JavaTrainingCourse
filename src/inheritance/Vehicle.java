package inheritance;

import java.util.Date;

public abstract class Vehicle {
    private String panelNumber;
    protected String color;
    private String modelNumber;
    private Date factoryDate;

    public Vehicle(String panelNumber, String color, String modelNumber, Date factoryDate) {
        this.panelNumber = panelNumber;
        this.color = color;
        this.modelNumber = modelNumber;
        this.factoryDate = factoryDate;
    }

    public abstract String getColor();

    public void setColor(String color) {
        this.color = color;
    }

    public String getPanelNumber() {
        return panelNumber;
    }

    public void setPanelNumber(String panelNumber) {
        this.panelNumber = panelNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Date getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(Date factoryDate) {
        this.factoryDate = factoryDate;
    }

    public void accelerate() {
        System.out.println("Accelerate Vehicle");
    }

    public void brakePedal() {
        System.out.println("Stop Vehicle");
    }

    @Override
    public String toString() {
        return "This is the vehicle class general specifications";
    }
}
