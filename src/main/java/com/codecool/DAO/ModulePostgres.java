package com.codecool.DAO;

public class ModulePostgres {
    String listOfModulesQuery = "SELECT name "+
            "FROM modules;";

    String name;

    String addNewStudentQuery = "INSERT INTO modules(name) "+
            "VALUES(" + name + ")";

    String deleteModuleQuery = "DELETE FROM modules " +
            "WHERE name LIKE" + name +";";
}
