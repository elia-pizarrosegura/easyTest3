package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.DataTestObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class General {

    private MotoUnknownPlate controler;
    protected ObservableList<DataTestObject> dt1 = FXCollections.observableArrayList();
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

    public General() {
        dt1.add(new DataTestObject());
    }
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
    private DatePicker idFechaInicio1;

    @FXML
    void initialize() {
        idNoComprado1.setToggleGroup(compraMotoGroup);
        idNoComprado1.setSelected(true);
        idMenos3meses1.setToggleGroup(compraMotoGroup);
        idHasta1000.setToggleGroup(alAnyoHago);
        idHasta1000.setSelected(true);
        idHasta2000.setToggleGroup(alAnyoHago);
        idEnCalle.setToggleGroup(duerme);
        idGarajeColectivo.setToggleGroup(duerme);
        idGarajeColectivo.setSelected(true);
        idDiarioFindes.setToggleGroup(usoHabitual);
        idSoloFines.setToggleGroup(usoHabitual);
        idSoloFines.setSelected(true);
        idCasado.setToggleGroup(situacionPersonal);
        idCasado.setSelected(true);
        idParejaHecho.setToggleGroup(situacionPersonal);
        idAdministrativo.setToggleGroup(situacionProfesional);
        idAdministrativo.setSelected(true);
        idAutonomo.setToggleGroup(situacionProfesional);
        idHombre.setToggleGroup(sexo);
        idHombre.setSelected(true);
        idMujer.setToggleGroup(sexo);
        idA.setToggleGroup(tipoCarne);
        idB.setToggleGroup(tipoCarne);
        idB.setSelected(true);
        idSeguroMotoNo.setToggleGroup(seguroPrevio);
        idSeguroMotoNo.setSelected(true);
        idSeguroMotoSi.setToggleGroup(seguroPrevio);
        idNoConduceAlguienMas.setToggleGroup(conduceOtro);
        idNoConduceAlguienMas.setSelected(true);
        idAlguiemMasConduce.setToggleGroup(conduceOtro);

    }

    public void transferMainObject(MotoUnknownPlate controler) {
        this.controler = controler;
        dt1 = controler.getDataTestObject();
        System.out.println("nimero" + dt1.stream().count());

    }
}
