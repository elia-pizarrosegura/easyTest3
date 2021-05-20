package test.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectionMiMoto {

    WebDriver driver;

    public SectionMiMoto(WebDriver driver){
        this.driver=driver;
    }

    public void introducirMatricula(Boolean matricula) throws InterruptedException {

        new Helper(driver).handleCookieComplianceDialog();

        if(matricula) {
            driver.findElement(By.cssSelector("a[data-layer-click='{\"concoceMatricula\":\"N\"}']")).click();
        }else{
                System.out.println("No se ha seleccionado ninguna opción de matrícula válida.");
        }
        new Helper(driver).waitSpinner();

    }
}
