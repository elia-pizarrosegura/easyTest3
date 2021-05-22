package Test;

import Model.DataTestObject;
import org.openqa.selenium.WebDriver;
import Test.Testing.*;

public class Steps{
    WebDriver driver;
    String producto;



    public Steps(WebDriver driver){
       this.driver=driver;
    }

    public void stepSeleccionarProducto(String producto){
        new HomePage(driver).seleccionarProducto(producto);
    }

    public void seleccionarCamino(DataTestObject obj) throws InterruptedException {
        switch(obj.getProducto()){
            case("Moto"):
                new SectionMiMoto(driver).introducirMatricula(obj.isMatricula());
                new SectionMiMoto(driver).seleccionarFechaMatriculacion(obj.getFechaMatriculacion());
                new SectionMiMoto(driver).seleccionarMarca(obj.getMarca());
                new SectionMiMoto(driver).seleccionarCilindarada(obj.getCilindrada());
                new SectionMiMoto(driver).seleccionarModelo(obj.getModelo());
                new SectionMiMoto(driver).seleccionarVersion(obj.getVersion());
                break;
            default:
                System.out.println("No se ha seleccionado camino adecuado.");
        }

    }/*

    public void seleccionarPasosGenerales(DataTestObject obj){
        new SectionMiMoto(driver).seleccionarMomentoCompra(obj.getMomentoCompra());
        new SectionMiMoto(driver).seleccionarKmAlAnyo(obj.getLeHago());
        new SectionMiMoto(driver).seleccionarDondeDuerme(obj.getDuerme());
        new SectionMiMoto(driver).seleccionarCP();
        new SectionMiMoto(driver).seleccionarUsoHabitual(obj.getUsoHabitual());
        new SectionMiMoto(driver).seleccionarUsoHabitual(obj.getUsoHabitual());
        new SectionSobreMi(driver).rellenarIdentificaciónCliente();
        new SectionSobreMi(driver).rellenarSituacionPersonal(obj.getSituacionPersonal());
        new SectionSobreMi(driver).rellenarSituacionProfesional(obj.getSituacionProfesional());
        new SectionSobreMi(driver).rellenarFechaNacimiento(obj.getFechaNacimiento());
        new SectionSobreMi(driver).rellenarSexo(obj.getSexo());
        new SectionConductor(driver).seleccionarTipoCarne(obj.getCarne());
        new SectionConductor(driver).seleccionarPaisProcedencia();
        new SectionConductor(driver).seleccionarSiConduceOtro(obj.isOtroConductor());
        new SectionConductor(driver).seleccionarSiSeguroAnterior(obj.isSeguroAnterior());
        new SectionConductor(driver).rellenarDatosContacto();
        new SectionMiSeguro(driver).rellenarFechaInicio(obj.getFechaInicio());
        new SectionMiSeguro(driver).comprobarPantallaPresupuesto();

    }*/



}
