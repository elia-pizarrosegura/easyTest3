package Controller;

import Data.DataHelper;
import Data.LogInClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class logInController {

    @FXML
    private Button idLogIn;

    @FXML
    private PasswordField idPass;

    @FXML
    private TextField idUser;

    private void logIn() throws IOException {
        System.out.println("log in press");
        LogInClass user2= (LogInClass) new DataHelper().deSerializeFromFileToObject("logIn");
        System.out.println(user2.getUser()+" "+user2.getPass());
        if(!idUser.getText().equals(user2.getUser()) && !idPass.getText().equals(user2.getPass())){
            if (idUser.getText().isEmpty() || idPass.getText().isEmpty()) {
                System.out.println("User or pass is not filled.");
            }else{
                System.out.println("User or pass is incorrect");
            }
        }else{
            System.out.println("Access granted");
            //Hide the current window
            idLogIn.getScene().getWindow().hide();
            //Define the new window
            Stage mainWindows= new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/main.fxml"));
            mainWindows.setTitle("easyTest");
            mainWindows.setScene(new Scene(root, 500,500));
            mainWindows.show();

        }
    }

    @FXML
    void initialize() {
        idLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    logIn();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
