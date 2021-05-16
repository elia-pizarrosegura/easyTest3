package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MainController {

    int selectedProduct;
    int selectedPlateOption=-1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> idProduct;

    @FXML
    private ComboBox<String> idPlate;


    @FXML
    void initialize() {
        //Init product comboBox
        initProductComboBox();
        initMatriculaType();

        idProduct.setOnAction(actionEvent -> {
            selectedProduct= idProduct.getSelectionModel().getSelectedIndex();
            System.out.println(selectedProduct);
            System.out.println(selectedPlateOption);
            choosePath();
        });

        idPlate.setOnAction(actionEvent -> {
            selectedPlateOption= idPlate.getSelectionModel().getSelectedIndex();
            System.out.println(selectedPlateOption);
            choosePath();
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
        idPlate.setItems(plate);
    }

    public void choosePath(){
        if(selectedPlateOption==-1) System.out.println("Elige matricula");
        else if(selectedPlateOption==1) choosePathKnowPlate();
        else if(selectedProduct==0) choosePathMoto();
        else if(selectedProduct==1) choosePathCoche();
        else System.out.println("Error, no se ha seleccionado ningún producto");
    }

    public void choosePathMoto(){
        System.out.println("Moto matricula desconocida");
        idPlate.getScene().getWindow().hide();
        Stage mainWindows= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/motoUnknownPlate.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindows.setTitle("easyTest");
        mainWindows.setScene(new Scene(root, 500,500));
        mainWindows.show();
    }

    public void choosePathCoche(){
        System.out.println("Coche");
    }

    public void choosePathKnowPlate(){
        System.out.println("Conozco la matrícula");
    }
}

