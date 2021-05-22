package Controller;

import Model.MotoVersion;
import DataBase.DatabaseHandler;
import Model.DataTestObject;
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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MotoUnknownPlate {

    DataTestObject dt1 = new DataTestObject();

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
            dt1.setFechaMatriculacion(date);
            System.out.println("La fecha de matriculación seleccionada es: " + date);
        });

        idMarca.setOnAction(actionEvent -> {
            setMarcaObject();
            idTableView.getItems().clear();
            idTableView.setItems(FXCollections.observableArrayList(getDataTable("Marca",dt1.getMarca())));
            //borra("Marca");
        });

        idCilindrada.setOnAction(actionEvent -> {
            if(idCilindrada.getSelectionModel().isSelected(0)){
                System.out.println("Por favor, seleccione un rango válido");
            }else {
                setCilindradaObject();
                idTableView.getItems().clear();
                idTableView.setItems(FXCollections.observableArrayList(getDataTable("Cilindrada", dt1.getCilindrada())));
            }
           // borra("Cilindrada");
        });

        idModelo.setOnAction(actionEvent -> {
            setModeloObject();
            idTableView.getItems().clear();
            idTableView.setItems(FXCollections.observableArrayList(getDataTable("Modelo", dt1.getModelo())));
            //borra("Modelo");
        });


        idContinuar.setOnAction(actionEvent -> {
            MotoVersion motoSeleccionada= idTableView.getSelectionModel().getSelectedItem();
            if(motoSeleccionada.getMarca().isEmpty()){
                System.out.println("No has seleccionado ninguna versión");
            }else {
                dt1.setMarca(motoSeleccionada.getMarca());
                System.out.println("el producto"+ dt1.getMarca()+ motoSeleccionada.getMarca());
                dt1.setModelo(motoSeleccionada.getModelo());
                System.out.println("el producto"+ dt1.getModelo()+ motoSeleccionada.getModelo());
                dt1.setCilindrada(motoSeleccionada.getCilindrada());
                System.out.println("el producto"+ dt1.getCilindrada()+ motoSeleccionada.getCilindrada());
                dt1.setVersion(motoSeleccionada.getVersion());
                System.out.println("el producto"+ dt1.getVersion()+ motoSeleccionada.getVersion());
                dt1.setAnyo(motoSeleccionada.getAnyo());
                System.out.println("el producto"+ dt1.getVersion()+ motoSeleccionada.getVersion());
                System.out.println("Se ha seleccionado la version: " + dt1.getVersion());
            }

            insercionBBDD();
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
        dt1.setFechaMatriculacion(LocalDate.of(2021, 01,01));
    }

    public void setMarcaObject() {
        String marca = idMarca.getSelectionModel().getSelectedItem();
        dt1.setMarca(marca);
        System.out.println("La marca seleccionada es:" + marca);
        System.out.println("La producto al set marca es seleccionada es:" + dt1.getProducto());

    }

    public void setCilindradaObject() {
        String cilindrada = idCilindrada.getSelectionModel().getSelectedItem();
        dt1.setCilindrada(cilindrada);
        System.out.println("La cilindrada seleccionada es:" + cilindrada);
    }

    public void setModeloObject() {
        String modelo = idModelo.getSelectionModel().getSelectedItem();
        dt1.setModelo(modelo);
        System.out.println("El modelo seleccionada es:" + modelo);
    }

    public void insercionBBDD(){
        try {
            new DatabaseHandler().insertfechaMatricToAnyo(new DatabaseHandler().consultaIndiceDataTestObject(),
                    dt1.getFechaMatriculacion(),dt1.getMarca(),dt1.getCilindrada(),dt1.getModelo(),dt1.getVersion(),dt1.getAnyo());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    }
}
