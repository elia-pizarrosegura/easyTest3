package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.SeleniumMain;
import test.Testing.*;

import java.util.ArrayList;
import java.util.List;

public class Steps{
    WebDriver driver;
    String producto;



    public Steps(WebDriver driver){
       this.driver=driver;
    }

    public void stepSeleccionarProducto(String producto){
        new HomePage(driver).seleccionarProducto(producto);
    }

    public List<String> seleccionarCamino(String producto){
        List<String> listaPasos= new Helper(driver).listarPasosPorProductos(producto);
        return listaPasos;
    }

    public void stepSeleccionarOpcionMatricula(String opcion) throws InterruptedException {
        new SectionMiMoto(driver).introducirMatricula(opcion);

    }



}
