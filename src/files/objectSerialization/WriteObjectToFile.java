package files.objectSerialization;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Muhammad Ayesh on 3/31/2017.
 * Writing object to a file
 */
public class WriteObjectToFile {
    private static ObjectOutputStream writeObject;

    /**
     * Open or create a file to write
     */
    public static void openFile(String path) {
        try {
            String p = Paths.get(path).toAbsolutePath().toString();
            writeObject = new ObjectOutputStream(Files.newOutputStream(Paths.get(p), StandardOpenOption.CREATE,StandardOpenOption.APPEND));
        } catch (IOException e) {
            System.err.println("Error opening file..\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Adding records to the file.
     * takes any object as an input
     * @param object
     */
    public static void addRecord(Object object) {
        try {
            writeObject.writeObject(object);
        } catch (NotSerializableException e) {
            System.err.println("Object doesn't implement Serializable\n" + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error Writing to a file..\n" + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Closing the file
     */
    public static void closingFile() {
        try {
            if (writeObject != null)
                writeObject.close();
        } catch (IOException e) {
            System.err.println("Error closing the file..\n" + e.getMessage());
            System.exit(1);
        }
    }
}
