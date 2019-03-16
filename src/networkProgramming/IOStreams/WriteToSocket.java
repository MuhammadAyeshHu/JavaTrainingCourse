package networkProgramming.IOStreams;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Muhammad Ayesh on 4/24/2017.
 *
 * Writes strings to the socket.
 */
public class WriteToSocket {
    private Socket socket;
    private DataOutputStream write;

    /**
     * Constructor.
     * @param socket
     * socket.
     */
    public WriteToSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Writes line of strings.
     * @return
     * String.
     */
    public void write(String string) {
        try {
            write = new DataOutputStream(socket.getOutputStream());
            write.writeUTF(string);
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        write = null;
    }

}
