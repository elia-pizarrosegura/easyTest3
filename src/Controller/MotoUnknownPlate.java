package Controller;

import Data.LogInClass;
import Data.MotoVersion;
import DataBase.DatabaseHandler;
import Model.DataTestObject;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MotoUnknownPlate {
    private MainController mainControllerr;
    protected ObservableList<DataTestObject> dt1 = FXCollections.observableArrayList();
    String path;
    String producto;
    Boolean matricula;

    public MotoUnknownPlate() {
        dt1.add(new DataTestObject());
    }

    public ObservableList<DataTestObject> getDataTestObject(){
        return dt1;
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
    private DatePicker idFechaMatriculac;

    @FXML
    private TableView<MotoVersion> idTableView;

    @FXML
    private Button idRefresh;

    @FXML
    private Button idContinuar;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        setFechaMatriculacionObject();
        initMarca();
        initCilindrada();
        initModelo();

        //Tabla MotoVersion
        TableColumn marca= new TableColumn("Marca");
        marca.setCellValueFactory(new PropertyValueFactory<MotoVersion,String>("Marca"));
        TableColumn cilindrada= new TableColumn("Cilindrada");
        cilindrada.setCellValueFactory(new PropertyValueFactory<MotoVersion,String>("Cilindrada"));
        TableColumn modelo= new TableColumn("Modelo");
        modelo.setCellValueFactory(new PropertyValueFactory<MotoVersion,String>("Modelo"));
        TableColumn version= new TableColumn("Version");
        version.setCellValueFactory(new PropertyValueFactory<MotoVersion,String>("Version"));
        TableColumn anyo= new TableColumn("Anyo");
        anyo.setCellValueFactory(new PropertyValueFactory<MotoVersion,String>("Anyo"));
        idTableView.getColumns().addAll(marca,cilindrada,modelo,version,anyo);
        //Cargar la tabla con los datos de la BBDD
        List<MotoVersion> tableData= new DatabaseHandler().getMotoVersionData();
        idTableView.setItems(FXCollections.observableArrayList(tableData));

        idFechaMatriculac.setOnAction(actionEvent -> {
            LocalDate date = idFechaMatriculac.getValue();
            dt1.get(0).setFechaMatriculacion(date);
            System.out.println("La fecha de matriculación seleccionada es: " + date);
        });

        idMarca.setOnAction(actionEvent -> {
            setMarcaObject();
            idTableView.getItems().clear();
            idTableView.setItems(FXCollections.observableArrayList(getDataTable("Marca",dt1.get(0).getMarca())));
            //borra("Marca");
        });

        idCilindrada.setOnAction(actionEvent -> {
            if(idCilindrada.getSelectionModel().isSelected(0)){
                System.out.println("Por favor, seleccione un rango válido");
            }else {
                setCilindradaObject();
                idTableView.getItems().clear();
                idTableView.setItems(FXCollections.observableArrayList(getDataTable("Cilindrada", dt1.get(0).getCilindrada())));
            }
           // borra("Cilindrada");
        });

        idModelo.setOnAction(actionEvent -> {
            setModeloObject();
            idTableView.getItems().clear();
            idTableView.setItems(FXCollections.observableArrayList(getDataTable("Modelo", dt1.get(0).getModelo())));
            //borra("Modelo");
        });


        idContinuar.setOnAction(actionEvent -> {
            MotoVersion motoSeleccionada= idTableView.getSelectionModel().getSelectedItem();
            if(motoSeleccionada.getMarca().isEmpty()){
                System.out.println("No has seleccionado ninguna versión");
            }else {
                dt1.get(0).setMarca(motoSeleccionada.getMarca());
                dt1.get(0).setModelo(motoSeleccionada.getModelo());
                dt1.get(0).setCilindrada(motoSeleccionada.getCilindrada());
                dt1.get(0).setVersion(motoSeleccionada.getVersion());
                dt1.get(0).setAnyo(motoSeleccionada.getAnyo());
                System.out.println("Se ha seleccionado la version: " + dt1.get(0).getVersion());
            }
            changeScene();
        });

        idRefresh.setOnAction(actionEvent -> {
            idTableView.getItems().clear();
            idTableView.setItems(FXCollections.observableArrayList(tableData));
        });

    }

    public void borra(String noBorrar){
        switch (noBorrar){
            case("Marca"):
                idCilindrada.getSelectionModel().select(0);
                idModelo.getSelectionModel().select(0);
                System.out.println("borrar cilindrada y modelo");
                break;
            case("Cilindrada"):
                idModelo.getSelectionModel().select(0);
                idMarca.getSelectionModel().select(0);
                break;
            case("Modelo"):
                idCilindrada.getSelectionModel().select(0);
                idMarca.getSelectionModel().select(0);
                break;
            default:
                System.out.println("No se ha seleccionado un combobox que borrar.");
            }
        }


    public void initMarca() throws SQLException, ClassNotFoundException {
        ObservableList<String> marcaList = FXCollections.observableArrayList();
        marcaList.addAll("...","APRILIA", "BMV", "DERBI");
        idMarca.setItems(marcaList);
        idMarca.getSelectionModel().select(0);
    }

    public void initCilindrada() throws SQLException, ClassNotFoundException {
        ObservableList<String> cilindradaList = FXCollections.observableArrayList();
        cilindradaList.addAll("...","1-50", "51-125", "125-250");
        idCilindrada.setItems(cilindradaList);
        idCilindrada.getSelectionModel().select(0);
    }

    public void initModelo() throws SQLException, ClassNotFoundException {
        ObservableList<String> modeloList = FXCollections.observableArrayList();
        modeloList.addAll("...","SX", "RX", "C1");
        idModelo.setItems(modeloList);
        idModelo.getSelectionModel().select(0);
    }

    public List<MotoVersion> getDataTable(String filtro, String value){
        List<MotoVersion> tableData2= null;
        try {
            tableData2 = new DatabaseHandler().getMotoVersionDataFilterBy(filtro,value);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tableData2;
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

    public void setCilindradaObject() {
        String cilindrada = idCilindrada.getSelectionModel().getSelectedItem();
        dt1.get(0).setCilindrada(cilindrada);
        System.out.println("La cilindrada seleccionada es:" + cilindrada);
    }

    public void setModeloObject() {
        String modelo = idModelo.getSelectionModel().getSelectedItem();
        dt1.get(0).setModelo(modelo);
        System.out.println("El modelo seleccionada es:" + modelo);
    }

    public void transferMainObject(MainController mainController) {
        this.mainControllerr = mainController;
        dt1 = mainControllerr.getDataTestObject();
        System.out.println("nimero" + dt1.stream().count());
        producto = mainController.getDataTestObject().get(0).getProducto();
        System.out.println(producto);

    }

    public void changeScene(){

        idContinuar.getScene().getWindow().hide();
        Stage mainWindows= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/general.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindows.setTitle("easyTest");
        mainWindows.setScene(new Scene(root, 877, 569));
        mainWindows.show();

        new General().transferMainObject(this);

    }
}
