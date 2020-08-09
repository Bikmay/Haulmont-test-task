package com.haulmont.testtask.data;

import com.haulmont.testtask.entities.Doctor;
import com.haulmont.testtask.entities.Patient;
import com.haulmont.testtask.entities.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import static com.haulmont.testtask.data.SpecializationData.getSpecialization;

public class DoctorData extends Data{

    public static ArrayList getAllDoctors(){
        ArrayList list = new ArrayList();
        String query = "select * from doctors";

        try(Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            Specialization specialization;
            while (rs.next()){
                list.add(new Doctor(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("second_name"),
                        getSpecialization(rs.getLong("specialization"))));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    public static boolean addPatient(Doctor doctor){
        String query = "insert into doctors(name, surname,second_name,specialization) values(?,?,?,?)";

        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.setString(2,doctor.getSurname());
            preparedStatement.setString(3,doctor.getSecondName());
            preparedStatement.setLong(4,doctor.getSpecialization().getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
