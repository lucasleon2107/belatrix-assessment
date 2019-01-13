package com.belatrix;

import org.junit.Test;

import java.util.logging.Level;

public class ConsoleLogStrategyTest {

    @Test
    public void log() {
        ConsoleLogStrategy consoleLogStrategy = new ConsoleLogStrategy();
        consoleLogStrategy.log("test", Level.INFO);
    }
}