package com.codecool.DAO;

public class StudentPostgres {

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

    String searchSTudentQuery = "SELECT first_name, last_name, email, phone_number, adress, module_id FROM mentors "+
            "FROM students WHERE last_name LIKE " + lastName + ";";
}
