package com.haulmont.testtask.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class Data {

    protected static Connection connection(){
        String url = "jdbc:sqlite:./src/main/resources/db.db";
        Connection connection=null;
        try{
            connection = DriverManager.getConnection(url);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static boolean updateValues(long id, Map params,String tableName){
        String query = "update ? set ?=? where ?";
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            params.forEach((key,value) -> {
                try {
                    preparedStatement.setString(1,tableName);
                    preparedStatement.setString(2, String.valueOf(key));
                    preparedStatement.setString(3, String.valueOf(value));
                    preparedStatement.setLong(4,id);
                    preparedStatement.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean deletePatient(long id,String tableName){
        String query = "delete from ? where id=?";

        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1,tableName);
            preparedStatement.setLong(2,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
