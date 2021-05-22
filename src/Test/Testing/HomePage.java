package Test.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void seleccionarProducto(String producto) {
        System.out.println("Seleccion de producto");
        new Helper(driver).handleCookieComplianceDialog();
        By selector = null;
        switch(producto) {
            case ("Coche"):
                selector = By.cssSelector("a[title='Calcular seguro Coche']");
                break;
            case ("Hogar"):
                selector = By.cssSelector("a[title='Calcular seguro Hogar']");
                break;
            case ("Moto"):
                selector = By.cssSelector("a[title='Calcular seguro Moto']");
                break;
            case ("Mascota"):
                selector = By.cssSelector("a[title='Calcular seguro Mascota']");
                break;
            case ("CuentaKm"):
                selector = By.cssSelector("a[title='Calcular seguro CuentaKms']");
                break;
            default:
                System.out.println("No se ha seleccionado ningun producto");

        }

        driver.findElement(selector).click();
        System.out.println("Se ha seleccionado el producto " + producto);
    }


}
