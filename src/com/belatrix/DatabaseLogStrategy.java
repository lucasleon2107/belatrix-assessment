package com.belatrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseLogStrategy implements LogStrategy {
    private static final Logger logger = Logger.getLogger("Database Logger");

    private String user;
    private String password;
    private String serverName;
    private String portNumber;
    private String dbms;
    private String sqlStatement;

    public DatabaseLogStrategy(String user, String password, String serverName, String portNumber, String dbms, String sqlStatement) {
        this.user = user;
        this.password = password;
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.dbms = dbms;
        this.sqlStatement = sqlStatement;
    }

    @Override
    public void log(String messageText, Level level) throws SQLException {
        Connection connection;

        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);

        try {
            connection = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + connectionProps);

            Statement statement = connection.createStatement();

            statement.execute(sqlStatement);

            logger.log(level, messageText);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw e;
        }
    }
}
