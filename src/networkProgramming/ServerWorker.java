package networkProgramming;

import networkProgramming.IOStreams.ReadingFromSocket;
import networkProgramming.IOStreams.WriteToSocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerWorker implements Runnable {
    private final WriteToSocket writeToSocket;
    private final ReadingFromSocket readingFromSocket;
    private Socket clientSocket;
    private Scanner scanner;
    private BufferedWriter bufferedWriter;

    public ServerWorker(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        writeToSocket = new WriteToSocket(clientSocket);
        readingFromSocket = new ReadingFromSocket(clientSocket);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        clientListener();
        writeToClient(scanner);
    }

    private void clientListener() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(readingFromSocket.readLine());
                }
            }
        });
        thread.start();
    }

    private void writeToClient(Scanner scanner) {
        while (scanner.hasNext()) {
            writeToSocket.write(scanner.nextLine());
        }
    }
}
