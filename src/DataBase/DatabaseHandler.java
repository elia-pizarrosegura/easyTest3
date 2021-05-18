package DataBase;

import Data.LogInClass;
import Data.MotoVersion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<MotoVersion> getMotoVersionData() throws SQLException, ClassNotFoundException {
        List<MotoVersion> list= new ArrayList<>();
        String query="SELECT * FROM easyTest.MotoVersion";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("Marca"));
            MotoVersion m =new MotoVersion(resultSet.getString("Marca"),
                    resultSet.getString("Cilindrada"),
                    resultSet.getString("Modelo"),
                    resultSet.getString("Version"),
                    resultSet.getString("Anyo"));
            list.add(m);
        }
        System.out.println("Se han extraido los datos para la tabla Moto Versiones.");
        return list;
    }

    public List<MotoVersion> getMotoVersionDataFilterBy(String filtro, String value) throws SQLException, ClassNotFoundException {
        List<MotoVersion> list= new ArrayList<>();
        String query=String.format("SELECT * FROM easyTest.MotoVersion WHERE %s='%s'",filtro,value);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("Marca"));
            MotoVersion m =new MotoVersion(resultSet.getString("Marca"),
                    resultSet.getString("Cilindrada"),
                    resultSet.getString("Modelo"),
                    resultSet.getString("Version"),
                    resultSet.getString("Anyo"));
            list.add(m);
        }
        System.out.println("Se han extraido los datos para la tabla Moto Versiones filtradas por la columna: "
                + filtro + "y valor: "+value);
        return list;
    }

    public List<String> getCilindradaList(String marca) throws SQLException, ClassNotFoundException {
        List<String> tiposCilindrada = null;
        String query=String.format("SELECT distinct Cilindrada FROM easyTest.MotoVersion where Marca='%s'",marca);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            tiposCilindrada.add(resultSet.getString("Cilindrada"));
        }
        return tiposCilindrada;
    }
}
