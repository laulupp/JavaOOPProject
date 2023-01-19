package model.dao;

import model.entities.Car;
import model.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarsDao {
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
    public ArrayList<Car> getCars() throws Exception{
        try{
            tryConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from projectoop.cars");
            ArrayList<Car> cars = new ArrayList<Car>();
            while(resultSet.next()){
                cars.add(new Car(resultSet.getString("description"), resultSet.getString("title"), resultSet.getInt("price"),
                                 resultSet.getString("model"), resultSet.getInt("power"),
                                 resultSet.getInt("enginecapacity"), resultSet.getInt("year"), resultSet.getString("owner"), resultSet.getInt("id")));
            }
            close();
            return cars;
        } catch(Exception e){
            close();
            e.printStackTrace();
            throw e;
        }
    }
    public void insertCar(Car c) throws Exception{
        try {
            tryConnection();
            preparedStatement = connect.prepareStatement("insert into projectoop.cars(description, title, price, model, power, enginecapacity, year, owner)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, c.getDescription());
            preparedStatement.setString(2, c.getTitle());
            preparedStatement.setString(3, c.getPrice() + "");
            preparedStatement.setString(4, c.getModel());
            preparedStatement.setString(5, c.getPower() + "");
            preparedStatement.setString(6, c.getEngineCapacity() + "");
            preparedStatement.setString(7, c.getYear() + "");
            preparedStatement.setString(8, User.getUsername());
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

    public void deleteCar(int id)  throws Exception {
        try {
            tryConnection();
            preparedStatement = connect.prepareStatement("delete from projectoop.cars where id = ?");
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
