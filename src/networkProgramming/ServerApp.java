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
                    System.out.println("Client Connected!");
                    //creating clients connection listener
                    ServerWorker serverWorker = new ServerWorker(clientSocket);
                    threadPool.execute(serverWorker);
                } catch (BindException e) {
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
