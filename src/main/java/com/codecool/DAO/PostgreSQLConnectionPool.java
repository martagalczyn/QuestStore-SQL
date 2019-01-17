package com.codecool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLConnectionPool implements ConnectionPool {

    final private String USERNAME;
    final private String PASSWORD;
    final private String DB_URL;
    final private static int INITIAL_POOL_SIZE = 10;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private PostgreSQLConnectionPool(String user, String password, String url, List<Connection> connectionPool) {
        this.connectionPool = connectionPool;
        this.USERNAME = user;
        this.PASSWORD = password;
        this.DB_URL = url;
    }

    static PostgreSQLConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i=0; i<INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new PostgreSQLConnectionPool(user, password, url, pool);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getUrl() {
        return DB_URL;
    }

    @Override
    public String getUser() {
        return USERNAME;
    }

}
