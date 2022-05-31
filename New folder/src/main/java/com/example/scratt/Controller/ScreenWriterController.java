package com.example.scratt.Controller;

import com.example.scratt.Services.CreateGameBuilder;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.Console;
import java.io.FileNotFoundException;

public class ScreenWriterController {
    @FXML private Text centerletter;
    @FXML private Text letter0;
    @FXML private Text letter1;
    @FXML private Text letter2;
    @FXML private Text letter3;
    @FXML private Text letter4;
    @FXML private Text letter5;

    public ScreenWriterController() throws FileNotFoundException {


    }
    @FXML public void handleSubmitAction(ActionEvent event) throws FileNotFoundException {
        CreateGameBuilder cr = new CreateGameBuilder();
        cr.generateRandomLetters();
        centerletter.setText(String.valueOf(cr.centerLetter));
        System.out.println(cr.gameletters);
        letter0.setText(String.valueOf(cr.gameletters.charAt(0)));
        letter1.setText(String.valueOf(cr.gameletters.charAt(1)));
        letter2.setText(String.valueOf(cr.gameletters.charAt(2)));
        letter3.setText(String.valueOf(cr.gameletters.charAt(3)));
        letter4.setText(String.valueOf(cr.gameletters.charAt(4)));
        letter5.setText(String.valueOf(cr.gameletters.charAt(5)));
    }

}

