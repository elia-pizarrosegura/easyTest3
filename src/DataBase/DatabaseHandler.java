package DataBase;

import Data.LogInClass;

import java.sql.*;

public class DatabaseHandler extends Config {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("Conexión establecida");

        return dbConnection;
    }

    public LogInClass getLogInData(String userName) throws SQLException, ClassNotFoundException {
        LogInClass logIn= new LogInClass();
        String query = "SELECT * from LogIn where userName=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Usuario de la BBDD:" + resultSet.getString("userName"));
            System.out.println("Pass de la BBDD:" + resultSet.getString("password"));
            logIn.setUser(resultSet.getString("userName"));
            logIn.setPass("Pass de la BBDD: " + resultSet.getString("password"));

        }
        return logIn;

    }
}
