package Controller;

import Model.LogInClass;
import DataBase.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class logInController {

    @FXML
    private Button idLogIn;

    @FXML
    private PasswordField idPass;

    @FXML
    private TextField idUser;

    @FXML
    private TextField idUserSignIn;

    @FXML
    private PasswordField idPassSignIn;

    @FXML
    private Button idLogInSignIn;

    @FXML
    void initialize() {

        idLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    logIn();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        idLogInSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    signIn();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void logIn() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("log in press");

        DatabaseHandler databaseHandler = new DatabaseHandler();
        LogInClass userDDBB = databaseHandler.getLogInData(idUser.getText());

        if (!idUser.getText().trim().equals(userDDBB.getUser().trim()) && !idPass.getText().trim().equals(userDDBB.getPass().trim())) {
            if (idUser.getText().isEmpty() || idPass.getText().isEmpty()) {
                System.out.println("User or pass is not filled.");
            } else {
                System.out.println("User or pass is incorrect");
            }
        } else {
            accessGranted();

        }

    }


    private void signIn() throws SQLException, ClassNotFoundException, IOException {
        DatabaseHandler databaseHandler2 = new DatabaseHandler();
        //Identify if usser is already in DDBB
        LogInClass userDDBB = databaseHandler2.getLogInData(idUserSignIn.getText());
        if(!userDDBB.getUser().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El usuario ya está registrado en la base de datos");
            alert.showAndWait();
        }
        if (!idUserSignIn.getText().isEmpty() && !idPassSignIn.getText().isEmpty()) {
            databaseHandler2.insertSignIn(idUserSignIn.getText(), idPassSignIn.getText());
            accessGranted();
        }
    }

    private void accessGranted() throws IOException {
        System.out.println("Access granted");
        //Hide the current window
        idLogIn.getScene().getWindow().hide();
        //Define the new window
        Stage mainWindows = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/firstStage.fxml"));
        mainWindows.setTitle("easyTest");
        mainWindows.setScene(new Scene(root, 877, 569));

        mainWindows.show();
    }
}
