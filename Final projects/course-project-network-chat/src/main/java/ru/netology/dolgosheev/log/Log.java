package ru.netology.dolgosheev.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static Log instance = null;
    public static final String LOGPATH = "./logs/log.txt";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Log() {
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void log(String message) {
        try {
            FileWriter writer = new FileWriter(LOGPATH, true);
            writer.write(LocalDateTime.now().format(formatter) + " " + message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
