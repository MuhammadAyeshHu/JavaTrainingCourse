package networkProgramming;

import networkProgramming.IOStreams.ReadingFromSocket;
import networkProgramming.IOStreams.WriteToSocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    private final WriteToSocket writeToSocket;
    private final ReadingFromSocket readingFromSocket;
    private Socket clientSocket;
    private Scanner scanner;
    private BufferedWriter bufferedWriter;

    public Server(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        writeToSocket = new WriteToSocket(clientSocket);
        readingFromSocket = new ReadingFromSocket(clientSocket);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(readingFromSocket.readLine());
        }
    }

    private void writeToServer(Scanner scanner) {
        while (scanner.hasNext()) {
            writeToSocket.write(scanner.nextLine());
        }
    }

    private void readFromServer() {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(readingFromSocket.readLine());
            }
        });
        thread.start();
    }
}
