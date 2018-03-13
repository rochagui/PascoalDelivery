package org.academiadecodigo.hexallents;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 13/03/2018.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private int portNumber = 8000;
    private ClientInterface clientInterface;

    public Server() {

        try {
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenu(){
        try {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            clientInterface = new ClientInterface(socket.getInputStream(), printStream);
            clientInterface.init();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
