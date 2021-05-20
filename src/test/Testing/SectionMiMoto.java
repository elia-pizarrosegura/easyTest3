package test.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectionMiMoto {

    WebDriver driver;

    public SectionMiMoto(WebDriver driver){
        this.driver=driver;
    }

    public void introducirMatricula(String option) throws InterruptedException {

        new Helper(driver).handleCookieComplianceDialog();

        switch (option) {
            case "no conozco":
                driver.findElement(By.cssSelector("a[data-layer-click='{\"concoceMatricula\":\"N\"}']")).click();
                break;
            case "rematriculada":
                driver.findElement(By.cssSelector("a[data-layer-click='{\"tipoMatricula\":\"OTROTIPO\"}']")).click();
                break;
            default:
                System.out.println("No se ha seleccionado ninguna opción de matrícula válida.");
        }
        new Helper(driver).waitSpinner();

    }
}
