package networkProgramming;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        try {
            Socket socket =  new Socket("127.0.0.1", 5000);
            Client client = new Client(socket);
            Thread thread = new Thread(client);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

