package com.belatrix;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.Level;

public class FileLogStrategyTest {

    @Test(expected = IOException.class)
    public void log() throws IOException {
        FileLogStrategy fileLogStrategy = new FileLogStrategy("");
        fileLogStrategy.log("test", Level.INFO);
    }
}