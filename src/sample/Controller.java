package sample;

import Data.DataHelper;
import Data.LogInClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button idLogIn;

    @FXML
    private PasswordField idPass;

    @FXML
    private TextField idUser;

    private void logIn() {
        LogInClass user1= new LogInClass("elia","elia");
        System.out.println("hola");
        System.out.println(user1.getUser() + " " + user1.getPass());
        new DataHelper().SerializeToFile(user1,"logIn");
        System.out.println("hey2");
        if (!idUser.getText().isEmpty()
        ) {
            System.out.println("log in pressssion");
        }
    }

    @FXML
    void initialize() {
        idLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                logIn();
            }
        });

    }
}
