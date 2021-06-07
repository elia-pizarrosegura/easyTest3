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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        System.out.println("introducido"+idUser.getText());
        System.out.println("consulta:"+ userDDBB.getUser());

        if(idUser.getText().isEmpty()|| idPass.getText().isEmpty()) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El usuario o la pass no se ha rellenado. Por favor, introducelo de nuevo.");
            alert.showAndWait();
            System.out.println("El usuario o la pass no se ha rellenado. Por favor, introducelo de nuevo.");
        }else if(userDDBB.getUser()==null){
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El usuario no está registrado en la bbdd o es incorrecto.");
                alert.showAndWait();
                System.out.println("El usuario no está registrado en la bbdd o es incorrecto.");
        }else if (!idPass.getText().trim().equals(userDDBB.getPass().trim())) {
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("La contraseña es incorrecto");
                    alert.showAndWait();
                    System.out.println("La contraseña es incorrecto");
        }else {
                accessGranted();

            }
        }




    private void signIn() throws SQLException, ClassNotFoundException, IOException {
        DatabaseHandler databaseHandler2 = new DatabaseHandler();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        //Identify if usser is already in DDBB
        LogInClass userDDBB = databaseHandler2.getLogInData(idUserSignIn.getText());
        if (userDDBB.getUser() == null) {
            //el usuario que se ha introducido no está en la bbdd
            System.out.println("prueba" + userDDBB.getUser());
            userDDBB.setUser("");
        }
        if (idUserSignIn.getText().isEmpty() || idPassSignIn.getText().isEmpty()) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Se ha dejado la contraseña o el usuario  en blanco");
            alert.showAndWait();
        } else if (userDDBB.getUser().equalsIgnoreCase(idUserSignIn.getText())) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El usuario ya está registrado en la base de datos");
            alert.showAndWait();
        } else {
            databaseHandler2.insertSignInn(idUserSignIn.getText(), idPassSignIn.getText());
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
