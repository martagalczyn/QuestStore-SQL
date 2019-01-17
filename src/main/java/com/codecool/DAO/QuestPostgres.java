package com.codecool.DAO;


import com.codecool.Models.Artifact;
import com.codecool.Models.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestPostgres extends Postgres implements QuestDAO {

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

    public List<Quest> getAllQuests() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM quests;";
        ResultSet questsResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            questsResultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getQuestsFromResultSet(questsResultSet);
    }


    private List<Quest> getQuestsFromResultSet(ResultSet resultSet) {
        List<Quest> quests = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(resultSet.findColumn("id"));
                    String name = resultSet.getString(resultSet.findColumn("name"));
                    int price = resultSet.getInt(resultSet.findColumn("price"));
                    String description = resultSet.getString(resultSet.findColumn("description"));
                    String image = resultSet.getString(resultSet.findColumn("image"));
                    quests.add(new Quest(id, name, price, description, image));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return quests;
    }
}
