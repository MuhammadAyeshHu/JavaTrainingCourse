package singleton;

/**
 * This file is created by Muhammad Ayesh in 3/9/2019.
 *
 * There are two types of Singleton design pattern (Eager and Lazy).
 * To implement an eager singleton design pattern, you have to apply the main three rules:
 * <ul>
 * <li>Declare the private no-args constructor.</li>
 * <li>Declare a static field of the same class.</li>
 * <li>Implement a static method to return that field when it's required.</li>
 * </ul>
 */
public class EagerContextDesign {
    private static EagerContextDesign context = new EagerContextDesign();// private Static Field

    // private Constructor.
    private EagerContextDesign() {
    }

    // getMethod to get the one and the only instance of the class.
    public static EagerContextDesign getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "The Eager Implementation of the Singleton Design pattern";
    }
}
