package com.haulmont.testtask.data;

import com.haulmont.testtask.entities.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatientData extends Data{

    public static ArrayList getAllPatietns(){
        ArrayList<Patient> list = new ArrayList();
        String query = "select * from patients";
        try(Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()){
                list.add(new Patient(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("second_name"),
                        rs.getInt("phone")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean addPatient(Patient patient){
        String query = "insert into patients(name, surname,second_name,phone) values(?,?,?,?)";

        try(Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,patient.getName());
            preparedStatement.setString(2,patient.getSurname());
            preparedStatement.setString(3,patient.getSecondName());
            preparedStatement.setInt(4,patient.getPhone());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
