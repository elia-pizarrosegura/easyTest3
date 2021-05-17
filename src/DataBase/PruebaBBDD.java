package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaBBDD {

   static private DatabaseHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dbHandler= new DatabaseHandler();
        connection= dbHandler.getDbConnection();
     //   writeTODB();
     //   readFromDB();
       // updateLogInDB("maria","maria");
       // readFromDB();
        deleteUser(3);


    }

    public static void writeTODB() throws SQLException{
        String insert= "INSERT INTO LogIn(userName,password) VALUES (?,?)";

        preparedStatement= connection.prepareStatement(insert);
        preparedStatement.setString(1,"yo");
        preparedStatement.setString(2,"yo");
        preparedStatement.executeUpdate();
    }

    public static void readFromDB() throws SQLException {
        String query = "SELECT * from LogIn";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Usuario: " + resultSet.getString("userName"));
            System.out.println("Pass: " + resultSet.getString("password"));

        }
    }

    public static void updateLogInDB(String user, String pass) throws SQLException {
        String query= "UPDATE LogIn SET userName=?, password=? where userName=?";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);
        preparedStatement.setString(3,"elia");
        preparedStatement.executeUpdate();
        preparedStatement.close();
        }

     public static void deleteUser(int id) throws SQLException {
        String query= "DELETE from LogIn where idUser=?";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        preparedStatement.close();
     }
    }


