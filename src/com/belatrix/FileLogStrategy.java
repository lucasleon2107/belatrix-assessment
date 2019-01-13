package com.belatrix;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogStrategy implements LogStrategy {
    private static final Logger logger = Logger.getLogger("File Logger");

    private String path;

    public FileLogStrategy(String path) {
        this.path = path;
    }

    @Override
    public void log(String messageText, Level level) throws IOException {
        try {
            File logFile = new File(path);

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileHandler fileHandler = new FileHandler(this.path);
            logger.addHandler(fileHandler);
            logger.log(level, messageText);

        } catch (IOException e) {
            logger.severe(e.getMessage());
            throw e;
        }
    }
}
