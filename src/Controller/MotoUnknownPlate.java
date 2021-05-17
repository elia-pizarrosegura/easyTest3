package Controller;

import Data.LogInClass;
import DataBase.DatabaseHandler;
import Model.DataTestObject;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;

public class MotoUnknownPlate {
    private MainController mainControllerr;
    protected ObservableList<DataTestObject> dt1 = FXCollections.observableArrayList();
    ;
    String producto;
    Boolean matricula;

    public MotoUnknownPlate() {
        dt1.add(new DataTestObject());
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> idMarca;

    @FXML
    private ComboBox<String> idCilindrada;

    @FXML
    private ComboBox<String> idModelo;

    @FXML
    private ComboBox<String> idVersion;

    @FXML
    private DatePicker idFechaMatriculac;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {


        initMarca();
        setFechaMatriculacionObject();

        idFechaMatriculac.setOnAction(actionEvent -> {
            LocalDate date = idFechaMatriculac.getValue();
            dt1.get(0).setFechaMatriculacion(date);
            System.out.println("La fecha de matriculación seleccionada es: " + date);
        });

        idMarca.setOnAction(actionEvent -> {
            setMarcaObject();

        });

        idCilindrada.setOnAction(actionEvent -> {

        });

    }

    public void initMarca() throws SQLException, ClassNotFoundException {
        ObservableList<String> marcaList = FXCollections.observableArrayList();
        marcaList.addAll("APRILIA", "BMW", "DERBI");
        idMarca.setItems(marcaList);
        Bindings.bindContentBidirectional(marcaList,getCilindradaList());
    }

    public ObservableList<String> getCilindradaList() throws SQLException, ClassNotFoundException {

        ObservableList<String> cilindradasTipos= (ObservableList<String>) new DatabaseHandler().getCilindradaList(dt1.get(0).getMarca());
        idMarca.setItems(cilindradasTipos);
        return cilindradasTipos;
    }

    public void initModelo() {
        ObservableList<String> marcaList = FXCollections.observableArrayList();

    }

    public void initVersion() {
        ObservableList<String> marcaList = FXCollections.observableArrayList();
        marcaList.addAll("Eléctrica", "1-50", "51 a 125");
        idMarca.setItems(marcaList);
    }

    public void setFechaMatriculacionObject() {
        idFechaMatriculac.setEditable(false);
        idFechaMatriculac.setValue(LocalDate.of(2021, Month.JANUARY, 1));
        System.out.println("La fecha por defecto es: 2021-01-01");
        dt1.get(0).setFechaMatriculacion(LocalDate.of(2021, 01, 01));
    }

    public void setMarcaObject() {
        String marca = idMarca.getSelectionModel().getSelectedItem();
        dt1.get(0).setMarca(marca);
        System.out.println("La marca seleccionada es:" + marca);
    }

    public void setMainController(MainController mainController) {
        this.mainControllerr = mainController;
        dt1 = mainControllerr.getDataTestObject();
        System.out.println("nimero" + dt1.stream().count());
        producto = mainController.getDataTestObject().get(0).getProducto();
        System.out.println(producto);

    }
}
