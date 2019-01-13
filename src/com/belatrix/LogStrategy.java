package com.belatrix;

import java.util.logging.Level;

public interface LogStrategy {
    void log(String messageText, Level level) throws Exception;
}
