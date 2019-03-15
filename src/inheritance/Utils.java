package inheritance;

public interface Utils {

     void fillFuel();

    public default double travelledDistance() {
        // implementation
        double distance = 0;
        return distance;
    }
}