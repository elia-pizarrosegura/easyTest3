package DataBase;

import Model.DataTestObject;
import Model.LogInClass;
import Model.MotoVersion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        LogInClass logIn = new LogInClass();
        String query = "SELECT * from LogIn where userName=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Usuario de la BBDD:" + resultSet.getString("userName"));
            System.out.println("Pass de la BBDD:" + resultSet.getString("password"));
            logIn.setUser(resultSet.getString("userName"));
            logIn.setPass("Pass de la BBDD: " + resultSet.getString("password"));

        }
        return logIn;
    }

    public int consultaIndiceDataTestObject() throws SQLException, ClassNotFoundException {
        String query = "SELECT MAX(id_producto) FROM easyTest.DataTestObject;";
        PreparedStatement preparedStatement1 = getDbConnection().prepareStatement(query);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        int linea = 0;
        while (resultSet1.next()) {
            linea = resultSet1.getInt("MAX(id_producto)");
            System.out.println(linea);

        }
        return linea;
    }

    public void insertProductMatricula(int nuevaInsercion, String producto, Boolean matricula) throws SQLException, ClassNotFoundException {
        nuevaInsercion++;
        String query = String.format("INSERT INTO easyTest.DataTestObject(id_producto,producto,matricula) VALUES(%s,'%s',%s)", nuevaInsercion, producto, matricula);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.executeUpdate();
        System.out.println("Se ha realizado la inserción de Producto y Matricula en línea: " + nuevaInsercion);
    }

    public void insertfechaMatricToAnyo(int lieaInsercion, LocalDate fechaMatriculacion, String marca, String cilindrada, String modelo, String version, String anyo) throws SQLException, ClassNotFoundException {
        String query = String.format("UPDATE easyTest.DataTestObject SET fechaMatriculacion='%s',marca='%s',cilindrada='%s',modelo='%s',version='%s',anyo='%s' WHERE id_producto='%s'",
                fechaMatriculacion, marca, cilindrada, modelo, version, anyo, lieaInsercion);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.executeUpdate();
        System.out.println("Se ha realizado la inserción en línea: " + lieaInsercion + " de los siguientes valores:v" +
                "fecha de Matriculacion:"+ fechaMatriculacion + " marca:"+ marca +" cilindrada:"+ cilindrada + " modelo: "+ modelo+
                " version:"+ version + " año"+ anyo);

    }

    public void insertarDatosGenerales(int lineaInserción,String momentoCompra, String leHago, String duerme,String usoHabitual, String situacionPersonal, String situacionProfesional,
                                       String sexo, String carne, Boolean seguroAnterior, Boolean otroConductor, LocalDate fechaInicio, LocalDate fechacarne, LocalDate fechaNacimiento) throws SQLException, ClassNotFoundException {

        String query= String.format("UPDATE easyTest.DataTestObject SET "+
                "momentoCompra = '%s',leHago = '%s',duerme = '%s',usoHabitual = '%s',situacionPersonal='%s',situacionProfesional = '%s',carne = '%s',sexo='%s',seguroAnterior=%s,\n" +
                "otroConductor = %s,fechaInicio = '%s',fechaCarne = '%s',edadConductor = '%s'WHERE id_producto='%s'",
                momentoCompra,leHago,duerme,usoHabitual,situacionPersonal,situacionProfesional,sexo,carne,seguroAnterior,otroConductor,fechaInicio,fechacarne,fechaNacimiento,lineaInserción);

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.executeUpdate();

        System.out.println("Se ha realizado la inserción en línea "+ lineaInserción+ "de los siguientes datos: "+
                "momento de la compra:"+momentoCompra+" al año le hago:"+leHago+ " duerme en:"+duerme+ " usoHabitual:"+usoHabitual+
                " situacion Personal:"+ situacionPersonal+ " situacion Profesional:" +situacionProfesional+ " sexo: "+sexo+ " tipo Carne"+ carne+
                " seguro anterior" +seguroAnterior + " otros conductores"+ otroConductor+ " fecha Inicio seguro: "+ fechaInicio+
                " fecha de carne:"+ fechacarne+" fecha de nacimiento:"+fechaNacimiento);
    }

    public DataTestObject obtenerDatosTestObject(int lineaInserción) throws SQLException, ClassNotFoundException {

        String query= String.format("SELECT *  FROM easyTest.DataTestObject WHERE id_producto=%s",lineaInserción);
        DataTestObject object= new DataTestObject();

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()) {
            object.setProducto(resultSet1.getString("producto"));
            object.setMatricula(resultSet1.getBoolean("matricula"));
            object.setFechaMatriculacion(LocalDate.parse(resultSet1.getString("fechaMatriculacion")));
            object.setMarca(resultSet1.getString("marca"));
            object.setCilindrada(resultSet1.getString("cilindrada"));
            object.setModelo(resultSet1.getString("modelo"));
            object.setVersion(resultSet1.getString("version"));
            object.setAnyo(resultSet1.getString("anyo"));
            object.setMomentoCompra(resultSet1.getString("momentoCompra"));
            object.setLeHago(resultSet1.getString("leHago"));
            object.setDuerme(resultSet1.getString("duerme"));
            object.setUsoHabitual(resultSet1.getString("usoHabitual"));
            object.setSituacionPersonal(resultSet1.getString("situacionPersonal"));
            object.setSituacionProfesional(resultSet1.getString("situacionProfesional"));
            object.setSexo(resultSet1.getString("sexo"));
            object.setCarne(resultSet1.getString("carne"));
            object.setSeguroAnterior(resultSet1.getBoolean("seguroAnterior"));
            object.setOtroConductor(resultSet1.getBoolean("otroConductor"));
            object.setFechaInicio(LocalDate.parse(resultSet1.getString("fechaInicio")));
            object.setFechaCarne(LocalDate.parse(resultSet1.getString("fechaCarne")));
            object.setFechaNacimiento(LocalDate.parse(resultSet1.getString("edadConductor")));

        }

        return object;
    }


    public List<MotoVersion> getMotoVersionData() throws SQLException, ClassNotFoundException {
        List<MotoVersion> list = new ArrayList<>();
        String query = "SELECT * FROM easyTest.MotoVersion";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Marca"));
            MotoVersion m = new MotoVersion(resultSet.getString("Marca"),
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
        List<MotoVersion> list = new ArrayList<>();
        String query = String.format("SELECT * FROM easyTest.MotoVersion WHERE %s='%s'", filtro, value);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Marca"));
            MotoVersion m = new MotoVersion(resultSet.getString("Marca"),
                    resultSet.getString("Cilindrada"),
                    resultSet.getString("Modelo"),
                    resultSet.getString("Version"),
                    resultSet.getString("Anyo"));
            list.add(m);
        }
        System.out.println("Se han extraido los datos para la tabla Moto Versiones filtradas por la columna: "
                + filtro + "y valor: " + value);
        return list;
    }

    public List<String> getCilindradaList(String marca) throws SQLException, ClassNotFoundException {
        List<String> tiposCilindrada = null;
        String query = String.format("SELECT distinct Cilindrada FROM easyTest.MotoVersion where Marca='%s'", marca);
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            tiposCilindrada.add(resultSet.getString("Cilindrada"));
        }
        return tiposCilindrada;
    }
}
