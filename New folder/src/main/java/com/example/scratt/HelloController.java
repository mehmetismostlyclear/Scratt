package com.example.scratt;

import com.example.scratt.Controller.ScreenWriterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button createGameBtn;
    @FXML
    private Button newGameBtn;

    ScreenWriterController SWC = new ScreenWriterController();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void nGameBtnClick(ActionEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource() == createGameBtn){
            SWC.checkGameType(true);
        }
        else if(mouseEvent.getSource() == newGameBtn){
            SWC.checkGameType(false);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GAMEpage2.fxml"));
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(fxmlLoader.load(), 450, 450));
        stage.show();
        ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
    }
}
