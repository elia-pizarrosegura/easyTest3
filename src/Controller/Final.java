package Controller;

import javafx.fxml.FXML;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Final {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea idPanel;

    @FXML
    private javafx.scene.control.Button idContinuar;

    @FXML
    void initialize()  {
        initPanelView();

        idContinuar.setOnAction(actionEvent -> {
        /*    try {
                new SeleniumMain();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        });
    }

    public void initPanelView() {
      //  idPanel.append("Pulse continuar para iniciar el test");
    }



}
