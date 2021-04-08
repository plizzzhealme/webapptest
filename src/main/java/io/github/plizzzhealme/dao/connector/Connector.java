package io.github.plizzzhealme.dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/social_poll";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connector() {
    }

    public static Connector getInstance() {
        return ConnectorHolder.INSTANCE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static class ConnectorHolder {
        private static final Connector INSTANCE = new Connector();
    }

}
