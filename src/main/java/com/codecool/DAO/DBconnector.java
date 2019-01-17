package com.codecool.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class DBconnector {

    private Connection connection = null;
    private PreparedStatement statement = null;

    public void connectToDatabase() throws SQLException {
        String database = "jdbc:postgresql://localhost:5432/applicationProcess";
        String user = "hp";
        String password = "dupa";
        connection = DriverManager.getConnection(database, user, password);
        System.out.println("Opened database successfully");
    }

    private  String readStatement(String filename) {
        StringBuilder out = new StringBuilder();


        try {

            Scanner sc=new Scanner(new File(filename));
            while(sc.hasNextLine()){
                out.append(sc.nextLine());
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return out.toString();
    }




    public void executeStatement() throws SQLException {
        statement = connection.prepareStatement(readStatement("/home/hp/codecool/aWebModule/QuestStore-SQL/src/main/java/com/codecool/DAO/allqueries.sql"));
        statement.execute();
        System.out.println("DB created");
    }
}