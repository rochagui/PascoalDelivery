package org.academiadecodigo.hexallents.Server;

import org.academiadecodigo.hexallents.BootStrap;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerWorker implements Runnable {


    private BootStrap bootStrap;
    private PrintStream printStream;
    private InputStream inputStream;


    public void setBootStrap(BootStrap bootStrap) {
        this.bootStrap = bootStrap;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public void run() {
        bootStrap.wireObjects().init();
    }

    public void closeConnection() {

    }
}
