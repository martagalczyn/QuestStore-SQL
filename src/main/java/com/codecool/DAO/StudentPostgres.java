package com.codecool.DAO;

import com.codecool.Models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentPostgres extends Postgres implements StudentDAO {

    @Override
    public List<Student> getAllStudents() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM students;";
        ResultSet studentResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            studentResultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getStudentsFromResultSet(studentResultSet);
    }

    @Override
    public void insertStudent(Student student) {

        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO students (first_name, last_name, email, phone_number, adress, module_id)" +
                       "VALUES(?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getAdress());
            preparedStatement.setInt(6, student.getModuleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    public void removeStudent(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM students " +
                       "WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private List<Student> getStudentsFromResultSet(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
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
                    students.add(new Student(id, firstName, lastName, email, phoneNumber, adress, moduleId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
