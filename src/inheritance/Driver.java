package inheritance;

import java.io.Serializable;

public class Driver implements Serializable {
    /**
     *     This serialVersionUID is stored with the serialized object and assists during the deserialization process.
     *     The serialization process uses the serialVersionUID to identify uniquely a version of the class. That way, it
     *     knows whether the serialized data for an object will match the instance variable in the current version of the
     *     class. If an older version of the class is encountered during deserialization, an exception may be thrown.
     *     Alternatively, some deserialization tools support conversions automatically.
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
