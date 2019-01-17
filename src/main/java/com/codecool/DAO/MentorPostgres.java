package com.codecool.DAO;


import com.codecool.Models.Mentor;
import com.codecool.Models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorPostgres extends Postgres implements MentorDAO {

    String listOfMentorsQuery = "SELECT first_name, last_name, email, phone_number, adress, module_id "+
            "FROM mentors;";
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String adress;
    String moduleId;

    String addNewMentorQuery = "INSERT INTO mentors(first_name, last_name, email, phone_number, adress, module_id) "+
    "VALUES(" + firstName + lastName + email + phoneNumber + adress + moduleId + ")";

    String deleteMentorQuery = "DELETE FROM mentors " +
            "WHERE last_name LIKE " + lastName + ";";

    String searchMentorQuery = "SELECT first_name, last_name, email, phone_number, adress, module_id FROM mentors "+
            "FROM mentors WHERE last_name LIKE " + lastName + ";";


    public List<Mentor> getAllMentors() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM mentors;";
        ResultSet mentorResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            mentorResultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getMentorsFromResultSet(mentorResultSet);
    }


    private List<Mentor> getMentorsFromResultSet(ResultSet resultSet) {
        List<Mentor> mentors = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(resultSet.findColumn("id"));
                    String firstName = resultSet.getString(resultSet.findColumn("first_name"));
                    String lastName = resultSet.getString(resultSet.findColumn("last_name"));
                    String email = resultSet.getString(resultSet.findColumn("email"));
                    String phoneNumber = resultSet.getString(resultSet.findColumn("phone_number"));
                    String adress = resultSet.getString(resultSet.findColumn("adress"));
                    int moduleId = resultSet.getInt(resultSet.findColumn("module_id"));
                    mentors.add(new Mentor(id, firstName, lastName, email, phoneNumber, adress, moduleId));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

}

