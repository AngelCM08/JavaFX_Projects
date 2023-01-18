package com.example.tictacpuig;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    /*@FXML
    private Label title = new Label();*/
    @FXML
    private Button aceptar = new Button();
    @FXML
    private Button cancel = new Button();
    /*@FXML
    private TextField Xname = new TextField();
    @FXML
    private TextField Oname = new TextField();*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AcceptButtonAction(){
        //TODO guardado de datos para los stats.
        Stage stage = (Stage) aceptar.getScene().getWindow();
        stage.close();
    }
}
