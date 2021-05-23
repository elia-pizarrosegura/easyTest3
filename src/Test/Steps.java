package Test;

import Model.DataTestObject;
import Test.Testing.PasosGenerales;
import org.openqa.selenium.WebDriver;
import Test.Testing.SectionMiMoto;
import Test.Testing.HomePage;

public class Steps {
    WebDriver driver;


    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public void stepSeleccionarProducto(String producto) {
        new HomePage(driver).seleccionarProducto(producto);
    }

    public void seleccionarCamino(DataTestObject obj) throws InterruptedException {
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

    public void seleccionarPasosGenerales(DataTestObject obj) throws InterruptedException {

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
        pg.rellenarSexo(obj.getSexo());/*
        new SectionConductor(driver).seleccionarTipoCarne(obj.getCarne());
        new SectionConductor(driver).seleccionarPaisProcedencia();
        new SectionConductor(driver).seleccionarSiConduceOtro(obj.isOtroConductor());
        new SectionConductor(driver).seleccionarSiSeguroAnterior(obj.isSeguroAnterior());
        new SectionConductor(driver).rellenarDatosContacto();
        new SectionMiSeguro(driver).rellenarFechaInicio(obj.getFechaInicio());
        new SectionMiSeguro(driver).comprobarPantallaPresupuesto();
*/
    }


}
