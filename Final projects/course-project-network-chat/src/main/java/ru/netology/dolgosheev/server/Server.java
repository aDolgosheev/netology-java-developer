package ru.netology.dolgosheev.server;

import ru.netology.dolgosheev.log.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

    private static final Log LOG = Log.getInstance();

    private ServerSocket serverSocket;
    private Socket socket;

    private final List<Connection> connections = Collections.synchronizedList(new ArrayList<>());

    public void listen(int port) {
        try {
            serverSocket = new ServerSocket(port);
            LOG.log("Server started!");
            System.out.println("Server started!");

            while (true) {
                socket = serverSocket.accept();
                final Connection connection = new Connection(socket);
                connections.add(connection);
                connection.start();
            }
        } catch (IOException e) {
            LOG.log("Class error " + Server.class.getName());
            e.printStackTrace();
        } finally {
            LOG.log("Closing thread for a class " + Server.class.getName());
            closeAll();
        }
    }

    private void closeAll() {
        try {
            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            LOG.log("Closing thread for a class error " + Server.class.getName());
            e.printStackTrace();
        }
    }

    private class Connection extends Thread {

        private BufferedReader input;
        private PrintWriter output;

        public Connection(Socket socket) {
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                LOG.log("Class error " + Connection.class.getName());
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String name = input.readLine();
                LOG.log(name + " cames now");
                sendMessageAllConnection(name + " cames now");

                String message;
                while (true) {
                    message = input.readLine();
                    if ("exit".equals(message)) {
                        break;
                    }
                    LOG.log(name + ": " + message);
                    sendMessageAllConnection(name + ": " + message);
                }

                LOG.log(name + " has left");
                sendMessageAllConnection(name + " has left");
            } catch (IOException e) {
                LOG.log("Class error " + Connection.class.getName());
                e.printStackTrace();
            } finally {
                LOG.log("Closing thread for a class " + Connection.class.getName());
                closeAll();
            }
        }

        private void closeAll() {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMessage(String message) {
            output.println(message);
        }

        private void sendMessageAllConnection(String message) {
            synchronized(connections) {
                connections.forEach(connection -> connection.sendMessage(message));
            }
        }
    }
}
