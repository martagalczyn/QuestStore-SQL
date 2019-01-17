package com.codecool.DAO;

public class QuestPostgres {

    String listOfQuestsQuery = "SELECT name, price, description, image " +
            "FROM quests;";

    String name;
    String price;
    String description;
    String image;

    String addNewStudentQuery = "INSERT INTO quests(name, price, description, image) " +
            "VALUES(" + name + price + description + image + ")";

    String deleteQuestQuery = "DELETE FROM quests " +
            "WHERE name LIKE" + name + ";";
}
