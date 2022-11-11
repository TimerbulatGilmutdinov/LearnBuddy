package ru.kpfu.itis.semestrproject.utils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class SimpleDataSource implements DataSource {

    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            openConnection();
        }
        return connection;
    }

    private void openConnection() {
        Properties properties = new Properties();
        try {
            properties.load(SimpleDataSource.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        try{
            Class.forName(properties.getProperty("db.driver"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.username"), properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new IllegalArgumentException();
    }
}