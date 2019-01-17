package com.codecool.DAO;

import com.codecool.Models.Admin;
import com.codecool.Models.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminPostgres extends Postgres implements AdminDAO {

    public List<Admin> getAllAdmins() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM admins;";
        ResultSet adminResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            adminResultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getAdminsFromResultSet(adminResultSet);
    }


    private List<Admin> getAdminsFromResultSet(ResultSet resultSet) {
        List<Admin> admins = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(resultSet.findColumn("id"));
                    String firstName = resultSet.getString(resultSet.findColumn("first_name"));
                    String lastName = resultSet.getString(resultSet.findColumn("last_name"));
                    String email = resultSet.getString(resultSet.findColumn("email"));
                    String phoneNumber = resultSet.getString(resultSet.findColumn("phone_number"));
                    String adress = resultSet.getString(resultSet.findColumn("adress"));
                    admins.add(new Admin(id, firstName, lastName, email, phoneNumber, adress));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
}
