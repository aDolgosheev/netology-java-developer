package ru.netology.dolgosheev.server;

import ru.netology.dolgosheev.config.Config;

public class MainServer {

    public static void main(String[] args) {
        Config config = Config.getInstance();
        Server server = new Server();
        server.listen(config.getPort());
    }
}
