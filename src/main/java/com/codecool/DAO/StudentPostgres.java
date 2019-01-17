package com.codecool.DAO;


import com.codecool.Models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentPostgres extends Postgres implements StudentDAO {

    String listOfStudentsQuery = "SELECT first_name, last_name, email, phone_number, adress, module_id " +
            "FROM students;";

    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String adress;
    String moduleId;

    String addNewStudentQuery = "INSERT INTO students(first_name, last_name, email, phone_number, adress, module_id) " +
            "VALUES(" + firstName + lastName + email + phoneNumber + adress + moduleId + ")";

    String deleteStudentQuery = "DELETE FROM students " +
            "WHERE last_name LIKE" + lastName + ";";

    String searchSTudentQuery = "SELECT first_name, last_name, email, phone_number, adress, module_id FROM mentors " +
            "FROM students WHERE last_name LIKE " + lastName + ";";

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
