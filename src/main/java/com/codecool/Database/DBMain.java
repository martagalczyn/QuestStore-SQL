package com.codecool.Database;

import java.sql.SQLException;

public class DBMain {
    public static void main(String[] args) {
        try {
            DBCreator dBconnector = new DBCreator();
            dBconnector.connectToDatabase();
            dBconnector.executeStatement();
            dBconnector.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
