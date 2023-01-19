package model.dao;

import model.entities.Others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OthersDao {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private void tryConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/projectoop?" + "user=root&password=");

        } catch (Exception e) {
            close();
            e.printStackTrace();
            throw e;
        }
    }
    public ArrayList<Others> getOthers() throws Exception{
        try{
            tryConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from projectoop.others");
            ArrayList<Others> others = new ArrayList<Others>();
            while(resultSet.next()) {
                others.add(new Others(resultSet.getString("description"), resultSet.getString("title"),
                        resultSet.getInt("price"), resultSet.getString("category"), resultSet.getString("owner"), resultSet.getInt("id")));
            }
            close();
            return others;
        } catch(Exception e){
            close();
            e.printStackTrace();
            throw e;
        }
    }
    public void insertOthers(Others c) throws Exception{
        try {
            tryConnection();
            preparedStatement = connect.prepareStatement("insert into projectoop.others(description, title, price, category, owner)" +
                    " values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, c.getDescription());
            preparedStatement.setString(2, c.getTitle());
            preparedStatement.setString(3, c.getPrice() + "");
            preparedStatement.setString(4, c.getCategory());
            preparedStatement.setString(5, c.getOwner());
            preparedStatement.executeUpdate();
            close();
        } catch(Exception e){
            close();
            e.printStackTrace();
            throw e;
        }
    }
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    public void deleteOthers(int id) throws Exception{
        try {
            tryConnection();
            preparedStatement = connect.prepareStatement("delete from projectoop.others where id = ?");
            preparedStatement.setString(1, id + "");

            preparedStatement.executeUpdate();
            close();
        } catch (Exception e) {
            close();
            e.printStackTrace();
            throw e;
        }
    }
}
