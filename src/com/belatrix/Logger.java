package com.belatrix;

import java.util.logging.Level;

public class Logger {
    public static void log(LogStrategy logStrategy, String message, Level level) throws Exception {
        logStrategy.log(message, level);
    }
}
