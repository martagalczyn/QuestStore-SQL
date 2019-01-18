package com.codecool.DAO;

import java.sql.*;

class Postgres {

    ConnectionPool connectionPool = createConnectionPool();

    private ConnectionPool createConnectionPool() {
        final String USERNAME = "crabvendor";
        final String PASSWORD = "Staszek1";
        final String DB_URL = "jdbc:postgresql://localhost:5432/applicationProcess";
        ConnectionPool connectionPool = null;
        try {
            connectionPool = PostgreSQLConnectionPool.create(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connectionPool;
    }
}
