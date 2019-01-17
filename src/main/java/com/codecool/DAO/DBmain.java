package com.codecool.DAO;

import java.sql.SQLException;

public class DBmain {
    public static void main(String[] args) {
        try {
            DBconnector dBconnector = new DBconnector();
            dBconnector.connectToDatabase();
            dBconnector.executeStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
