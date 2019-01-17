package com.codecool.DAO;

public class MentorPostgres {

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
}

