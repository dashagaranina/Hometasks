package ru.kpfu.itis.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String driverClassName = "org.postgresql.Driver";
   private final String connectionUrl = "jdbc:postgresql://localhost:5432/messages";
   private final String dbUser = "postgres";
   private final String dbPwd = "qwerty";
//    private final String connectionUrl = "jdbc:postgresql://localhost:5432/garanina_sb";
//    private final String dbUser = "practice";
//    private final String dbPwd = "123";


    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}