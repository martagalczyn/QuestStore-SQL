package com.codecool.DAO;


import com.codecool.Models.Admin;
import com.codecool.Models.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtifactPostgres extends Postgres implements ArtifactDAO {

    String listOfArtifactsQuery = "SELECT name, price, description, image " +
            "FROM artifacts;";

    String name;
    String price;
    String description;
    String image;

    String addNewArtifactQuery = "INSERT INTO artifacts(name, price, description, image) " +
            "VALUES(" + name + price + description + image + ")";

    String deleteArtifactQuery = "DELETE FROM artifacts " +
            "WHERE name LIKE" + name + ";";

    public List<Artifact> getAllArtifacts() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM artifacts;";
        ResultSet artifactResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            artifactResultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getArtifactsFromResultSet(artifactResultSet);
    }


    private List<Artifact> getArtifactsFromResultSet(ResultSet resultSet) {
        List<Artifact> artifacts = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(resultSet.findColumn("id"));
                    String name = resultSet.getString(resultSet.findColumn("name"));
                    int price = resultSet.getInt(resultSet.findColumn("price"));
                    String description = resultSet.getString(resultSet.findColumn("description"));
                    String image = resultSet.getString(resultSet.findColumn("image"));
                    artifacts.add(new Artifact(id, name, price, description, image));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return artifacts;
    }

}
