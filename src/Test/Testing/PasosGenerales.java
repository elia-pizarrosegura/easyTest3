package Test.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

public class PasosGenerales {

    WebDriver driver;
    private String selectorAOption="//a[contains(text(),'%s')]";
    private final By codigoPostalInput = By.cssSelector("#MO_CHAB_POSTAL");
    private final By saltarPreguntaDni= By.cssSelector("a[title='Saltar pregunta']");
    private final String birthDateDay = "#matriz_W_CHAB_DIADNACI";
    private final String birthDateMonth = "#matriz_W_CHAB_MESDNACI";
    private final String birthDateYear = "#matriz_W_CHAB_ANNDNACI";

    public PasosGenerales(WebDriver driver){
        this.driver=driver;
    }

    public PasosGenerales seleccionarMomentoCompra(String momentoCompra) throws InterruptedException {
        Thread.sleep(3000);
        switch (momentoCompra){
            case("no comprado"):
                driver.findElement(By.xpath(String.format(selectorAOption, " No he comprado aún "))).click();
                System.out.println("Se ha seleccionado la opción: no he comprado aún.");
                break;
            case("menos 3"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hace menos de 3 meses. "))).click();
                System.out.println("Se ha seleccionado la opción: hace menos de 3 meses");
                break;
            default:
                System.out.println("No se ha seleccionado ningún momento de la compra");
        }

        return this;
    }

    public PasosGenerales seleccionarKmAlAnyo(String leHago) throws InterruptedException {
        Thread.sleep(3000);
        switch (leHago){
            case("hasta 1000"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hasta 1.000 Kilómetros "))).click();
                System.out.println("Se ha seleccionado la opción: no he comprado aún.");
                break;
            case("hasta 2000"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hasta 2.000 Kilómetros "))).click();
                System.out.println("Se ha seleccionado la opción: hace menos de 3 meses");
                break;
            default:
                System.out.println("No se ha seleccionado ningún kilometraje al año");
        }
        return this;
    }

    public PasosGenerales seleccionarDondeDuerme(String duerme) throws InterruptedException {
        Thread.sleep(3000);
        switch (duerme){
            case("calle"):
                driver.findElement(By.xpath(String.format(selectorAOption, " En la calle "))).click();
                System.out.println("Se ha seleccionado la opción: duerme en la calle.");
                break;
            case("garaje"):
                driver.findElement(By.xpath(String.format(selectorAOption, " En garaje colectivo "))).click();
                System.out.println("Se ha seleccionado la opción: duerme en garaje");
                break;
            default:
                System.out.println("No se ha seleccionado lugar donde duerme el vehículo.");
        }
        return this;
    }

    public PasosGenerales seleccionarCP(String cp) throws InterruptedException {
        Thread.sleep(3000);
       driver.findElement(codigoPostalInput).sendKeys(cp);
        return this;
    }

    public PasosGenerales seleccionarUsoHabitual(String uso) throws InterruptedException {
        Thread.sleep(5000);
        switch (uso){
            case("fines"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Solo fines de semana "))).click();
                System.out.println("Se ha seleccionado la opción: uso solo fines.");
                break;
            case("diarioFines"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Diario y fines de semana "))).click();
                System.out.println("Se ha seleccionado la opción: uso fines y diario");
                break;
            default:
                System.out.println("No se ha seleccionado el uso del vehículo.");
        }
        return this;
    }

    public PasosGenerales seleccionarIdentificacion() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(saltarPreguntaDni).click();
        System.out.println("Se ha saltado la introducción de la identificación de usuario");
        return this;
    }

    public PasosGenerales rellenarSituacionPersonal(String situacionPersonal) throws InterruptedException {
        Thread.sleep(5000);
        switch (situacionPersonal){
            case("casado"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Casado/a "))).click();
                System.out.println("Se ha seleccionado la opción: casado.");
                break;
            case("parejaHecho"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Pareja de hecho "))).click();
                System.out.println("Se ha seleccionado la opción: pareja de hecho");
                break;
            default:
                System.out.println("No se ha seleccionado situacion personal.");
        }
        return this;
    }

    public PasosGenerales rellenarSituacionProfesional(String situacionProfesional) throws InterruptedException {
        Thread.sleep(5000);
        switch (situacionProfesional){
            case("administrativo"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Administrativo "))).click();
                System.out.println("Se ha seleccionado la opción: administrativo.");
                break;
            case("autonomo"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Autónomo "))).click();
                System.out.println("Se ha seleccionado la opción: autonomo");
                break;
            default:
                System.out.println("No se ha seleccionado situacion profesional.");
        }
        return this;
    }

    public void seleccionarFechaNacimiento(LocalDate date) throws InterruptedException {
        Thread.sleep(3000);

        final By dayElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateDay, date.getDayOfMonth()));
        driver.findElement(dayElement).click();
        final By monthElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateMonth, date.getMonth().getValue()));
        driver.findElement(monthElement).click();
        final By yearElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateYear, date.getYear()));
        Actions actions= new Actions(driver);
        WebElement year= driver.findElement(yearElement);
        actions.moveToElement(year);
        driver.findElement(yearElement).click();
        System.out.println("Fecha de nacimiento seleccionada:"+ date);

    }

    public PasosGenerales rellenarSexo(String sexo) throws InterruptedException {
        Thread.sleep(3000);
        switch (sexo){
            case("hombre"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hombre "))).click();
                System.out.println("Se ha seleccionado la opción: hombre.");
                break;
            case("mujer"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Mujer "))).click();
                System.out.println("Se ha seleccionado la opción: mujer");
                break;
            default:
                System.out.println("No se ha seleccionado ningún sexo.");
        }
        return this;
    }
}
