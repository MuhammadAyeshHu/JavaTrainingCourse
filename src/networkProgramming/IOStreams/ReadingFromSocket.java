package networkProgramming.IOStreams;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Muhammad Ayesh on 4/24/2017.
 *
 * Reads strings from the socket.
 */
public class ReadingFromSocket {

    private DataInputStream dataInputStream;

    /**
     * Constructor.
     * @param socket
     * socket.
     */
    public ReadingFromSocket(Socket socket) {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads line of strings.
     * @return
     * String.
     */
    public String readLine() {

        String line = null;
        try {
            while (dataInputStream.available() == 0) {}
            line = dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
