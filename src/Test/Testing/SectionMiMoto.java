package Test.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SectionMiMoto {

    WebDriver driver;
    Helper helper = new Helper(driver);
    private final String bikeRegistrationMonth = "#matriz_MO_VEH_MESDMATR";
    private final String bikeRegistrationYear = "#matriz_MO_VEH_ANNDMATR";
    private final String marcaBtn="a[data-layer-click='{\"marca\":\"%s\"}']";
    private String cilindradaOption="//a[contains(text(),'%s')]";
    private String marcaOption="//a[contains(text(),'%s')]";
    private String versionOption="//a/span[contains(text(),'%s')]";

    public SectionMiMoto(WebDriver driver){
        this.driver=driver;
    }

    public SectionMiMoto introducirMatricula(Boolean matricula) throws InterruptedException {

       // new Helper(driver).handleCookieComplianceDialog();
        System.out.println(matricula);
        //Thread.sleep(3000);
        //helper.waitSpinner();


        if(!matricula) {
            driver.findElement(By.cssSelector("a[data-layer-click='{\"concoceMatricula\":\"N\"}']")).click();
            System.out.println("Se ha seleccionado la poción matricula desconocida");
        }else{
                System.out.println("No se ha seleccionado ninguna opción de matrícula válida.");
        }
        //new Helper(driver).waitSpinner();
        return this;

    }

    public void seleccionarFechaMatriculacion(LocalDate date) throws InterruptedException {

        final By monthElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", bikeRegistrationMonth, date.getMonth().getValue()));
        helper.waitForPageToLoad(driver,monthElement);
        helper.waitSpinner();

        //final By monthElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", bikeRegistrationMonth, date.getMonth().getValue()));
        driver.findElement(monthElement).click();
        final By yearElement = By.cssSelector(String.format("%s span.mtzvalue[data-value=\"%s\"]", bikeRegistrationYear, date.getYear()));
        driver.findElement(yearElement).click();
        System.out.println("Fecha matriculación seleccionada:"+ date);

    }

    public SectionMiMoto seleccionarMarca(String marca) throws InterruptedException {
        helper.waitForPageToLoad(driver,By.cssSelector(String.format(marcaBtn, marca)));
        helper.waitSpinner();
        driver.findElement(By.cssSelector(String.format(marcaBtn, marca))).click();
        System.out.println("Se ha seleccionado la marca:"+ marca);
        return this;
    }

    public SectionMiMoto seleccionarCilindarada(String cilindrada) throws InterruptedException{


        helper.waitSpinner();

        switch (cilindrada) {
            case "1-50":
                By locator=By.xpath(String.format(cilindradaOption," Desde 1cc hasta 50cc "));
                helper.waitForPageToLoad(driver,locator);
                driver.findElement(locator).click();
                System.out.println("Se ha seleccionado el rango de cilindrada: "+ cilindrada);
                break;
            case "51-125":
                By locator2=By.xpath(String.format(cilindradaOption," Desde 51 hasta 125cc "));
                helper.waitForPageToLoad(driver,locator2);
                driver.findElement(locator2).click();
                System.out.println("Se ha seleccionado el rango de cilindrada: "+ cilindrada);
                break;
            case "125-250":
                By locator3=By.xpath(String.format(cilindradaOption," Desde 126 hasta 250cc "));
                helper.waitForPageToLoad(driver,locator3);
                driver.findElement(locator3).click();
                System.out.println("Se ha seleccionado el rango de cilindrada: "+ cilindrada);
                break;
            default:
                System.out.println("No se ha seleccionado ninguna cilindrada");
        }
        return this;
    }

    public SectionMiMoto seleccionarModelo(String modelo) throws InterruptedException{
        By locator=By.xpath(String.format(marcaOption, modelo));
        helper.waitSpinner();
        helper.waitForPageToLoad(driver,locator);
        driver.findElement(locator).click();
        System.out.println("Se ha seleccionado el modelo:"+  modelo);
        return this;
    }

    public SectionMiMoto seleccionarVersion(String version) throws InterruptedException{
        By locator=By.xpath(String.format(versionOption, version));
        helper.waitSpinner();
        helper.waitForPageToLoad(driver,locator);
        driver.findElement(locator).click();
        System.out.println("Se ha seleccionado el modelo:"+  version);
        return this;
    }
}
