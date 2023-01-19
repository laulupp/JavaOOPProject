package model.dao;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
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

    public boolean userExists(String username) throws Exception {
        try{
            tryConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) from projectoop.users where username = '" + username + "'");
            resultSet.next();


            if(resultSet.getInt("COUNT(*)") != 0){
                close();
                return true;
            }
            close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            close();
        }
    }
    public String getHashedPassword(String username) throws Exception {
        try{
            tryConnection();
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("select password from projectoop.users where  username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String result = resultSet.getString("password");
            close();
            return result;
        } catch (Exception e) {
            throw e;
        }
        finally {
            close();
        }
    }
    public String hashPassword(String password){
        return getMd5(password);
    }
    public void createUser(String username, String password) throws Exception{
        try{
            tryConnection();
            preparedStatement = connect.prepareStatement("insert into projectoop.users (username, password) values (?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            close();
        } catch(Exception e) {
            e.printStackTrace();

            throw e;
        }
    }
    private static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public int getLevel(String username) throws Exception {
        try {
            tryConnection();
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("select level from projectoop.users where  username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int result = resultSet.getInt("level");
            close();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
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


}
