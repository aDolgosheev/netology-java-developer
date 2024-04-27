package ru.netology.dolgosheev.log;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    private static final Log LOG = Log.getInstance();
    private static final String MESSAGE = "Second test message.";
    private static final String LOGPATH = "./logs/log.txt";

    @Test
    void getInstance() {
        assertEquals(Log.getInstance(), LOG);
    }

    @Test
    void log() throws IOException {
        LOG.log(MESSAGE);
        assertTrue(new BufferedReader(new InputStreamReader(
                new FileInputStream(LOGPATH))).lines().anyMatch((line) -> line.contains(MESSAGE)));
    }
}