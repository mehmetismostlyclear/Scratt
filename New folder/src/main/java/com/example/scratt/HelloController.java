package com.example.scratt;

import com.example.scratt.Controller.ScreenWriterController;
import com.example.scratt.Services.CreateGameBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;

public class HelloController {
    public TextField createGameText;
    @FXML
    private Label welcomeText;
    @FXML
    private Button createGameBtn;
    @FXML
    private Button newGameBtn;
/// enum şeklinde yaz sonradan
    public static boolean gameType;
    public static String gameLetters;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void nGameBtnClick(ActionEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource() == createGameBtn){
            gameLetters = createGameText.getText();
            gameType = false;
            fxmlLoader();
        }
        else if(mouseEvent.getSource() == newGameBtn){

            gameType = true;
            fxmlLoader();
        }
    }
    private void fxmlLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GAMEpage2.fxml"));
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(fxmlLoader.load(), 450, 450));
        stage.show();
    }
}
