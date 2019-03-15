package files.objectSerialization;

import inheritance.Car;

import java.io.IOException;
import java.util.Date;

public class ObjectSerializationTest {
    public static final String TEST_FILE = "Files\\inputFiles\\Objects File.txt";

    public static void main(String[] args) throws IOException {
//        Writing Object To File.
        WriteObjectToFile.openFile(TEST_FILE);
        Car car = new Car("123", "Red", "123464",new Date(),4,4,6);
        WriteObjectToFile.addRecordsToTheFile(car);
        WriteObjectToFile.closingFile();

//        Reading From File.
        ReadObjectFromFile.openFile(TEST_FILE);
        Car carFromFile= (Car) ReadObjectFromFile.readRecord();
        ReadObjectFromFile.closingFile();
        System.out.println(carFromFile);
    }
}
