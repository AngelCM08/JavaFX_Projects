package com.example.tictacpuig;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TicTacPuigController implements Initializable {
    boolean darkTheme = false;

    @FXML
    private Button button1 = new Button();
    @FXML
    private Button button2 = new Button();
    @FXML
    private Button button3 = new Button();
    @FXML
    private Button button4 = new Button();
    @FXML
    private Button button5 = new Button();
    @FXML
    private Button button6 = new Button();
    @FXML
    private Button button7 = new Button();
    @FXML
    private Button button8 = new Button();
    @FXML
    private Button button9 = new Button();

    @FXML
    private Button resetGame = new Button();


    ToggleGroup tg = new ToggleGroup();
    @FXML
    private RadioButton cvc;
    @FXML
    private RadioButton pvc;
    @FXML
    private RadioButton pvp;

    @FXML
    private Label result;

    Player player1;
    Player player2;

    ArrayList<Button> game_buttons;
    ArrayList<RadioButton> gameType_buttons;
    private boolean player1Turn = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game_buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,
                                                button4,button5,button6,
                                                button7,button8,button9));
        game_buttons.forEach(button ->{
            setupButton(button);
            button.setDisable(true);
            button.setFocusTraversable(false);
        });

        gameType_buttons = new ArrayList<>(Arrays.asList(cvc,pvc,pvp));
        gameType_buttons.forEach(b -> b.setToggleGroup(tg));
    }

    @FXML
    void restartGame(){
        game_buttons.forEach(this::resetButton);
        result.setText("");
        resetGame.setVisible(false);
    }

    @FXML
    void closeGame(){
        Platform.exit();
    }

    @FXML
    void startGame(){
        gameType_buttons.forEach(button -> {
            if(button.isSelected()){
                switch (button.getId()){
                    case "cvc":
                        player1 = new Player(true, "X");
                        player2 = new Player(true, "O");
                        cvc();
                        break;
                    case "pvp":
                        player1 = new Player(false, "X");
                        player2 = new Player(false, "O");
                        pvp();
                        break;
                    /*case "pvc":
                        player1 = new Player(false, "X");
                        player2 = new Player(true, "O");
                        pvc();
                        break;*/
                }
            }
        });
    }

    private void pvp() {
        enableButtons();
    }

    private void cvc() {
        while(!checkIfGameIsOver()){
            setPlayerSymbol(Computer.selectButton(game_buttons));
        }
        resetGame.setVisible(true);
        stopGame();
    }

    /*private void pvc() {
        enableButtons();
        while(!checkIfGameIsOver()){
            if(changePlayerTurn()){
                setPlayerSymbol();
            } else{
                setPlayerSymbol(Computer.selectButton(game_buttons));
            }
        }
    }*/

    public void enableButtons(){
        game_buttons.forEach(button ->{
            button.setDisable(false);
        });
    }

    public void resetButton(Button button){
        button.setDisable(true);
        button.setText("");
    }

    public void stopGame(){
        game_buttons.forEach(button -> button.setDisable(true));
    }

    private void setupButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            if(checkIfGameIsOver()) {
                stopGame();
                FiPartida();
                resetGame.setVisible(true);
            }
        });
    }

    /*public boolean changePlayerTurn(){
        boolean turn = player1Turn;
        player1Turn = !player1Turn;
        return turn;
    }*/

    public void setPlayerSymbol(Button button){
        if(player1Turn){
            button.setText(player1.symbol);
            player1Turn = false;
        } else{
            button.setText(player2.symbol);
            player1Turn = true;
        }
    }

    public boolean checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if(line.equals("XXX")){
                result.setText("X won!");
                return true;
            }

            //O winner
            else if(line.equals("OOO")){
                result.setText("O won!");
                return true;
            } else if((button1.getText() + button2.getText() + button3.getText()
                    + button4.getText() + button5.getText() + button6.getText()
                    + button7.getText() + button8.getText() + button9.getText())
                    .split("").length == 9){
                result.setText("Draw!");
            }
        }
        return false;
    }

    public void FiPartida(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Results.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Results!");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void About(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("About.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 100);
            Stage stage = new Stage();
            stage.setTitle("About");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void Theme(){
        if(darkTheme){
            button1.getScene().getStylesheets().remove(getClass().getResource("application.css").toExternalForm());
            darkTheme = false;
        }else{
            button1.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            darkTheme = true;
        }

    }
}