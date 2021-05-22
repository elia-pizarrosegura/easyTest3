package Test;

import DataBase.DatabaseHandler;
import Model.DataTestObject;
import Test.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.SQLException;


public class SeleniumMain {

  /*  public SeleniumMain() throws InterruptedException {
       initFirefoxDriver();
    }*/


    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
        //public static void initFirefoxDriver(){


        System.setProperty("webdriver.gecko.driver", "/Users/pizarroelia/Documents/Drivers/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        FirefoxOptions options = new FirefoxOptions(capabilities);
        options.setAcceptInsecureCerts(false);


        WebDriver driver = new FirefoxDriver(options);

        String baseURL = "http://10.231.57.202/";
        driver.get(baseURL);

        Steps steps = new Steps(driver);


        //Test

        //Inserción BBDD
        int ultimaInsercionDataTestObject= new DatabaseHandler().consultaIndiceDataTestObject();
        DataTestObject objectData= new DataTestObject();
        objectData= new DatabaseHandler().obtenerDatosTestObject(ultimaInsercionDataTestObject);
        System.out.println(objectData.getFechaMatriculacion());
        System.out.println(objectData.getMomentoCompra());
        System.out.println(objectData.getFechaCarne());
        System.out.println(objectData.getFechaInicio());
        System.out.println(objectData.getFechaNacimiento());


        steps.stepSeleccionarProducto("Moto");
      //  steps.seleccionarCamino("Moto", testDataObject);
       // steps.seleccionarPasosGenerales(testDataObject);


    }


}

