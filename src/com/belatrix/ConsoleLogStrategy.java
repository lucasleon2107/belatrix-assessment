package com.belatrix;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogStrategy implements LogStrategy{
    private static final Logger logger = Logger.getLogger("Console Logger");

    @Override
    public void log(String messageText, Level level) {
        logger.log(level, messageText);
    }
}
