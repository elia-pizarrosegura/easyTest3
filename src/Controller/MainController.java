package Controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.DatabaseHandler;
import Model.DataTestObject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController  {

    int selectedProduct;
    String producto;
    int selectedPlateOption=-1;
    String path;
    private ObservableList<DataTestObject> dt1= FXCollections.observableArrayList();

    public MainController(){

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
    private ComboBox<String> idProduct;

    @FXML
    private ComboBox<String> idMatricula;

    @FXML
    private Button idContinuar1;


    @FXML
    void initialize() {
        //Init product comboBox
        initProductComboBox();
        initMatriculaType();

        idProduct.setOnAction(actionEvent -> {
            selectedProduct= idProduct.getSelectionModel().getSelectedIndex();
            System.out.println(selectedProduct);
            initProductComboBox();
            dt1.get(0).setProducto(idProduct.getSelectionModel().getSelectedItem());

            choosePath();
        });

        idMatricula.setOnAction(actionEvent -> {
            selectedPlateOption= idMatricula.getSelectionModel().getSelectedIndex();
            System.out.println(selectedPlateOption);
            if(selectedProduct==0)  dt1.get(0).setMatricula(false);
            else if(selectedProduct==1) dt1.get(0).setMatricula(true);
            choosePath();
        });

        idContinuar1.setOnAction(actionEvent -> {
            changeScene();
        });

    }

    public void initProductComboBox(){
        ObservableList<String> products= FXCollections.observableArrayList();
        products.addAll("Moto","Coche");
        idProduct.setItems(products);
    }

    public void initMatriculaType(){
        ObservableList<String> plate= FXCollections.observableArrayList();
        plate.addAll("No conozco la matrícula","Conozco la mátricula");
        idMatricula.setItems(plate);

    }

    public void choosePath(){
        if(selectedPlateOption==-1) System.out.println("Elige matricula");
        else if(selectedPlateOption==1) {
            System.out.println("camino  conozco matricula");
        }
        else if(selectedProduct==0) {
            System.out.println("camino moto");
            path="../View/motoUnknownPlate.fxml";
        }
        else if(selectedProduct==1) {
            System.out.println("camino coche");
        }
        else System.out.println("Error, no se ha seleccionado ningún producto");
    }

    public void changeScene(){

        idContinuar1.getScene().getWindow().hide();
        Stage mainWindows= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindows.setTitle("easyTest");
        mainWindows.setScene(new Scene(root, 877, 569));
        mainWindows.show();

        new MotoUnknownPlate().transferMainObject(this);

    }

}

