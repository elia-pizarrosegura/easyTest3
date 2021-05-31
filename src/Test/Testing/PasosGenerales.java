package Test.Testing;

import Model.FicheroTxt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.LocalDate;

public class PasosGenerales {

    WebDriver driver;
    Helper helper = new Helper(driver);
    private String selectorAOption = "//a[contains(text(),'%s')]";
    private final By codigoPostalInput = By.cssSelector("#MO_CHAB_POSTAL");
    private final By saltarPreguntaDni = By.cssSelector("a[title='Saltar pregunta']");
    private final String birthDateDay = "#matriz_W_CHAB_DIADNACI";
    private final String birthDateMonth = "#matriz_W_CHAB_MESDNACI";
    private final String birthDateYear = "#matriz_W_CHAB_ANNDNACI";
    private final String carneConducir = "#matriz_MO_CHAB_ANNLICEN";
    private final By inputTextEmail = By.cssSelector("#MO_TOMA_EMAIL");
    private final By inputTextPhone = By.cssSelector("div>input[id='MO_TOMA_TELEFONO1']");
    private final By buttonContinue = By.cssSelector("#siguiente");
    private final By politicaPrivacidad = By.cssSelector("#checkPrivacidad");
    private final By calendarToday = By.cssSelector(".ui-datepicker-today");
    private final By numeroPresupuestoTxt = By.cssSelector(".tu-presupuesto-valido");

    public PasosGenerales(WebDriver driver) {
        this.driver = driver;
    }

    public PasosGenerales seleccionarMomentoCompra(String momentoCompra) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (momentoCompra) {
            case ("no comprado"):
                driver.findElement(By.xpath(String.format(selectorAOption, " No he comprado aún "))).click();
                System.out.println("Se ha seleccionado la opción: no he comprado aún.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: no he comprado aún.",new FicheroTxt().lecturaFichero());
                break;
            case ("menos 3"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hace menos de 3 meses. "))).click();
                System.out.println("Se ha seleccionado la opción: hace menos de 3 meses");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: hace menos de 3 meses",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado ningún momento de la compra");
                new FicheroTxt().escrituraFichero("No se ha seleccionado ningún momento de la compra",new FicheroTxt().lecturaFichero());
        }

        return this;
    }

    public PasosGenerales seleccionarKmAlAnyo(String leHago) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (leHago) {
            case ("hasta 1000"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hasta 1.000 Kilómetros "))).click();
                System.out.println("Se ha seleccionado la opción: no he comprado aún.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: no he comprado aún.",new FicheroTxt().lecturaFichero());
                break;
            case ("hasta 2000"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hasta 2.000 Kilómetros "))).click();
                System.out.println("Se ha seleccionado la opción: hace menos de 3 meses");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: hace menos de 3 meses",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado ningún kilometraje al año");
                new FicheroTxt().escrituraFichero("No se ha seleccionado ningún kilometraje al año",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarDondeDuerme(String duerme) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (duerme) {
            case ("calle"):
                driver.findElement(By.xpath(String.format(selectorAOption, " En la calle "))).click();
                System.out.println("Se ha seleccionado la opción: duerme en la calle.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: duerme en la calle.",new FicheroTxt().lecturaFichero());
                break;
            case ("garaje"):
                driver.findElement(By.xpath(String.format(selectorAOption, " En garaje colectivo "))).click();
                System.out.println("Se ha seleccionado la opción: duerme en garaje");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: duerme en garaje",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado lugar donde duerme el vehículo.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado lugar donde duerme el vehículo.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarCP(String cp) throws InterruptedException {

        helper.waitSpinner();
        driver.findElement(codigoPostalInput).sendKeys(cp);
        return this;

    }

    public PasosGenerales seleccionarUsoHabitual(String uso) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (uso) {
            case ("fines"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Solo fines de semana "))).click();
                System.out.println("Se ha seleccionado la opción: uso solo fines.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: uso solo fines.",new FicheroTxt().lecturaFichero());
                break;
            case ("diarioFines"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Diario y fines de semana "))).click();
                System.out.println("Se ha seleccionado la opción: uso fines y diario");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: uso fines y diario",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado el uso del vehículo.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado el uso del vehículo.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarIdentificacion() throws InterruptedException, IOException {

        helper.waitSpinner();
        driver.findElement(saltarPreguntaDni).click();
        System.out.println("Se ha saltado la introducción de la identificación de usuario");
        new FicheroTxt().escrituraFichero("Se ha saltado la introducción de la identificación de usuario",new FicheroTxt().lecturaFichero());
        return this;

    }

    public PasosGenerales rellenarSituacionPersonal(String situacionPersonal) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (situacionPersonal) {
            case ("casado"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Casado/a "))).click();
                System.out.println("Se ha seleccionado la opción: casado.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: casado.",new FicheroTxt().lecturaFichero());
                break;
            case ("parejaHecho"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Pareja de hecho "))).click();
                System.out.println("Se ha seleccionado la opción: pareja de hecho");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: pareja de hecho",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado situacion personal.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado situacion personal.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales rellenarSituacionProfesional(String situacionProfesional) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (situacionProfesional) {
            case ("administrativo"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Administrativo "))).click();
                System.out.println("Se ha seleccionado la opción: administrativo.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: administrativo.",new FicheroTxt().lecturaFichero());
                break;
            case ("autonomo"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Autónomo "))).click();
                System.out.println("Se ha seleccionado la opción: autonomo");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: autonomo",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado situacion profesional.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado situacion profesional.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public void seleccionarFechaNacimiento(LocalDate date) throws InterruptedException, IOException {

        helper.waitSpinner();
        final By dayElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateDay, date.getDayOfMonth()));
        driver.findElement(dayElement).click();
        final By monthElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateMonth, date.getMonth().getValue()));
        driver.findElement(monthElement).click();
        final By yearElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", birthDateYear, date.getYear()));
        Actions actions = new Actions(driver);
        WebElement year = driver.findElement(yearElement);
        actions.moveToElement(year);
        driver.findElement(yearElement).click();
        System.out.println("Fecha de nacimiento seleccionada:" + date);
        new FicheroTxt().escrituraFichero("Fecha de nacimiento seleccionada:" + date,new FicheroTxt().lecturaFichero());

    }

    public PasosGenerales rellenarSexo(String sexo) throws InterruptedException, IOException {

        helper.waitSpinner();
        System.out.println("sex0:" + sexo);
        switch (sexo) {
            case ("hombre"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Hombre "))).click();
                System.out.println("Se ha seleccionado la opción: hombre.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: hombre.",new FicheroTxt().lecturaFichero());
                break;
            case ("mujer"):
                driver.findElement(By.xpath(String.format(selectorAOption, " Mujer "))).click();
                System.out.println("Se ha seleccionado la opción: mujer");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: mujer",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado ningún sexo.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado ningún sexo.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarTipoCarne(String tipoCarne) throws InterruptedException, IOException {

        helper.waitSpinner();
        switch (tipoCarne) {
            case ("A"):
                driver.findElement(By.xpath(String.format(selectorAOption, " A "))).click();
                System.out.println("Se ha seleccionado la opción: carnet tipo A.");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: carnet tipo A.",new FicheroTxt().lecturaFichero());
                break;
            case ("B"):
                driver.findElement(By.xpath(String.format(selectorAOption, " B "))).click();
                System.out.println("Se ha seleccionado la opción: carnet tipo B");
                new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: carnet tipo B",new FicheroTxt().lecturaFichero());
                break;
            default:
                System.out.println("No se ha seleccionado ningún tipo de carnet.");
                new FicheroTxt().escrituraFichero("No se ha seleccionado ningún tipo de carnet.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarPaisProcedencia() throws InterruptedException, IOException {

        helper.waitSpinner();
        driver.findElement(By.xpath(String.format(selectorAOption, " ESPAÑA "))).click();
        System.out.println("Se ha seleccionado la opción: carnet Español.");
        new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: carnet Español.",new FicheroTxt().lecturaFichero());
        return this;

    }

    public PasosGenerales seleccionarAnyoCarneConducir(LocalDate date) throws InterruptedException, IOException {

        helper.waitSpinner();
        final By yearElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", carneConducir, date.getYear()));
        driver.findElement(yearElement).click();
        System.out.println("Fecha de nacimiento seleccionada:" + date);
        new FicheroTxt().escrituraFichero("Fecha de nacimiento seleccionada:" + date,new FicheroTxt().lecturaFichero());
        return this;
    }


    public PasosGenerales seleccionarSiConduceOtro(Boolean otroConductor) throws InterruptedException, IOException {

        helper.waitSpinner();
        if (!otroConductor) {
            driver.findElement(By.xpath(String.format(selectorAOption, " No "))).click();
            System.out.println("Se ha seleccionado la opción: no hay otro conductor.");
            new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: no hay otro conductor.",new FicheroTxt().lecturaFichero());
        } else {
            driver.findElement(By.xpath(String.format(selectorAOption, " Sí "))).click();
            System.out.println("Se ha seleccionado la opción: si hay otro conductor.");
            new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: si hay otro conductor.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales seleccionarSiSeguroAnterior(Boolean seguroAnterior) throws InterruptedException, IOException {

        helper.waitSpinner();
        if (!seguroAnterior) {
            driver.findElement(By.xpath(String.format(selectorAOption, " No "))).click();
            System.out.println("Se ha seleccionado la opción: no tengo seguro anterior.");
            new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: no tengo seguro anterior.",new FicheroTxt().lecturaFichero());
        } else {
            driver.findElement(By.xpath(String.format(selectorAOption, " Sí "))).click();
            System.out.println("Se ha seleccionado la opción: si tengoseguro anteriorhay otro conductor.");
            new FicheroTxt().escrituraFichero("Se ha seleccionado la opción: si tengoseguro anteriorhay otro conductor.",new FicheroTxt().lecturaFichero());
        }
        return this;

    }

    public PasosGenerales rellenarDatosContacto() throws InterruptedException {

        helper.waitSpinner();
        String email = new Helper(driver).randomEmail();
        String telefono = new Helper(driver).randomPhoneNumber();
        driver.findElement(inputTextEmail).sendKeys(email);
        driver.findElement(inputTextPhone).sendKeys(telefono);
        driver.findElement(politicaPrivacidad).click();
        driver.findElement(buttonContinue).click();
        return this;

    }

    public PasosGenerales rellenarFechaInicio(LocalDate date) throws InterruptedException {

        helper.waitSpinner();
        driver.findElement(calendarToday).click();
        return this;

    }

    public PasosGenerales comprobarPantallaPresupuesto() throws InterruptedException, IOException {

        helper.waitSpinnerPrecio();
        Thread.sleep(2000);
        String[] numero = driver.findElement(numeroPresupuestoTxt).getText().trim().replaceAll("\\s{2,}", " ").split(" ");
        System.out.println("El número de presupuesto es: " + numero[2]);
        new FicheroTxt().escrituraFichero("El número de presupuesto es: " + numero[2],new FicheroTxt().lecturaFichero());
        return this;

    }
}
