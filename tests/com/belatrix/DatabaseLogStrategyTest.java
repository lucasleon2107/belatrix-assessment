package com.belatrix;

import org.junit.Test;

import java.sql.SQLException;
import java.util.logging.Level;

public class DatabaseLogStrategyTest {

    @Test(expected = SQLException.class)
    public void log() throws SQLException {
        DatabaseLogStrategy databaseLogStrategy = new DatabaseLogStrategy("test", "test", "test", "test", "test", "test");
        databaseLogStrategy.log("test", Level.INFO);
    }
}