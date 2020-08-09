package com.haulmont.testtask.data;

import com.haulmont.testtask.entities.Doctor;
import com.haulmont.testtask.entities.Priority;
import com.haulmont.testtask.entities.Recipe;
import com.haulmont.testtask.entities.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import static com.haulmont.testtask.data.SpecializationData.getSpecialization;

public class RecipeData extends Data{
    public static ArrayList<Recipe> getAllReciple(){
        ArrayList list = new ArrayList();
        String query = "select * from recipes";

        try(Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()){
                list.add(new Recipe(
                        rs.getLong("id"),
                        rs.getLong("patient"),
                        rs.getLong("doctor"),
                        rs.getDate("date_creating"),
                        rs.getDate("duration"),
                        getRecipePriority(rs.getInt("priority"))
                        ));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static boolean addRecipe(Recipe recipe){
        String query = "insert into recipes(patient, doctor,date_creating,duration,priority) values(?,?,?,?,?)";

        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1,recipe.getPatient());
            preparedStatement.setLong(2,recipe.getDoctor());
            preparedStatement.setDate(3,recipe.getDateCreacting());
            preparedStatement.setDate(4,recipe.getDuration());
            preparedStatement.setInt(5,recipe.getPriority().getNumber());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private static Priority getRecipePriority(int num){
        switch (num){
            case 1 :
                return Priority.NORMAL;
            case 2:
                return Priority.CITO;
            case 3:
                return Priority.STATIUM;
            default:
                return null;
        }
    }
}
