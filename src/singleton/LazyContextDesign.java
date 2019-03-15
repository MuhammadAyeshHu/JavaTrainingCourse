package singleton;

/**
 * This file is created by Muhammad Ayesh in 3/9/2019.
 *
 * There are two types of Singleton design pattern (Eager and Lazy).
 * To implement the Lazy singleton design pattern, you have to apply the main three rules:
 * <ul>
 * <li>Declare the private no-args constructor.</li>
 * <li>Declare a static field of the same class but don't instantiate it.</li>
 * <li>Implement a static method to return that field when it's required.</li>
 * </ul>
 */
public class LazyContextDesign {
    private static LazyContextDesign context = null;// private Static Field

    // private Constructor.
    private LazyContextDesign() {
    }

    // getMethod to get the one and the only instance of the class.
    // synchronized keyword is used here to solve race condition in multi-threaded
    // program (Two or more calls to getContext() method at the same time).
    public static synchronized LazyContextDesign getContext() {
        if (context == null) {
            context = new LazyContextDesign();
        }
        return context;
    }

    @Override
    public String toString() {
        return "The Lazy Implementation of the Singleton Design pattern";
    }
}
