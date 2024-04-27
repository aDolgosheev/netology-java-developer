package ru.netology.dolgosheev.client;

import ru.netology.dolgosheev.config.Config;
import ru.netology.dolgosheev.log.Log;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final Log LOG = Log.getInstance();

    private Scanner scanner;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client() {
        try {
            final Config config = Config.getInstance();

            scanner = new Scanner(System.in);
            socket = new Socket(config.getHost(), config.getPort());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            LOG.log("The client is asked to enter his nickname");
            System.out.println("Choose your nickname:");
            out.println(scanner.nextLine());

            final Receiver receiver = new Receiver(in);
            receiver.start();

            String message = "";
            while (!"exit".equals(message)) {
                message = scanner.nextLine();
                out.println(message);
            }

            receiver.interrupt();
        } catch (IOException e) {
            LOG.log("Class error " + Client.class.getName());
            e.printStackTrace();
        } finally {
            LOG.log("Closing thread for a class " + Client.class.getName());
            closeAll();
        }
    }

    private void closeAll() {
        try {
            scanner.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            LOG.log("Closing thread for a class error " + Client.class.getName());
            e.printStackTrace();
        }
    }

    private class Receiver extends Thread {

        private static final Log LOG = Log.getInstance();

        private final BufferedReader input;

        public Receiver(BufferedReader input) {
            this.input = input;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(input.readLine());
                }
            } catch (IOException e) {
                LOG.log("Class error " + ru.netology.dolgosheev.client.Client.Receiver.class.getName());
                e.printStackTrace();
            }
        }
    }
}
