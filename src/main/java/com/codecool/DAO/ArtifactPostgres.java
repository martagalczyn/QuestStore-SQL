package com.codecool.DAO;

public class ArtifactPostgres {

    String listOfArtifactsQuery = "SELECT name, price, description, image "+
            "FROM artifacts;";

    String name;
    String price;
    String description;
    String image;

    String addNewArtifactQuery = "INSERT INTO artifacts(name, price, description, image) "+
            "VALUES(" + name + price + description + image + ")";

    String deleteArtifactQuery = "DELETE FROM artifacts " +
            "WHERE name LIKE" + name + ";";

}
