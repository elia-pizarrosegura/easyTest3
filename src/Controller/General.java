package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import DataBase.DatabaseHandler;
import Model.DataTestObject;
import Test.SeleniumMain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class General {

    DataTestObject dt1= new DataTestObject();
    final ToggleGroup compraMotoGroup= new ToggleGroup();
    final ToggleGroup alAnyoHago= new ToggleGroup();
    final ToggleGroup duerme= new ToggleGroup();
    final ToggleGroup usoHabitual= new ToggleGroup();
    final ToggleGroup situacionPersonal= new ToggleGroup();
    final ToggleGroup situacionProfesional= new ToggleGroup();
    final ToggleGroup sexo= new ToggleGroup();
    final ToggleGroup tipoCarne= new ToggleGroup();
    final ToggleGroup conduceOtro= new ToggleGroup();
    final ToggleGroup seguroPrevio= new ToggleGroup();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton idHasta1000;

    @FXML
    private RadioButton idHasta2000;

    @FXML
    private RadioButton idNoComprado1;

    @FXML
    private RadioButton idMenos3meses1;

    @FXML
    private RadioButton idEnCalle;

    @FXML
    private RadioButton idGarajeColectivo;

    @FXML
    private RadioButton idDiarioFindes;

    @FXML
    private RadioButton idSoloFines;

    @FXML
    private RadioButton idCasado;

    @FXML
    private RadioButton idParejaHecho;

    @FXML
    private RadioButton idAdministrativo;

    @FXML
    private RadioButton idAutonomo;

    @FXML
    private RadioButton idHombre;

    @FXML
    private RadioButton idMujer;

    @FXML
    private RadioButton idA;

    @FXML
    private RadioButton idB;

    @FXML
    private RadioButton idAlguiemMasConduce;

    @FXML
    private RadioButton idNoConduceAlguienMas;

    @FXML
    private RadioButton idSeguroMotoSi;

    @FXML
    private RadioButton idSeguroMotoNo;

    @FXML
    private DatePicker idFechaInicio;

    @FXML
    private DatePicker idFechaCarne;

    @FXML
    private DatePicker idFechaNacimiento;

    @FXML
    private Button idContinuar;

    @FXML
    void initialize() {

        iniciarRadioButtons();
        setFechaInicio();
        setFechaCarne();
        setFechaNacimiento();

        idFechaInicio.setOnAction(actionEvent -> {
                LocalDate date = idFechaInicio.getValue();
                dt1.setFechaInicio(date);
                System.out.println("La fecha de inicio seleccionada es: " + date);
        });

        idFechaCarne.setOnAction(actionEvent -> {
            LocalDate date = idFechaCarne.getValue();
            dt1.setFechaCarne(date);
            System.out.println("La fecha de carné seleccionada es: " + date);
        });

        idFechaNacimiento.setOnAction(actionEvent -> {
            LocalDate date = idFechaNacimiento.getValue();
            dt1.setFechaInicio(date);
            System.out.println("La fecha de nacimiento seleccionada es: " + date);
        });

        idContinuar.setOnAction(actionEvent -> {
            insercionBBDD();
            changeScene();
        });

        compraMotoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idNoComprado1.isSelected()) {
                    dt1.setMomentoCompra("no comprado");
                }
                if(idMenos3meses1.isSelected()) {
                    dt1.setMomentoCompra("menos 3");
                }
            }
        });

        alAnyoHago.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idHasta1000.isSelected()) {
                    dt1.setLeHago("hasta 1000");
                }
                if(idHasta2000.isSelected()) {
                    dt1.setLeHago("hasta 2000");
                }
            }
        });

        duerme.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idGarajeColectivo.isSelected()) {
                    dt1.setDuerme("garaje");
                }
                if(idEnCalle.isSelected()) {
                    dt1.setDuerme("calle");
                }
            }
        });

        usoHabitual.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idSoloFines.isSelected()) {
                    dt1.setUsoHabitual("fines");
                }
                if(idDiarioFindes.isSelected()) {
                    dt1.setUsoHabitual("diarioFines");
                }
            }
        });

        situacionPersonal.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idCasado.isSelected()) {
                    dt1.setSituacionPersonal("casado");
                }
                if(idParejaHecho.isSelected()) {
                    dt1.setSituacionPersonal("parejaHecho");
                }
            }
        });

        situacionProfesional.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idAdministrativo.isSelected()) {
                    dt1.setSituacionProfesional("administrativo");
                }
                if(idAutonomo.isSelected()) {
                    dt1.setSituacionProfesional("autonomo");
                }
            }
        });

        sexo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idHombre.isSelected()) {
                    dt1.setSexo("hombre");
                }
                if(idMujer.isSelected()) {
                    dt1.setSexo("mujer");
                }
            }
        });

        tipoCarne.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idA.isSelected()) {
                    dt1.setCarne("A");
                }
                if(idB.isSelected()) {
                    dt1.setCarne("B");
                }
            }
        });

        seguroPrevio.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idSeguroMotoNo.isSelected()) {
                    dt1.setSeguroAnterior(false);
                }
                if(idSeguroMotoSi.isSelected()) {
                    dt1.setSeguroAnterior(true);
                }
            }
        });

        conduceOtro.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("Ha cambiado la seleccion:" +((RadioButton) compraMotoGroup.getSelectedToggle()).getText());
                if(idNoConduceAlguienMas.isSelected()) {
                    dt1.setOtroConductor(false);
                }
                if(idAlguiemMasConduce.isSelected()) {
                    dt1.setOtroConductor(true);
                }
            }
        });

    }


    public void setFechaInicio() {
        idFechaInicio.setEditable(false);
        idFechaInicio.setValue(LocalDate.now());
        System.out.println("La fecha por defecto es:"+ LocalDate.now());
        dt1.setFechaInicio(LocalDate.now());
    }

    public void setFechaCarne() {
        idFechaCarne.setEditable(false);
        idFechaCarne.setValue(LocalDate.of(2015, Month.JANUARY, 1));
        System.out.println("La fecha por defecto es:" + LocalDate.of(2015, Month.JANUARY, 1));
        dt1.setFechaCarne(LocalDate.of(2015, Month.JANUARY, 1));
    }

    public void setFechaNacimiento() {
        idFechaNacimiento.setEditable(false);
        idFechaNacimiento.setValue(LocalDate.of(1984, Month.JANUARY, 1));
        System.out.println("La fecha por defecto es:" + LocalDate.of(1984, Month.JANUARY, 1));
        dt1.setFechaNacimiento(LocalDate.of(1984, Month.JANUARY, 1));
    }

    public void iniciarRadioButtons(){
        idNoComprado1.setToggleGroup(compraMotoGroup);
        idNoComprado1.setSelected(true);
        dt1.setMomentoCompra("no comprado");
        idMenos3meses1.setToggleGroup(compraMotoGroup);

        idHasta1000.setToggleGroup(alAnyoHago);
        idHasta1000.setSelected(true);
        dt1.setLeHago("hasta 1000");
        idHasta2000.setToggleGroup(alAnyoHago);

        idEnCalle.setToggleGroup(duerme);
        idGarajeColectivo.setToggleGroup(duerme);
        idGarajeColectivo.setSelected(true);
        dt1.setDuerme("garaje");

        idDiarioFindes.setToggleGroup(usoHabitual);
        idSoloFines.setToggleGroup(usoHabitual);
        idSoloFines.setSelected(true);
        dt1.setUsoHabitual("fines");

        idCasado.setToggleGroup(situacionPersonal);
        idCasado.setSelected(true);
        dt1.setSituacionPersonal("casado");
        idParejaHecho.setToggleGroup(situacionPersonal);

        idAdministrativo.setToggleGroup(situacionProfesional);
        idAdministrativo.setSelected(true);
        dt1.setSituacionProfesional("administrativo");
        idAutonomo.setToggleGroup(situacionProfesional);

        idHombre.setToggleGroup(sexo);
        idHombre.setSelected(true);
        dt1.setSexo("hombre");
        idMujer.setToggleGroup(sexo);

        idA.setToggleGroup(tipoCarne);
        idB.setToggleGroup(tipoCarne);
        idB.setSelected(true);
        dt1.setCarne("B");

        idSeguroMotoNo.setToggleGroup(seguroPrevio);
        idSeguroMotoSi.setToggleGroup(seguroPrevio);
        idSeguroMotoNo.setSelected(true);
        dt1.setSeguroAnterior(false);

        idAlguiemMasConduce.setToggleGroup(conduceOtro);
        idNoConduceAlguienMas.setToggleGroup(conduceOtro);
        idNoConduceAlguienMas.setSelected(true);
        dt1.setOtroConductor(false);

    }

    public void insercionBBDD(){
        try {
            new DatabaseHandler().insertarDatosGenerales(new DatabaseHandler().consultaIndiceDataTestObject(),
                    dt1.getMomentoCompra(),dt1.getLeHago(),dt1.getDuerme(),dt1.getUsoHabitual(),dt1.getSituacionPersonal(),dt1.getSituacionProfesional(),
            dt1.getSexo(),dt1.getCarne(),dt1.isSeguroAnterior(),dt1.isOtroConductor(),dt1.getFechaInicio(),
                    dt1.getFechaCarne(),dt1.getFechaNacimiento());
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
            root = FXMLLoader.load(getClass().getResource("../View/final.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindows.setTitle("easyTest");
        mainWindows.setScene(new Scene(root, 877, 569));
        mainWindows.show();

    }

}
