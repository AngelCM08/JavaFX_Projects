package com.example.tictacpuig;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutController {
    @FXML
    private final Button aceptar = new Button();

    @FXML
    private void AcceptButtonAction(){
        Stage stage = (Stage) aceptar.getScene().getWindow();
        stage.close();
    }
}
