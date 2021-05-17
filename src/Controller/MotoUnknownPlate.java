package Controller;

import Model.DataTestObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class MotoUnknownPlate {
    private MainController mainControllerr;
    protected ObservableList<DataTestObject> dt1;
    String producto;
    Boolean matricula;

    public MotoUnknownPlate() {

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
    void initialize() {


       initMarca();
        setFechaMatriculacionObject();

        idMarca.setOnAction(actionEvent -> {
            String m= setMarcaObject();
           // System.out.println(dt1.stream().count());
           // dt1.get(0).setMarca(m);
        });/*

        idFechaMatriculac.setOnAction(actionEvent -> {
            LocalDate date=idFechaMatriculac.getValue();
            dt1.get(0).setFechaMatriculacion(date);
            System.out.println(date);
        });*/



    }

    public void initMarca() {
        ObservableList<String> marcaList = FXCollections.observableArrayList();
        marcaList.addAll("Audi", "Mercedes", "Citroen");
        idMarca.setItems(marcaList);
    }

    public void setFechaMatriculacionObject(){
        idFechaMatriculac.setEditable(false);
        idFechaMatriculac.setValue(LocalDate.of(2021, Month.JANUARY,1));
       // dt1.get(0).setFechaMatriculacion(LocalDate.of(2021,01,01));
    }

    public String setMarcaObject(){
        String marca=idMarca.getSelectionModel().getSelectedItem();
        System.out.println("La marca seleccionada es: "+marca);
        return marca;
        //dt1.get(0).setModelo(marca);
    }

    public void setMainController(MainController mainController){
        this.mainControllerr= mainController;
        dt1= mainControllerr.getDataTestObject();
        System.out.println("nimero"+dt1.stream().count());
        producto= mainController.getDataTestObject().get(0).getProducto();
        System.out.println(producto);

    }
}
