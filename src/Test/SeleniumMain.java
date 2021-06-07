package Test;

import DataBase.DatabaseHandler;
import Model.DataTestObject;
import Model.FicheroTxt;
import Test.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.sql.SQLException;


public class SeleniumMain {

   public SeleniumMain() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
      initFirefoxDriver();
   }

   public static void initFirefoxDriver() throws SQLException, ClassNotFoundException, IOException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/Users/pizarroelia/Documents/Drivers/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        FirefoxOptions options = new FirefoxOptions(capabilities);
        options.setAcceptInsecureCerts(false);


        WebDriver driver = new FirefoxDriver(options);

        String baseURL = "http://10.231.57.202/";
        driver.get(baseURL);
        new FicheroTxt().borrarFichero();

        Steps steps = new Steps(driver);

        //Obtener datos para el test
        int ultimaInsercionDataTestObject = new DatabaseHandler().consultaIndiceDataTestObject();
        DataTestObject objectData = new DatabaseHandler().obtenerDatosTestObject(ultimaInsercionDataTestObject);

        //Iniciar test
        steps.stepSeleccionarProducto(objectData.getProducto());
        steps.seleccionarCamino(objectData);
        steps.seleccionarPasosGenerales(objectData);


    }
}





