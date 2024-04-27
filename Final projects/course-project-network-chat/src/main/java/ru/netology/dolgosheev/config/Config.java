package ru.netology.dolgosheev.config;

import ru.netology.dolgosheev.log.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Config instance;

    private static final Log LOGGER = Log.getInstance();
    private static final String PATH = "./settings/settings.properties";

    private int port;
    private String host;

    private Config() {
        FileInputStream fileSettings = null;
        try {
            fileSettings = new FileInputStream(PATH);
            Properties properties = new Properties();
            properties.load(fileSettings);
            port = Integer.parseInt(properties.getProperty("port"));
            host = properties.getProperty("host");
        } catch (FileNotFoundException e1) {
            LOGGER.log("Properties config file not found");
        } catch (IOException e2) {
            LOGGER.log("Class error " + Config.class.getName());
            e2.printStackTrace();
        } finally {
            try {
                fileSettings.close();
            } catch (IOException e3) {
                LOGGER.log("Class error " + Config.class.getName());
                e3.printStackTrace();
            }
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}