package com.haulmont.testtask.data;

import com.haulmont.testtask.entities.Doctor;
import com.haulmont.testtask.entities.Specialization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecializationData extends Data{
    public static Specialization getSpecialization(long id){
        String query = "select * from where id=?";
        try(Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            Specialization specialization = new Specialization(
                    rs.getLong("id"),
                    rs.getString("title"));
            return specialization;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
