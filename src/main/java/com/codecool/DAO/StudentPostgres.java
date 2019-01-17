package com.codecool.DAO;

import com.codecool.Models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentPostgres extends Postgres implements StudentDAO {

    List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM students;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet studentsResultSet = preparedStatement.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return students;
    }
}
