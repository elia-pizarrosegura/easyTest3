package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import Model.DataTestObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class General {

    DataTestObject dt1= new DataTestObject();
    final ToggleGroup compraMotoGroup= new ToggleGroup();
    final ToggleGroup alAnyoHago= new ToggleGroup();
    final ToggleGroup duerme= new ToggleGroup();
    final ToggleGroup usoHabitual= new ToggleGroup();
    final ToggleGroup situacionPersonal= new ToggleGroup();
    final ToggleGroup situacionProfesional= new ToggleGroup();
    final ToggleGroup sexo= new ToggleGroup();
    final ToggleGroup tipoCarne= new ToggleGroup();
    final ToggleGroup conduceOtro= new ToggleGroup();
    final ToggleGroup seguroPrevio= new ToggleGroup();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane idEdad;

    @FXML
    private RadioButton idHasta1000;

    @FXML
    private RadioButton idHasta2000;

    @FXML
    private RadioButton idNoComprado1;

    @FXML
    private RadioButton idMenos3meses1;

    @FXML
    private RadioButton idEnCalle;

    @FXML
    private RadioButton idGarajeColectivo;

    @FXML
    private RadioButton idDiarioFindes;

    @FXML
    private RadioButton idSoloFines;

    @FXML
    private RadioButton idCasado;

    @FXML
    private RadioButton idParejaHecho;

    @FXML
    private RadioButton idAdministrativo;

    @FXML
    private RadioButton idAutonomo;

    @FXML
    private RadioButton idHombre;

    @FXML
    private RadioButton idMujer;

    @FXML
    private RadioButton idA;

    @FXML
    private RadioButton idB;

    @FXML
    private RadioButton idAlguiemMasConduce;

    @FXML
    private RadioButton idNoConduceAlguienMas;

    @FXML
    private RadioButton idSeguroMotoSi;

    @FXML
    private RadioButton idSeguroMotoNo;

    @FXML
    private DatePicker idFechaInicio;

    @FXML
    private DatePicker idFechaCarne;

    @FXML
    void initialize() {

        iniciarRadioButtons();
        setFechaInicio();
        setFechaCarne();

        compraMotoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idNoComprado1.isSelected()) {
                    dt1.setMomentoCompra("no comprado");
                }
                if(idMenos3meses1.isSelected()) {
                    dt1.setMomentoCompra("menos 3");
                }
            }
        });

        alAnyoHago.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idHasta1000.isSelected()) {
                    dt1.setLeHago("hasta1000");
                }
                if(idHasta2000.isSelected()) {
                    dt1.setLeHago("hasta2000");
                }
            }
        });

        duerme.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idGarajeColectivo.isSelected()) {
                    dt1.setDuerme("garaje");
                }
                if(idEnCalle.isSelected()) {
                    dt1.setDuerme("calle");
                }
            }
        });

        usoHabitual.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idSoloFines.isSelected()) {
                    dt1.setUsoHabitual("fines");
                }
                if(idDiarioFindes.isSelected()) {
                    dt1.setUsoHabitual("diarioFines");
                }
            }
        });

    }


    public void setFechaInicio() {
        idFechaInicio.setEditable(false);
        idFechaInicio.setValue(LocalDate.now());
        System.out.println("La fecha por defecto es:"+ LocalDate.now());
        dt1.setFechaInicio(LocalDate.now());
    }

    public void setFechaCarne() {
        idFechaCarne.setEditable(false);
        idFechaCarne.setValue(LocalDate.of(2015, Month.JANUARY, 1));
        System.out.println("La fecha por defecto es:" + LocalDate.of(2015, Month.JANUARY, 1));
        dt1.setFechaInicio(LocalDate.of(2015, Month.JANUARY, 1));
    }

    public void iniciarRadioButtons(){
        idNoComprado1.setToggleGroup(compraMotoGroup);
        idNoComprado1.setSelected(true);
        dt1.setMomentoCompra("no comprado");
        idMenos3meses1.setToggleGroup(compraMotoGroup);
        idHasta1000.setToggleGroup(alAnyoHago);
        idHasta1000.setSelected(true);
        dt1.setLeHago("hasta 1000");
        idHasta2000.setToggleGroup(alAnyoHago);
        idEnCalle.setToggleGroup(duerme);
        idGarajeColectivo.setToggleGroup(duerme);
        idGarajeColectivo.setSelected(true);
        dt1.setDuerme("garaje");
        idDiarioFindes.setToggleGroup(usoHabitual);
        idSoloFines.setToggleGroup(usoHabitual);
        idSoloFines.setSelected(true);
        dt1.setUsoHabitual("fines");
        idCasado.setToggleGroup(situacionPersonal);
        idCasado.setSelected(true);
        dt1.setSituacionPersonal("casado");
        idParejaHecho.setToggleGroup(situacionPersonal);
        idAdministrativo.setToggleGroup(situacionProfesional);
        idAdministrativo.setSelected(true);
        dt1.setSituacionProfesional("administrativo");
        idAutonomo.setToggleGroup(situacionProfesional);
        idHombre.setToggleGroup(sexo);
        idHombre.setSelected(true);
        dt1.setSexo("hombre");
        idMujer.setToggleGroup(sexo);
        idA.setToggleGroup(tipoCarne);
        idB.setToggleGroup(tipoCarne);
        idB.setSelected(true);
        dt1.setCarne("B");
        idSeguroMotoNo.setToggleGroup(seguroPrevio);
        idSeguroMotoNo.setSelected(true);
        dt1.setSeguroAnterior(false);
        idSeguroMotoSi.setToggleGroup(seguroPrevio);
        idNoConduceAlguienMas.setToggleGroup(conduceOtro);
        idNoConduceAlguienMas.setSelected(true);
        dt1.setSeguroAnterior(false);
        idAlguiemMasConduce.setToggleGroup(conduceOtro);
    }

    public void setEdadConductor(){

    }
}
