package singleton;

/**
 * This file is created by Muhammad Ayesh in 3/9/2019.
 */
public class SingletonTest {
    public static void main(String[] args) {
        // Notice that we can't use "new" to create instance here.
        EagerContextDesign eagerContext = EagerContextDesign.getContext();
        // For short in intelliJ (sout).
        System.out.println(eagerContext); // This will call toString method

        // Notice that we can't use "new" to create instance here.
        LazyContextDesign lazyContext = LazyContextDesign.getContext();
        // For short in intelliJ (sout).
        System.out.println(lazyContext); // This will call toString method
    }
}
