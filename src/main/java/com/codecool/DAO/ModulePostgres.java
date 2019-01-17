package com.codecool.DAO;

import com.codecool.Models.Module;
import com.codecool.Models.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModulePostgres extends Postgres implements ModuleDAO {
    String listOfModulesQuery = "SELECT name "+
            "FROM modules;";

    String name;

    String addNewModuleQuery = "INSERT INTO modules(name) "+
            "VALUES(" + name + ")";

    String deleteModuleQuery = "DELETE FROM modules " +
            "WHERE name LIKE" + name +";";

    public List<Module> getAllModules() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM modules;";
        ResultSet modulesResultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            modulesResultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return getModulesFromResultSet(modulesResultSet);
    }


    private List<Module> getModulesFromResultSet(ResultSet resultSet) {
        List<Module> modules = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(resultSet.findColumn("id"));
                    String name = resultSet.getString(resultSet.findColumn("name"));
                    modules.add(new Module(id, name));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return modules;
    }
}
