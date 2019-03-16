package networkProgramming;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    private static ExecutorService threadPool;

    public static void main(String[] args) {
        try {
            threadPool = Executors.newCachedThreadPool();

            System.out.println("waiting for clients");
            while (true) {
                try {
                    ServerSocket server = new ServerSocket(5000);
                    Socket clientSocket = server.accept();

                    //creating clients connection listener
                    Server serverObject = new Server(clientSocket);
                    threadPool.execute(serverObject);
                } catch (BindException e) {
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
