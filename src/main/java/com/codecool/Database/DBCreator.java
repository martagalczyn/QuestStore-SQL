package com.codecool.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class DBCreator {

    private Connection connection = null;
    private PreparedStatement statement = null;

    void connectToDatabase() throws SQLException {
        String database = "jdbc:postgresql://localhost:5432/applicationProcess";
        String user = "crabvendor";
        String password = "Staszek1";
        connection = DriverManager.getConnection(database, user, password);
        System.out.println("Opened database successfully");
    }

    private String readStatement(String filename) {
        StringBuilder out = new StringBuilder();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                out.append(sc.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    void executeStatement() throws SQLException {
        statement = connection.prepareStatement(readStatement("/home/crabvendor/Code/Web/SQL/QuestStoreSQL/QuestStore-SQL/src/main/java/com/codecool/Database/allqueries.sql"));
        statement.execute();
        System.out.println("DB created");
    }

    void closeConnection() throws SQLException {
        connection.close();
    }
}