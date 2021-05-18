package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.DataTestObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class General {

    private MotoUnknownPlate controler;
    protected ObservableList<DataTestObject> dt1 = FXCollections.observableArrayList();

    public General() {
        dt1.add(new DataTestObject());
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton idNoComprado;

    @FXML
    private RadioButton idMenos3meses;

    @FXML
    void initialize() {


    }

    public void transferMainObject(MotoUnknownPlate controler) {
        this.controler = controler;
        dt1 = controler.getDataTestObject();
        System.out.println("nimero" + dt1.stream().count());

    }
}
