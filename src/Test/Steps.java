package Test;

import Model.DataTestObject;
import Test.Testing.PasosGenerales;
import org.openqa.selenium.WebDriver;
import Test.Testing.SectionMiMoto;
import Test.Testing.HomePage;

import java.io.IOException;

public class Steps {
    WebDriver driver;


    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public void stepSeleccionarProducto(String producto) throws InterruptedException, IOException {
        new HomePage(driver).seleccionarProducto(producto);
    }

    public void seleccionarCamino(DataTestObject obj) throws InterruptedException, IOException {
        SectionMiMoto sm = new SectionMiMoto(driver);
        switch (obj.getProducto()) {
            case ("Moto"):
                sm.introducirMatricula(obj.isMatricula());
                sm.seleccionarFechaMatriculacion(obj.getFechaMatriculacion());
                sm.seleccionarMarca(obj.getMarca());
                sm.seleccionarCilindarada(obj.getCilindrada());
                sm.seleccionarModelo(obj.getModelo());
                sm.seleccionarVersion(obj.getVersion());
                break;
            default:
                System.out.println("No se ha seleccionado camino adecuado.");
        }

    }

    public void seleccionarPasosGenerales(DataTestObject obj) throws InterruptedException, IOException {

        PasosGenerales pg= new PasosGenerales(driver);
        pg. seleccionarMomentoCompra(obj.getMomentoCompra());
        pg.seleccionarKmAlAnyo(obj.getLeHago());
        pg.seleccionarDondeDuerme(obj.getDuerme());
        pg.seleccionarCP("28200");
        pg.seleccionarUsoHabitual(obj.getUsoHabitual());
        pg.seleccionarIdentificacion();
        pg.rellenarSituacionPersonal(obj.getSituacionPersonal());
        pg.rellenarSituacionProfesional(obj.getSituacionProfesional());
        pg.seleccionarFechaNacimiento(obj.getFechaNacimiento());
        pg.rellenarSexo(obj.getSexo());
        pg.seleccionarTipoCarne(obj.getCarne());
        pg.seleccionarPaisProcedencia();
        pg.seleccionarAnyoCarneConducir(obj.getFechaCarne());
        pg.seleccionarSiConduceOtro(obj.isOtroConductor());
        pg.seleccionarSiSeguroAnterior(obj.isSeguroAnterior());
        pg.rellenarDatosContacto();
        pg.rellenarFechaInicio(obj.getFechaInicio());
        pg.comprobarPantallaPresupuesto();

    }


}
