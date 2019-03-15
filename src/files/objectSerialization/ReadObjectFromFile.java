package files.objectSerialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Muhammad Ayesh on 3/31/2017.
 *
 * Reading Object From file.
 */
public class ReadObjectFromFile {
    private static ObjectInputStream readObject;

    /**
     * Open or create a file to read
     */
    public static void openFile(String path) throws IOException {
        try {
            String p = Paths.get(path).toAbsolutePath().toString();
            readObject = new ObjectInputStream(Files.newInputStream(Paths.get(p)));
        } catch (IOException e) {
            System.err.println("Error opening file..\n" + e.getMessage());
        }
    }

    /**
     * /**
     * Adding records to the file.
     * Returns any object as an output
     * @return
     */
    public static Object readRecord() throws IOException {
        Object object = null;
        try {
            object = readObject.readObject();
            return object;
        } catch (EOFException e) {
            System.out.println("No more records.");
        } catch (IOException e) {
            System.err.println("Error reading from file..\n" + e.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Invalid object type..\n" + e.getMessage());
            System.exit(1);
        }
        return object;
    }

    /**
     * Closing the file
     */
    public static void closingFile() throws IOException {
        try {
            if (readObject != null) {
                readObject.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the file..\n" + e.getMessage());
            System.exit(1);
        }
    }
}
