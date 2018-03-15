package org.academiadecodigo.hexallents.Server;

import org.academiadecodigo.hexallents.MenuController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by codecadet on 13/03/2018.
 */
public class Server {
    private ServerSocket serverSocket;
    public final static int DEFAULT_PORT = 6666;
    private List<ServerWorker> workers = Collections.synchronizedList(new ArrayList<ServerWorker>());

    public static void main(String[] args) {

        int port = DEFAULT_PORT;

        try {

            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }

            Server chatServer = new Server();
            chatServer.start(port);

        } catch (NumberFormatException ex) {

            System.out.println("Usage: java ChatServer [port_number]");
            System.exit(1);

        }

    }


    public void start(int port) {

        System.out.println("DEBUG: Server instance is : " + this);

        int connectionCount = 0;

        try {

            // Bind to local port
            System.out.println("Binding to port " + port + ", please wait  ...");
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);

            while (true) {

                // Block waiting for client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket);

                try {

                    connectionCount++;
                    String name = "Client-" + connectionCount;
                    ServerWorker worker = new ServerWorker(name, clientSocket);
                    workers.add(worker);


                    Thread thread = new Thread(worker);
                    thread.setName(name);
                    thread.start();

                } catch (IOException ex) {
                    System.out.println("Error receiving client connection: " + ex.getMessage());
                }

            }

        } catch (IOException e) {
            System.out.println("Unable to start server on port " + port);
        }

    }

    private class ServerWorker implements Runnable {

        final private String name;
        private MenuController menuController;


        public ServerWorker(String name, Socket clientSocket) throws IOException {

            this.name = name;
            PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
            menuController = new MenuController(clientSocket.getInputStream(), printStream);
        }

        @Override
        public void run() {
            menuController.init();
        }

    }
}
