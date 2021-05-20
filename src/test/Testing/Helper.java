package test.Testing;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    WebDriver driver;
    private final By cookieComplianceLayer = By.cssSelector("div[id='onetrust-banner-sdk']");
    private final By cookieComplianceAcceptButton = By.cssSelector("button[id='onetrust-accept-btn-handler']");

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void handleCookieComplianceDialog() {
        if (!driver.findElement(cookieComplianceLayer).isDisplayed()) {
            return;
        }
        String display = driver.findElement(cookieComplianceLayer).getCssValue("display");

        if (display == null || !display.equals("none")) {
            driver.findElement(cookieComplianceAcceptButton).click();
        }
    }

    public void waitSpinner() throws InterruptedException {
        int i = 0;
        while (i < 90) {
            if (driver.findElement(By.cssSelector(".backprocess")).isDisplayed()) {
                driver.wait(2000);
                i++;
            } else {
                break;
            }
        }
        if (i == 90) {
            Assert.fail("Error, el cuadro de espera ha estado presente durante mas de 90 segundos");
        }
    }

    public List<String> listarPasosPorProductos(String producto) {
        List<String> listaPasos = new ArrayList<>();
        switch (producto) {
            case ("Moto"):
                listaPasos.add("seleccionarFechaMatriculacion");
                listaPasos.add("seleccionarMarca");
                listaPasos.add("seleccionarCilindrada");
                listaPasos.add("seleccionarModelo");
                listaPasos.add("seleccionarVersion");
                break;
            default:
                System.out.println("No se ha seleccionado producto adecuado para obtener lista de pasos");
        }
        //Lista pasos comunes.
        listaPasos.add("momentoCompra");
        listaPasos.add("alAnyoHago");
        listaPasos.add("duerme");
        listaPasos.add("duerme");
        listaPasos.add("insertarCP");
        listaPasos.add("usoHabitual");
        listaPasos.add("seleccionarIdentificacionPersonal");
        listaPasos.add("seleccionarSituacionPersonal");
        listaPasos.add("seleccionarSituacionProfesional");
        listaPasos.add("seleccionarFechaNacimiento");
        listaPasos.add("seleccionarSexo");
        listaPasos.add("seleccionarTipoCarne");
        listaPasos.add("seleccionarPaisProcedencia");
        listaPasos.add("seleccionarAnyoObtencionCarne");
        listaPasos.add("seleccionarSiMotoConduceOtro");
        listaPasos.add("seleccionarSiTengoSeguroAnterior");
        listaPasos.add("rellenarEmailTelefono");
        listaPasos.add("rellenarEmailTelefono");
        listaPasos.add("seleccionarFechaInicio");
        listaPasos.add("comprobarPantallaPresupuesto");

        return listaPasos;

    }
}
